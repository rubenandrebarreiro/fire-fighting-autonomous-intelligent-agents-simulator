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

package agents.firestation;

import jade.core.Agent;
import world.map.WorldObject;

/**
 * The class responsible for the Fire Station Agent.
 */
public class FireStationAgent extends Agent {

	// Constants/Invariants:
	
	/**
	 * The default UID of the Fire Station Agent.
	 */
	private static final long serialVersionUID = 1L;
	
	
	// Global Instance Variables:
	
	/**
	 * The World's object of the Fire Station Agent.
	 */
	private WorldObject worldObject;
	
	
	// Constructors:
	
	/**
	 * Constructor #1 of the Fire Station Agent.
	 * 
	 * Creates a Fire Station Agent, initialising its world object.
	 * 
	 * @param worldObject the World's object of the Fire Station Agent
	 */
	public FireStationAgent(WorldObject worldObject) {	
		this.worldObject = worldObject;
	}
	
	
	// Methods/Functions:
	
	/**
	 * Returns the World's object of the Fire Station Agent.
	 * 
	 * @return the World's object of the Fire Station Agent
	 */
	public WorldObject getWorldObject() {
		return this.worldObject;
	}
	
	/**
	 * Returns the names of the Vehicle Agents presented in the World.
	 * 
	 * @param numTotalVehicleAgents the total number of Vehicle Agents presented in the World
	 * 
	 * @return the names of the Vehicle Agents presented in the World
	 */
	public static Object[] getVehiclesAgentsNames(int numTotalVehicleAgents) {
		
		Object[] vehicleAgentsNames = new Object[numTotalVehicleAgents];
		
		// The Available Vehicle Agents
		for(int i = 0; i < numTotalVehicleAgents; i++)
			vehicleAgentsNames[i] = "Vehicle Agent " + i;
		
		return vehicleAgentsNames;
	}
	
	/**
	 * Returns the names of the Aircraft Agents presented in the World.
	 * 
	 * @param numAircraftAgents the number of Aircraft Agents presented in the World
	 * 
	 * @return the names of the Aircraft Agents presented in the World
	 */
	public static Object[] getAircraftAgentsNames(int numAircraftAgents) {
		
		Object[] aircraftAgentsNames = new Object[numAircraftAgents];
		
		// The Available Aircraft Agents
		for(int i = 0; i < numAircraftAgents; i++)
			aircraftAgentsNames[i] = "Aircraft Agent " + i;
		
		return aircraftAgentsNames;
	}
	
	/**
	 * Returns the names of the Drone Agents presented in the World.
	 * 
	 * @param numDroneAgents the number of Drone Agents presented in the World
	 * 
	 * @return the names of the Drone Agents presented in the World
	 */
	public static Object[] getDroneAgentsNames(int numDroneAgents) {
		
		Object[] droneAgentsNames = new Object[numDroneAgents];
		
		// The Available Drone Agents
		for(int i = 0; i < numDroneAgents; i++)
			droneAgentsNames[i] = "Drone Agent " + i;
		
		return droneAgentsNames;
	}
	
	/**
	 * Returns the names of the Fire Truck Agents presented in the World.
	 * 
	 * @param numFireTruckAgents the number of Drone Agents presented in the World
	 * 
	 * @return the names of the Fire Truck Agents presented in the World
	 */
	public static Object[] getFireTruckAgentsNames(int numFireTruckAgents) {
		
		Object[] fireTruckAgentsNames = new Object[numFireTruckAgents];
		
		// The Available Fire Truck Agents
		for(int i = 0; i < numFireTruckAgents; i++)
			fireTruckAgentsNames[i] = "Fire Truck Agent " + i;
		
		return fireTruckAgentsNames;
	}
	
	/**
	 * Returns the basic information to be displayed in a graphic user interface about the Fire Station Agent.
	 */
	@Override
	public String toString() {
		return "FS | HQ";
	}	
}
