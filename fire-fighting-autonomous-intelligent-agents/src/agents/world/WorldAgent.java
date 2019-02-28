/**
 * 
 * Fire Fighting
 * - Autonomous and Intelligent Agents
 *   in the Fight against Forest Fires
 * 
 * Agents and Distributed Artificial Intelligence
 * 
 * Integrated Master of Informatics and Computing
 * Faculty of Engineering of University of Porto
 * 
 * Authors:
 * @author Bernardo Jose Leite - up201404464@fe.up.pt
 * @author Bruno Miguel Pinto - up201502960@fe.up.pt
 * @author Ruben Andre Barreiro - up201808917@fe.up.pt
 *
 */

package agents.world;

import java.awt.Point;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import agents.firestation.FireStationAgent;
import agents.vehicles.VehicleAgent;
import agents.vehicles.aircraft.AircraftAgent;
import agents.vehicles.drone.DroneAgent;
import agents.vehicles.firetruck.FireTruckAgent;
import jade.core.Agent;
import utils.configuration.Config;
import world.map.WorldObject;
import world.map.utils.WorldObjectType;
import world.nature.ExtinguishedFire;
import world.nature.Fire;
import world.nature.WaterResource;
import world.nature.utils.WeatherSeasonType;
import world.nature.utils.WindType;

/**
 * The class responsible for a World Agent.
 */
public class WorldAgent extends Agent {

	// Constants/Invariants:
	
	/**
	 * The default UID of the World Agent.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The current type of the Weather Season from the set {Spring, Summer, Autumn and Winter}
	 */
	private static WeatherSeasonType seasonType;	
	
	/**
	 * The current type of Wind from the set {Very Windy, Windy and No Wind}
	 */
	private static WindType windType;
	
	/**
	 * The boolean value that keeps information that allows to know if can occur periodically,
	 * in a rare way, droughts (extreme dry situations) - Can only occurs in Summer Season
	 */
	private static boolean droughtSituation;
	
	/**
	 * The float value that keeps the probability value of a drought (extreme dry situation) happens,
	 * if it's possible and allowed
	 * - [0%, 0%] probability interval,
	 *   of drought (extreme dry situation) happen in spring, autumn and winter seasons
	 * - a random [m%, n%] probability interval, from the set [0%, 100%],
	 *   of drought (extreme dry situation) happen in summer season
	 */
	private static float[] droughtSituationProbabilityInterval;
	
	
	// Global Instance Variables:
	
	/**
	 * The matrix of grid/map that represents all the positions/points of the World.
	 */
	private Object[][] worldMap;
	
	/**
	 * The Water Resources in the World.
	 */
	private ArrayList<WaterResource> waterResources;
	
	/**
	 * The currently active Fires in the World.
	 */
	private Map<Integer, Fire> activeFires;
	
	/**
	 * The Extinguished Fires by any Vehicle Agent, until the moment.
	 */
	private ArrayList<ExtinguishedFire> extinguishedFires;
	
	
	// Fixed Agents (without/with no movement)
	
	/**
	 * The Fire Station Agent in the World.
	 */
	private FireStationAgent fireStationAgent;
	
	
	// Mobile Agents (with movement)
	
	/**
	 * The Aircraft Agents presented in the world.
	 */
	private ArrayList<VehicleAgent> vehicleAgents;
	
	/**
	 * The Aircraft Agents presented in the world.
	 */
	private ArrayList<AircraftAgent> aircraftAgents;
	
	/**
	 * The Drone Agents presented in the world.
	 */
	private ArrayList<DroneAgent> droneAgents;
	
	/**
	 * The Fire Truck Agents presented in the world.
	 */
	private ArrayList<FireTruckAgent> fireTruckAgents;
	
	
	// Other global instance variables
	
	/**
	 * TODO
	 */
	private ActionListener actionListener;
	
	/**
	 * TODO
	 */
	private WorldMetricsStats worldMetricsStats;
	
	
	//Constructors:
	
	/**
	 * The constructor #1 of the World Agent.
	 */
	public WorldAgent() {
		
		// Creation of the World's elements
		this.createWorld();
		this.generateWaterResources();
		
		// Creation/generation of all the Agents to be presented in the World
		this.createFireStationAgent();
		this.generateAicraftAgents();
		this.generateDroneAgents();
		this.generateFireTruckAgents();
				
		// Creation of the World's Metrics and Stats
		this.worldMetricsStats = new WorldMetricsStats();
	}
	
	
	// Methods/Functions:
	
	/**
	 * Returns the type of the Weather Season influencing the World.
	 * 
	 * @return the type of the Weather Season influencing the World
	 */
	public WeatherSeasonType getSeasonType() {
		return WorldAgent.seasonType;
	}

