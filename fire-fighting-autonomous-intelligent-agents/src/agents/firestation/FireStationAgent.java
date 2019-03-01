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
	 * Returns the basic information to be displayed in a graphic user interface about the Fire Station Agent.
	 */
	@Override
	public String toString() {
		return "FS | HQ";
	}	
}
