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
 * The class responsible for the CFP/Alarm Detected Fire ACL Proposal/Response Message.
 */
public class AlarmDetectedFireACLProposalResponseMessage extends ACLMessage {

	// Constants/Invariants:

	/**
	 * The default UID of the CFP/Alarm Detected Fire ACL Proposal/Response Message.
	 */
	private static final long serialVersionUID = 1L;
	
	
	// Global Instance Variables:
	
	/**
	 * The CFP/Alarm Detected Fire ACL Proposal/Response Message.
	 */
	private ACLMessage detectedFireACLProposalResponseMessage;
	
	/**
	 * The proposal value associated to the CFP/Alarm Detected Fire ACL Proposal/Response Message.
	 */
	private int proposalToAttendFire;
	
	
	// Constructors:
	
	/**
	 * 
	 */
	public AlarmDetectedFireACLProposalResponseMessage(ACLMessage detectedFireProposalResponseMessage, int proposalToAttendFire) {
		super(ACLMessage.PROPOSE);
		
		this.detectedFireACLProposalResponseMessage = detectedFireProposalResponseMessage;
		this.proposalToAttendFire = proposalToAttendFire;
		
		this.setDetectedFireACLResponseMessage();
	}
	
	
	// Methods/Functions:
	
	/**
	 * Returns the CFP/Alarm Detected Fire ACL Proposal/Response Message.
	 * 
	 * @return the CFP/Alarm Detected Fire ACL Proposal/Response Message
	 */
	public ACLMessage getDetectedFireACLResponseMessage() {
		return this.detectedFireACLProposalResponseMessage;
	}
	
	/**
	 * Returns the proposal value associated to the CFP/Alarm Detected Fire ACL Proposal/Response Message.
	 * 
	 * @return the proposal value associated to the CFP/Alarm Detected Fire ACL Proposal/Response Message
	 */
	public int getProposalToAttendFire() {
		return this.proposalToAttendFire;
	}
	
	/**
	 * Sets and configures the CFP/Alarm Detected Fire ACL Proposal/Response Message,
	 * to be sent to the Fire Station Agent with its proposal value.
	 */
	private void setDetectedFireACLResponseMessage() {
		this.detectedFireACLProposalResponseMessage.setPerformative(ACLMessage.PROPOSE);
		this.detectedFireACLProposalResponseMessage.setContent(String.valueOf(this.proposalToAttendFire));
	}
}