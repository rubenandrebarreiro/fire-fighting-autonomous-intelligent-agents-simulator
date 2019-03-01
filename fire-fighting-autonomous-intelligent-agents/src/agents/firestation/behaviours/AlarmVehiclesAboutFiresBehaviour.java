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

package agents.firestation.behaviours;

import java.util.Vector;

import agents.firestation.FireStationAgent;
import jade.core.behaviours.DataStore;
import jade.lang.acl.ACLMessage;
import jade.proto.ContractNetInitiator;
import utils.configuration.Config;

/**
 * The class responsible for the Alarm Vehicles About Fires Behaviour.
 */
public class AlarmVehiclesAboutFiresBehaviour extends ContractNetInitiator {

	// Constants/Invariants:

	/**
	 * The default UID of the Alarm Vehicles About Fires Behaviour.
	 */
	private static final long serialVersionUID = 1L;
	
	
	// Global Instance Variables:
	
	/**
	 * The CFP/Alarm Detected Fire ACL Message.
	 */
	private ACLMessage detectedFireACLMessage;
	
	/**
	 * The number of Vehicles that can respond to this Behaviour/Contract Net Protocol Initiator.
	 */
	public int numVehicleResponders = Config.NUM_MAX_VEHICLES;
	
	
	// Constructors:
	
	/**
	 * Constructor #1 of the Alarm Vehicles About Fires Behaviour.
	 * 
	 * @param fireStationAgent the Fire Station Agent responsible for this behaviour
	 * @param detectedFireACLMessage the CFP/Alarm Detected Fire ACL Message associated to this behaviour
	 * @param detectedFireMessagesDataStore the Data Store where the CFP/Alarm Detected Fire ACL Message will be kept
	 */
	public AlarmVehiclesAboutFiresBehaviour(FireStationAgent fireStationAgent, ACLMessage detectedFireACLMessage,
													DataStore detectedFireMessagesDataStore) {
		
		super(fireStationAgent, detectedFireACLMessage, detectedFireMessagesDataStore);
	}
	
	
	// Methods/Functions:
	
	/**
	 * Returns a vector of CFP/Alarm Detected Fire ACL Messages.
	 * 
	 * @param detectedFireACLMessage the CFP/Alarm Detected Fire ACL Message
	 * 
	 * @return a vector of CFP/Alarm Detected Fire ACL Messages
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected Vector prepareDetectedFireACLMessages(ACLMessage detectedFireACLMessage) {
		
		//if(GraphicUserInterface.isActive())
			//GraphicUserInterface.log("Preparing ACL Messages related to the detected Fire...\n");
		//else
			System.out.print("Preparing ACL Messages related to the detected Fire...\n");
		
		Vector messagesVector = new Vector();		

		messagesVector.add(this.detectedFireACLMessage);
		
		return messagesVector;
	}
}
