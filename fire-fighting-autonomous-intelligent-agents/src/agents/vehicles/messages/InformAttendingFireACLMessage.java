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

package agents.vehicles.messages;

import jade.lang.acl.ACLMessage;

/**
 * The class responsible for the CFP/Inform Attending Fire ACL Message.
 */
public class InformAttendingFireACLMessage extends ACLMessage {
	
	// Constants/Invariants:

	/**
	 * The default UID of the CFP/Inform Attending Fire ACL Message.
	 */
	private static final long serialVersionUID = 1L;
	
	
	// Global Instance Variables:
	
	/**
	 * The CFP/Inform Attending Fire ACL Message.
	 */
	private ACLMessage informAttendingFireACLMessage;
	
	
	// Constructors:
	
	/**
	 * 
	 * 
	 * @param informAttendingFireACLMessage
	 */
	public InformAttendingFireACLMessage(ACLMessage informAttendingFireACLMessage) {
		super(ACLMessage.INFORM);
		
		this.informAttendingFireACLMessage = informAttendingFireACLMessage;
		
		this.setInformAttendingFireACLMessage();
	}
	
	
	// Methods/Functions:
	
	/**
	 * Returns the CFP/Inform Attending Fire ACL Message.
	 * 
	 * @return the CFP/Inform Attending Fire ACL Message
	 */
	public ACLMessage getInformAttendingFireACLMessage() {
		return this.informAttendingFireACLMessage;
	}
	
	/**
	 * Sets and configures the CFP/Inform Attending Fire ACL Message,
	 * to be sent to the Fire Station Agent, informing that the Vehicle Agent responsible for
	 * this message is attending a Fire.
	 */
	private void setInformAttendingFireACLMessage() {
		this.informAttendingFireACLMessage.setPerformative(ACLMessage.INFORM);
	}
}