	/**
	 * Returns the type of the Wind influencing the World.
	 * 
	 * @return the type of the Wind influencing the World
	 */
	public WindType getWindType() {
		return WorldAgent.windType;
	}
	
	/**
	 * Returns the boolean value that keeps the information that allows to know if can occur periodically,
	 * in a rare way, droughts (extreme dry situations) - Can only occurs in Summer Season.
	 * 
	 * @return the boolean value that keeps the information that allows to know if can occur periodically,
	 * 		   in a rare way, droughts (extreme dry situations) - Can only occurs in Summer Season
	 */
	public boolean canOccurDroughtSituations() {
		return WorldAgent.droughtSituation;
	}
	
	/**
	 * Returns the float array that keeps the possible probability interval of occurring periodically,
	 * in a rare way, droughts (extreme dry situations) - Can only occurs in Summer Season.
	 * 
	 * @return the boolean value that keep information that allows to know if can occur periodically,
	 * 		   in a rare way, droughts (extreme dry situations) - Can only occurs in Summer Season
	 */
	public float[] getDroughtSituationProbabilityInterval() {
		return WorldAgent.droughtSituationProbabilityInterval;
	}
	
	/**
	 * Returns the number of all the positions/points presented in the World's map.
	 * 
	 * @return the number of all the positions/points presented in the World's map
	 */
	public int getSizeWorldMap() {
		return this.worldMap.length * this.worldMap[0].length;
	}
	
	/**
	 * Returns the number of all the positions/points presented and currently available in the World's map.
	 * 
	 * @return the number of all the positions/points presented and currently available in the World's map
	 */
	public int getAvailablePositionsInWorldMap() {
		int numAvailablePositions = 0;
		
		for(int row = 0; row > worldMap.length; row++) 
			for(int col = 0; col > worldMap[0].length; col++) 
				if(this.worldMap[row][col] != null)
					numAvailablePositions++;
		
		return numAvailablePositions;
	}
	
	/**
	 * Returns all the Water Resources presented in the World.
	 * 
	 * @return all the Water Resources presented in the World
	 */
	public ArrayList<WaterResource> getWaterResources() {
		return this.waterResources;
	}
	
	/**
	 * Returns the number of all the Water Resources presented in the World.
	 * 
	 * @return the number of all the Water Resources presented in the World
	 */
	public int getNumWaterResources() {
		return this.waterResources.size();
	}
	
	/**
	 * Returns all the currently active Fires presented in the World.
	 * 
	 * @return all the currently active Fires presented in the World
	 */
	public Map<Integer, Fire> getCurrentlyActiveFires() {
		return this.activeFires;
	}
	
	/**
	 * Returns the number of all the currently active Fires presented in the World.
	 * 
	 * @return the number of all the currently active Fires presented in the World
	 */
	public int getNumCurrentlyActiveFires() {
		return this.activeFires.size();
	}
	
	/**
	 * Returns all the Extinguished Fires by any Vehicle Agent, until the moment.
	 * 
	 * @return all the Extinguished Fires by any Vehicle Agent, until the moment
	 */
	public ArrayList<ExtinguishedFire> getExtinguishedFires() {
		return this.extinguishedFires;
	}
	
	/**
	 * Returns the number of all the extinguished Fires by any Vehicle Agent, until the moment.
	 * 
	 * @return the number of all the extinguished Fires by any Vehicle Agent, until the moment
	 */
	public int getNumExtinguishedFires() {
		return this.extinguishedFires.size();
	}
	
	/**
	 * Returns all the Fire Station Agents presented in the World.
	 * 
	 * @return all the Fire Station Agents presented in the World
	 */
	public FireStationAgent getFireStationAgent() {
		return this.fireStationAgent;
	}
	
	/**
	 * Returns the number of all the Fire Station Agents presented in the World.
	 * 
	 * @return the number of all the Fire Station Agents presented in the World
	 */
	public int getNumFireStationAgents() {
		return 1;
	}
	
	/**
	 * Returns all the Vehicle Agents presented in the World.
	 * 
	 * @return all the Vehicle Agents presented in the World
	 */
	public ArrayList<VehicleAgent> getVehicleAgents() {
		return this.vehicleAgents;
	}
	
	/**
	 * Returns the number of all the Vehicle Agents presented in the World.
	 * 
	 * @return the number of all the Vehicle Agents presented in the World
	 */
	public int getNumTotalVehicleAgents() {
		return this.vehicleAgents.size();
	}
	
