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

package agents.vehicles.behaviours;

import agents.vehicles.VehicleAgent;
import agents.vehicles.messages.AlarmDetectedFireACLProposalResponseMessage;
import agents.vehicles.messages.InformAttendingFireACLMessage;
import agents.vehicles.messages.templates.AlarmDetectedFireACLMessageTemplate;
import jade.core.behaviours.DataStore;
import jade.domain.FIPAAgentManagement.FailureException;
import jade.domain.FIPAAgentManagement.NotUnderstoodException;
import jade.domain.FIPAAgentManagement.RefuseException;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.proto.ContractNetResponder;

/**
 * The class responsible for the Detected Fire Alarm Listener Behaviour.
 */
public class DetectedFireAlarmListenerBehaviour extends ContractNetResponder {

	// Constants/Invariants:
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	// Global Instance Variables:
	
	/**
	 * 
	 */
	private VehicleAgent vehicleAgent;
	
	
	// Constructors:
	
	/**
	 * 
	 * 
	 * @param vehicleAgent
	 * @param alarmDetectedFireACLMessageTemplate
	 * @param store
	 */
	public DetectedFireAlarmListenerBehaviour(VehicleAgent vehicleAgent,
					AlarmDetectedFireACLMessageTemplate alarmDetectedFireACLMessageTemplate, DataStore store) {
		
		super(vehicleAgent, alarmDetectedFireACLMessageTemplate, store);
		
		this.vehicleAgent = vehicleAgent;
	}

	// Methods/Functions:
	
	/**
	 * Returns the Vehicle Agent that will TODO
	 * 
	 * @return
	 */
	public VehicleAgent getVehicleAgent() {
		return this.vehicleAgent;
	}
	
	protected ACLMessage prepareResponse(ACLMessage detectedFireReceivedMessage) 
																throws NotUnderstoodException, RefuseException {
		
		//if(GraphicUserInterface.isActive()) {
			//GraphicUserInterface.log("Vehicle Agent " + (int) (this.vehicleAgent.getID()) + " with the local name " + 
					//this.vehicleAgent.getLocalName() + " received a message from Fire Station Agent about a detected Fire:\n");
			
			//GraphicUserInterface.log("Message's Sender: " + detectedFireReceivedMessage.getSender().getName() + "\n");
			//GraphicUserInterface.log("Message's Content: " + detectedFireReceivedMessage.getContent() + "\n");
		//}
		//else {
			System.out.print("Vehicle Agent " + (int) (this.vehicleAgent.getID()) + " with the local name " + 
					this.vehicleAgent.getLocalName() + " received a message from Fire Station Agent about a detected Fire:\n");
			
			System.out.println("Message's Sender: " + detectedFireReceivedMessage.getSender().getName() + "\n");
			System.out.println("Message's Content: " + detectedFireReceivedMessage.getContent() + "\n");
		//}
		
		int proposalToAttendFire = this.vehicleAgent.evaluateActionToAttendFire(detectedFireReceivedMessage.getContent());
		
		// The Vehicle Agent will provide a response/proposal to the Fire Station Agent about the detected Fire
		if(!this.vehicleAgent.isBusy() && proposalToAttendFire < Integer.MAX_VALUE) {
			
			//if(GraphicUserInterface.isActive()) {				
				//GraphicUserInterface.log("Vehicle Agent " + this.vehicleAgent.getID() + " with the local name " + 
						//this.vehicleAgent.getLocalName() + " info updated:\n");
						
				//GraphicUserInterface.log("Proposing " + proposalToAttendFire +
									//" and building a response with this value to the Fire Station Agent about the" +
									//" detected Fire!!!\n");
			//}
			//else {
				System.out.print("Vehicle Agent " + this.vehicleAgent.getID() + " with the local name " + 
						this.vehicleAgent.getLocalName() + " info updated:\n");
						
				System.out.print("Proposing " + proposalToAttendFire +
									" and building a response with this value to the Fire Station Agent about the " +
									"detected Fire!!!\n");
			//}
			
			// Create the CFP/Alarm Detected Fire ACL Proposal/Response Message
			AlarmDetectedFireACLProposalResponseMessage detectedFireProposalResponseMessage = 
					new AlarmDetectedFireACLProposalResponseMessage(detectedFireReceivedMessage.createReply(), proposalToAttendFire);

			return detectedFireProposalResponseMessage.getDetectedFireACLResponseMessage();
		}
		// The Vehicle Agent can't provide a response/proposal to the Fire Station Agent about the detected Fire
		else {
			throw new RefuseException("The Vehicle Agent " + (int) (this.vehicleAgent.getID()) + 
															" can't provide a response/proposal at this moment...");
		}
	}
	
	protected ACLMessage prepareResultNotification(ACLMessage cfp, ACLMessage propose, ACLMessage accept) 
																	throws FailureException {
		
		//if(GraphicUserInterface.isActive()) {
			//GraphicUserInterface.log("Vehicle Agent " + this.vehicleAgent.getID() + " with the local name " + 
					//this.vehicleAgent.getLocalName() + 
						//" received a response from the Fire Station Agent about its response/proposal to the detected Fire:\n");

			//GraphicUserInterface.log("Proposal accepted!!!\n");
		//}
		//else {
			System.out.print("Vehicle Agent " + this.vehicleAgent.getID() + " with the local name " + 
					this.vehicleAgent.getLocalName() + 
						" received a response from the Fire Station Agent about its response/proposal to the detected Fire:\n");

			System.out.println("Proposal accepted!!!\n");
		//}
		
		this.vehicleAgent.attendFire();

		// The Vehicle Agent could go attend the Fire, as expected
		if(this.vehicleAgent.goAttendTheFireAction()) {
			
			//if(GraphicUserInterface.isActive()) {
				//GraphicUserInterface.log("Vehicle Agent " + this.vehicleAgent.getID() + " with the local name " + 
						//this.vehicleAgent.getLocalName() + " info updated:\n");
						
				//GraphicUserInterface.log("Action to attend the Fire successfully performed!!!\n");
			//}
			//else {
				System.out.print("Vehicle Agent " + this.vehicleAgent.getID() + " with the local name " + 
						this.vehicleAgent.getLocalName() + " info updated:\n");
						
				System.out.print("Action to attend the Fire successfully performed!!!\n");
			//}
			
			// TODO
			InformAttendingFireACLMessage informAttendingFireACLMessage = new InformAttendingFireACLMessage(accept.createReply());
			
			return informAttendingFireACLMessage.getInformAttendingFireACLMessage();
		}
		// The Vehicle Agent couldn't go attend the Fire, as unexpected
		else {
			throw new FailureException("Unexpected Error...\n" +
											"The Vehicle Agent couldn't perform the action to attend the Fire!!!\n");
		}	
	}
	
	protected void handleRejectProposal(ACLMessage reject) {
		//if(GraphicUserInterface.isActive()) {
		
			//GraphicUserInterface.log("Vehicle Agent " + this.vehicleAgent.getID() + " with the local name " + 
					//this.vehicleAgent.getLocalName() + 
						//" received a response from the Fire Station Agent about its response/proposal to the detected Fire:\n");

			//GraphicUserInterface.log("Proposal rejected!!!\n");
		//}
		//else {
			System.out.print("Vehicle Agent " + this.vehicleAgent.getID() + " with the local name " + 
								this.vehicleAgent.getLocalName() + 
									" received a response from the Fire Station Agent about its response/proposal to the detected Fire:\n");

			System.out.println("Proposal rejected!!!\n");
		//}
	}
}