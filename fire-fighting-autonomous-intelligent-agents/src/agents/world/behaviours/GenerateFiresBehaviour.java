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

package agents.world.behaviours;

import java.awt.Point;
import java.util.Map;

import agents.world.WorldAgent;
import jade.core.behaviours.TickerBehaviour;
import utils.configuration.Config;
import world.map.WorldObject;
import world.map.utils.WorldObjectType;
import world.nature.Fire;

/**
 * The class responsible for the Generate Fires Behaviour.
 */
public class GenerateFiresBehaviour extends TickerBehaviour {

	// Constants/Invariants:

	/**
	 * The default UID of the Generate Fires Behaviour.
	 */
	private static final long serialVersionUID = 1L;

	
	// Global Instance Variables:
	
	/**
	 * The World Agent responsible for this Generate Fires Behaviour and
	 * to generate Fires in some random and available positions/points in the World's map/grid.
	 */
	public WorldAgent worldAgent;
	
	
	// Constructors:
	
	/**
	 * Constructor #1 of the Generate Fires Behaviour.
	 * 
	 * @param worldAgent the World Agent responsible for this Generate Fires Behaviour
	 * @param tryToGenerateFiresPeriod TODO
	 */
	public GenerateFiresBehaviour(WorldAgent worldAgent, long tryToGenerateFiresPeriod) {
		super(worldAgent, tryToGenerateFiresPeriod);
		
		this.worldAgent = worldAgent;
	}
	
	
	// Methods/Functions:
	
	/**
	 * All the operations needed to be made during all the calls of this Generate Fires Behaviour.
	 * 
	 * TODO
	 */
	@Override
	protected void onTick() {

		// It's possible to add a Fire to the World's map/grid
		if(this.worldAgent.getNumCurrentlyActiveFires() < Config.NUM_MAX_FIRES) {
		   	
			int[] firePosition = worldAgent.generateRandomPosition();
		    	
		   	WorldObject fireWorldObject = new WorldObject(WorldObjectType.FIRE, new Point(firePosition[0], firePosition[1]));
		    
		   	Map<Integer, Fire> fires = worldAgent.getCurrentlyActiveFires();
		   	
		   	Fire fire = new Fire((fires.size() + 1), fireWorldObject);
		    
		   	// Add, effectively, the Fire to the World
		   	worldAgent.addFire(firePosition[0], firePosition[1], fire);	
	    }
	}
}