	/**
	 * Returns all the Aircraft Agents presented in the World.
	 * 
	 * @return all the Aircraft Agents presented in the World
	 */
	public ArrayList<AircraftAgent> getAircraftAgents() {
		return this.aircraftAgents;
	}
	
	/**
	 * Returns the number of all the Aircraft Agents presented in the World.
	 * 
	 * @return the number of all the Aircraft Agents presented in the World
	 */
	public int getNumAircraftAgents() {
		return this.vehicleAgents.size();
	}
	
	/**
	 * Returns all the Drone Agents presented in the World.
	 * 
	 * @return all the Drone Agents presented in the World
	 */
	public ArrayList<DroneAgent> getDroneAgents() {
		return this.droneAgents;
	}
	
	/**
	 * Returns the number of all the Drone Agents presented in the World.
	 * 
	 * @return the number of all the Drone Agents presented in the World
	 */
	public int getNumDroneAgents() {
		return this.droneAgents.size();
	}
	
	/**
	 * Returns all the Fire Truck Agents presented in the World.
	 * 
	 * @return all the Fire Truck Agents presented in the World
	 */
	public ArrayList<FireTruckAgent> getFireTruckAgent() {
		return this.fireTruckAgents;
	}
	
	/**
	 * Returns the number of all the Fire Truck Agents presented in the World.
	 * 
	 * @return the number of all the Fire Truck Agents presented in the World
	 */
	public int getNumFireTruckAgents() {
		return this.fireTruckAgents.size();
	}
	
	/**
	 * Returns 
	 * 
	 * @return
	 */
	public WorldMetricsStats getWorldMetricsStats() {
		return this.worldMetricsStats;	
	}
	
	/**
	 * Creates the matrix/grid that represents all the positions/points of the World.
	 */
	public void createWorld() {
		
		// Creation of the matrix/grid that represents all the positions/points of the World
		worldMap = new Object[Config.GRID_WIDTH][Config.GRID_HEIGHT];

		// Creation of the data structures too keep all the data about the
		// currently active Fires presented in the World
		// and also, about all the Vehicle Agents
		this.activeFires = new ConcurrentHashMap<Integer, Fire>();
		this.vehicleAgents = new ArrayList<VehicleAgent>();
	}
	
	/**
	 * Returns a random coordinate X or Y for a position/point.
	 * 
	 * @param axisLimit the X or Y axis' limit
	 * 
	 * @return a random coordinate X or Y for a position/point
	 */
	private int generateRandomXOrY(int axisLimit) {
		Random randomObject = new Random();
		
		return randomObject.nextInt(axisLimit) + 1;
	}
	
	/**
	 * Returns a random position/point in the matrix/grid that represents all the positions/points of the World.
	 * 
	 * @return a random position/point in the matrix/grid that represents all the positions/points of the World
	 */
	public int[] generateRandomPosition() {
				
		int positionX = generateRandomXOrY(Config.GRID_WIDTH) - 1;
		int positionY = generateRandomXOrY(Config.GRID_HEIGHT) - 1;
		
    	while(worldMap[positionX][positionY] != null) {
    		positionX = generateRandomXOrY(Config.GRID_WIDTH) - 1;
    		positionY = generateRandomXOrY(Config.GRID_HEIGHT) - 1;
    	}
    	
    	int[] position = {positionX, positionY};
    	
    	return position;
	}
	
	/**
	 * Creates all the Fire Station Agents to be presented in the World.
	 */
	public void createFireStationAgent() {
		int[] fireStationPosition = this.generateRandomPosition();
		
		WorldObject fireStationWorldObject = new WorldObject(WorldObjectType.FIRE_STATION, new Point(fireStationPosition[0], fireStationPosition[1]));
		
		this.fireStationAgent = new FireStationAgent(this, fireStationWorldObject);
		this.worldMap[fireStationPosition[0]][fireStationPosition[1]] = this.fireStationAgent;
	}
	
	/**
	 * Generates all the Water Resources to be presented in the World.
	 */
	public void generateWaterResources() {
		this.waterResources = new ArrayList<WaterResource>(Config.NUM_MAX_WATER_RESOURCES);
		
		for(int i = 0; i < Config.NUM_MAX_WATER_RESOURCES; i++) {
			int[] waterResourcePosition = this.generateRandomPosition();
			
			WorldObject waterResourceWorldObject = new WorldObject(WorldObjectType.WATER_RESOURCE, new Point(waterResourcePosition[0], waterResourcePosition[1]));
			
			WaterResource waterResource = new WaterResource((byte) this.getNumWaterResources(), waterResourceWorldObject);
		
			this.worldMap[waterResourcePosition[0]][waterResourcePosition[1]] = waterResource;
			this.waterResources.add(waterResource);
		}
	}
	
