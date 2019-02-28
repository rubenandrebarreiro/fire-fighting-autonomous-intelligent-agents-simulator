/**
 * 
 * Fire Fighting - Autonomous Intelligent Agents
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

import java.awt.event.ActionListener;
import java.util.ArrayList;

import agents.firestation.FireStationAgent;
import agents.vehicles.aircraft.AircraftAgent;
import agents.vehicles.drone.DroneAgent;
import agents.vehicles.firetruck.FireTruckAgent;
import jade.core.Agent;
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
	 * The matrix of grid/map that represents all the positions of the world.
	 */
	private Object[][] worldMap;
	
	
	// Fixed agents (without/no movement)
	/**
	 * The Fire Station Agent in the world.
	 */
	private FireStationAgent fireStationAgent;
	
	/**
	 * The Water Resources in the world.
	 */
	private WaterResource[] waterResources;
	
	
	// Mobile agents (with movement)
	
	/**
	 * The Aircraft Agents presented in the world.
	 */
	private AircraftAgent[] aircraftAgents;
	
	/**
	 * The Drone Agents presented in the world.
	 */
	private DroneAgent[] droneAgents;
	
	/**
	 * The Fire Truck Agents presented in the world.
	 */
	private FireTruckAgent[] fireTruckAgents;
	
	
	// Independent agents (without/no movement)
	
	/**
	 * The current fires in the world.
	 */
	private ArrayList<Fire> fires;
	
	/*
	 * The number of water resources in the world.
	 */
	private int numWaterResources;
	
	/*
	 * The current number of aircrafts in the world.
	 */
	private  int currentNumAircrafts;
	
	/*
	 * The current number of fires in the world.
	 */
	private int currentNumFires;
	
	private ActionListener actionListener;
	
	private WorldMetricsStats worldMetricsStats;
}
