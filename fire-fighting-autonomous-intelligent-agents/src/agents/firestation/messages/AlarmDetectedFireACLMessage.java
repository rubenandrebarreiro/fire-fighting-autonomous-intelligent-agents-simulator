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

package agents.firestation.messages;

import java.awt.Point;
import java.util.Date;
import java.util.Map;
import agents.firestation.FireStationAgent;
import agents.vehicles.VehicleAgent;
import jade.core.AID;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import world.nature.Fire;

/**
 * The class responsible for the CFP/Alarm Detected Fire ACL Message.
 */
public class AlarmDetectedFireACLMessage extends ACLMessage {

	// Constants/Invariants:

	/**
	 * The default UID of the Alarm Vehicles About Fires Behaviour.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The time to wait for the reply to this CFP/Alarm Detected Fire ACL Message (20 seconds).
	 */
	private static final long TIME_TO_WAIT_FOR_RESPONSE = 2000;
	
	
	// Global Instance Variables:
	
	/**
	 * The CFP/Alarm Detected Fire ACL Message.
	 */
	private ACLMessage detectedFireACLMessage;
	
	/**
	 * The Fire associated to this CFP/Alarm Detected Fire ACL Message.
	 */
	private Fire detectedFire;
	
	/**
	 * The Vehicle Agents presented in the World and that may
	 * respond to this CFP/Alarm Detected Fire ACL Message.
	 */
	private Map<Integer, VehicleAgent> vehicleAgents;
	
	/**
	 * The total number of Vehicle Agents presented in the World and
	 * that may respond to this CFP/Alarm Detected Fire ACL Message.
	 */
	private int numTotalVehicleAgents;
	
	
	// Constructors:
	
	/**
	 * 
	 * 
	 * @param detectedFire
	 * @param vehicleAgents
	 * @param numTotalVehicleAgents
	 */
	public AlarmDetectedFireACLMessage(Fire detectedFire, Map<Integer, VehicleAgent> vehicleAgents,
												int numTotalVehicleAgents) {
		
		super(ACLMessage.CFP);
		
		this.detectedFire = detectedFire;
		this.vehicleAgents = vehicleAgents;
		this.numTotalVehicleAgents = numTotalVehicleAgents;
		
		this.setDetectedFireACLMessage();
	}
	
	
	// Methods/Functions:
	
	/**
	 * Returns the CFP/Alarm Detected Fire ACL Message.
	 * 
	 * @return the CFP/Alarm Detected Fire ACL Message
	 */
	public ACLMessage getDetectedFireACLMessage() {
		return this.detectedFireACLMessage;
	}
	
	/**
	 * Sets and configures the CFP/Alarm Detected Fire ACL Message, to be sent to all the available Vehicle Agents responders/receivers.
	 */
	private void setDetectedFireACLMessage() {
		
		Object[] args = FireStationAgent.getVehiclesAgentsNames(this.numTotalVehicleAgents);
				 
		this.detectedFireACLMessage = null;
				
		if (args != null && args.length > 0) {
		      
			// Fill this CFP/Alarm Detected Fire ACL Message
			this.detectedFireACLMessage = new ACLMessage(ACLMessage.CFP);
			      
			// Add all the pretended responders/receivers to this CFP/Alarm Detected Fire ACL Message
			for (int i = 0; i < args.length; ++i) {
				
				// Only will be considered Vehicle Agents that aren't "busy"
				if(!this.vehicleAgents.get(i).isBusy())
					this.detectedFireACLMessage.addReceiver(new AID((String) args[i], AID.ISLOCALNAME));
			}
					      
			this.detectedFireACLMessage.setProtocol(FIPANames.InteractionProtocol.FIPA_CONTRACT_NET);
					 
			// Wait only 20 seconds to receive a reply to this CFP/Detected Fire ACL Message
			this.detectedFireACLMessage.setReplyByDate(new Date(System.currentTimeMillis() + TIME_TO_WAIT_FOR_RESPONSE));
			
			Point firePosition = this.detectedFire.getWorldObject().getPosition();
			
			// Set the content of this CFP/Alarm Detected Fire ACL Message
			this.detectedFireACLMessage
					.setContent("Fire detected!!! A Fire of Intensity of " + 
							this.detectedFire.getCurrentIntensity() + 
									" in Position/Point (" 
											+ (int) (firePosition.getX()) + "," 
													+ (int) (firePosition.getY()) + ") of the World's map/grid...");
		}
	}
	
	/**
	 * Returns the Fire associated to this CFP/Alarm Detected Fire ACL Message.
	 * 
	 * @return the Fire associated to this CFP/Alarm Detected Fire ACL Message
	 */
	public Fire getDetectedFire() {
		return this.detectedFire;
	}

	/**
	 * Returns the Vehicle Agents presented in the World and that may
	 * respond to this CFP/Alarm Detected Fire ACL Message.
	 * 
	 * @return the Vehicle Agents presented in the World and that may
	 * 		   respond to this CFP/Alarm Detected Fire ACL Message
	 */
	public Map<Integer, VehicleAgent> getVehicleAgents() {
		return this.vehicleAgents;
	}
	
	/**
	 * Returns the total number of Vehicle Agents presented in the World and
	 * that may respond to this CFP/Alarm Detected Fire ACL Message.
	 * 
	 * @return the total number of Vehicle Agents presented in the World and
	 * 		   that may respond to this CFP/Alarm Detected Fire ACL Message
	 */
	public int getNumTotalVehicleAgents() {
		return this.numTotalVehicleAgents;
	}
}