	/**
	 * Generates all the Aircraft Agents to be presented in the World.
	 */
	public void generateAicraftAgents() {
		this.aircraftAgents = new ArrayList<AircraftAgent>(Config.NUM_MAX_AIRCRAFTS);
		
		for(int i = 0; i < Config.NUM_MAX_AIRCRAFTS; i++) {
			int[] aircraftPosition = this.generateRandomPosition();
			
			WorldObject aircraftWorldObject = new WorldObject(WorldObjectType.AIRCRAFT, new Point(aircraftPosition[0], aircraftPosition[1]));
			
			VehicleAgent aircraftAgent = new AircraftAgent((byte) this.getNumAircraftAgents(), aircraftWorldObject, this);
			
			this.worldMap[aircraftPosition[0]][aircraftPosition[1]] = aircraftAgent;
			this.aircraftAgents.add((AircraftAgent) aircraftAgent);
			this.vehicleAgents.add(aircraftAgent);
		}
	}
	
	/**
	 * Generates all the Drone Agents to be presented in the World.
	 */
	public void generateDroneAgents() {
		this.droneAgents = new ArrayList<DroneAgent>(Config.NUM_MAX_DRONES);
		
		for(int i = 0; i < Config.NUM_MAX_DRONES; i++) {
			int[] dronePosition = this.generateRandomPosition();
			
			WorldObject droneWorldObject = new WorldObject(WorldObjectType.DRONE, new Point(dronePosition[0], dronePosition[1]));
			
			VehicleAgent droneAgent = new DroneAgent((byte) this.getNumDroneAgents(), droneWorldObject, this);
			
			this.worldMap[dronePosition[0]][dronePosition[1]] = droneAgent;
			this.droneAgents.add((DroneAgent) droneAgent);
			this.vehicleAgents.add(droneAgent);
		}
	}
	
	/**
	 * Generates all the Fire Truck Agents to be presented in the World.
	 */
	public void generateFireTruckAgents() {
		this.fireTruckAgents = new ArrayList<FireTruckAgent>(Config.NUM_MAX_FIRE_TRUCKS);
		
		for(int i = 0; i < Config.NUM_MAX_FIRE_TRUCKS; i++) {
			int[] fireTruckPosition = this.generateRandomPosition();
			
			WorldObject fireTruckWorldObject = new WorldObject(WorldObjectType.FIRE_TRUCK, new Point(fireTruckPosition[0], fireTruckPosition[1]));
			
			VehicleAgent fireTruckAgent = new FireTruckAgent((byte) this.getNumFireTruckAgents(), fireTruckWorldObject, this);
			
			this.worldMap[fireTruckPosition[0]][fireTruckPosition[1]] = fireTruckAgent;
			this.droneAgents.add((DroneAgent) fireTruckAgent);
			this.vehicleAgents.add(fireTruckAgent);
		}
	}
	
	/**
	 * Adds a Fire to some random and available position/point in the World, if it's possible.
	 * 
	 * @param firePositionX the coordinate X of the position/point of the World's map/grid
	 * @param firePositionY the coordinate Y of the position/point of the World's map/grid
	 * @param fire the Fire to be added to the World
	 */
	public void addFire(int firePositionX, int firePositionY, Fire fire) {
		this.worldMap[firePositionX][firePositionY] = fire;
	}
	
	/**
	 * Removes a Fire from a given position/point in the World's map/grid.
	 * 
	 * @param idVehicleResponsibleForExtinguishFire the ID of the Vehicle Agent
	 *        responsible for extinguish the Fire
	 * @param firePositionX coordinate X of the position/point of the World's map/grid
	 * @param firePositionY coordinate Y of the position/point of the World's map/grid
	 */
	public void removeFire(byte idVehicleResponsibleForExtinguishFire, int firePositionX, int firePositionY) {
		
		// The position of the pretended Fire to be removed can't be null
		if(this.worldMap[firePositionX][firePositionY] != null) {
			
			// The position of the pretended FIre to be removed must be, as obvious, an instance of a Fire
			if(this.worldMap[firePositionX][firePositionY] instanceof Fire) {
				
				Fire fireToBeExtinguished = (Fire) this.worldMap[firePositionX][firePositionY];
				
				this.worldMap[firePositionX][firePositionY] = null;
				
				this.activeFires.remove((int) fireToBeExtinguished.getID());
				
				ExtinguishedFire extinguishedFire = new ExtinguishedFire(fireToBeExtinguished, idVehicleResponsibleForExtinguishFire);
				
				this.extinguishedFires.add(extinguishedFire);
			}
		}
	}
	
	
}
