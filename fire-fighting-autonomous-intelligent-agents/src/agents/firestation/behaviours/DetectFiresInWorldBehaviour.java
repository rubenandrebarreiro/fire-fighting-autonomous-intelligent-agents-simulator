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

import java.awt.Point;
import java.util.Map;
import agents.firestation.FireStationAgent;
import agents.firestation.messages.AlarmDetectedFireACLMessage;
import agents.vehicles.VehicleAgent;
import agents.world.WorldAgent;
import jade.core.behaviours.TickerBehaviour;
import world.map.WorldObject;
import world.nature.Fire;

/**
 * The class responsible for the Detect Fires In World Behaviour.
 */
public class DetectFiresInWorldBehaviour extends TickerBehaviour {

	// Constants/Invariants:
	
	/**
	 * The default UID of the Detect Fires In World Behaviour.
	 */
	private static final long serialVersionUID = 1L;

	
	// Global Instance Variables:
	
	/**
	 * The World Agent currently in use, where is trying to be detected some Fires.
	 */
	WorldAgent worldAgent;
	
	/**
	 * The Fire Station Agent responsible for this Detect Fires In World Behaviour and to detect some Fires.
	 */
	FireStationAgent fireStationAgent;
	
	
	// Constructors:
	
	/**
	 * Constructor #1 of the Detect Fires In World Behaviour.
	 * 
	 * @param worldAgent the World Agent currently in use, where is trying to be detected some Fires
	 * @param fireStationAgent the Fire Station Agent responsible for this Behaviour and to detect some Fires
	 * @param tryToDetectFiresInWorldPeriod the period of time used to the Fire Station Agent try to detect some Fires
	 */
	public DetectFiresInWorldBehaviour(WorldAgent worldAgent, FireStationAgent fireStationAgent,
																long tryToDetectFiresInWorldPeriod) {
		
		super(fireStationAgent, tryToDetectFiresInWorldPeriod);
		
		this.worldAgent = worldAgent;
		this.fireStationAgent = fireStationAgent;
	}

	
	// Methods/Functions:
	
	/**
	 * Returns the World Agent currently in use, where is trying to be detected some Fires.
	 * 
	 * @return the World Agent currently in use, where is trying to be detected some Fires
	 */
	public WorldAgent getWorldAgent() {
		return this.worldAgent;
	}
	
	/**
	 * Returns the Fire Station Agent responsible for this Detect Fires In World Behaviour and to detect some Fires.
	 * 
	 * @return the Fire Station Agent responsible for this Detect Fires In World Behaviour and to detect some Fires
	 */
	public FireStationAgent getFireStationAgent() {
		return this.fireStationAgent;
	}
	
	/**
	 * Returns all the Fires presented in the World that are currently active and need to be extinguished.
	 * 
	 * @return all the Fires presented in the World that are currently active and need to be extinguished
	 */
	public Map<Integer, Fire> getCurrentlyActiveFires() {
		return this.worldAgent.getCurrentlyActiveFires();
	}
	
	/**
	 * All the operations needed to be made during all the calls of this Detect Fires In World Behaviour.
	 * 
	 * TODO
	 */
	@Override
	protected void onTick() {
		
		Map<Integer, Fire> currentlyActiveFires = this.getCurrentlyActiveFires();
	
		if(!currentlyActiveFires.isEmpty()) {
			System.out.println("There are " + currentlyActiveFires.size() + " currently active Fires that need to be extinguished!!!");
			
			for(Fire fire: currentlyActiveFires.values()) {
				// The behaviour's reaction is only valid if the Fire is currently active and
				// if isn't being attended by some Vehicle Agent yet
				if(fire.isActive() && !fire.isAttended()) {
					
					//if(GraphicUserInterface.isActive()) {
						//GraphicUserInterface.log("Detected Fire!!!\n");
						//GraphicUserInterface.log("It will be sent a message to all the Vehicle Agents...\n");
						
						//Point firePosition = fire.getWorldObject().getPosition();
						
						//GraphicUserInterface.log("This Fire was detected on the position/point (" +
								//(int) (firePosition.getX()) + "," + 
										//(int) (firePosition.getY()) + 
													//") of the World's map/grid...");
					//}
					//else {
						System.out.println("Detected Fire!!!\n");
						System.out.println("It will be sent a message to all the Vehicle Agents...\n");
						
						Point firePosition = fire.getWorldObject().getPosition();
						
						System.out.println("This Fire was detected on the position/point (" +
								(int) (firePosition.getX()) + "," + 
											(int) (firePosition.getY()) + 
														") of the World's map/grid...");
					//}
					
					Map<Integer, VehicleAgent> vehicleAgents = this.worldAgent.getVehicleAgents();
					int numTotalVehicleAgents = this.worldAgent.getNumTotalVehicleAgents();
					
					AlarmDetectedFireACLMessage alarmDetectedFireACLMessage = new AlarmDetectedFireACLMessage(fire, vehicleAgents, numTotalVehicleAgents);	

					// TODO - Data Store
					AlarmVehiclesAboutFiresBehaviour alarmVehiclesToExtinguishFire = new AlarmVehiclesAboutFiresBehaviour(fireStationAgent, alarmDetectedFireACLMessage.getDetectedFireACLMessage(), null);
						
					int vehicleAgentsNotBusy = 0;
					
					for(VehicleAgent vehicleAgent: vehicleAgents.values())
						if(!vehicleAgent.isBusy())
							vehicleAgentsNotBusy++;
					
					// All the Vehicle Agents are currently busy,
					// so it's impossible to attend Fires at the moment
					if(vehicleAgentsNotBusy == 0)
						break;
					
					this.fireStationAgent.addBehaviour(alarmVehiclesToExtinguishFire);
					
					// Isn't pretended to overload the Vehicle Agents
					// constantly with alarms about detected Fires...
					// So after the first detected Fire that is currently active and
					// not being attended by some Vehicle Agent, this operation stops
					// until the next time that will be detected some Fire again...
					break;
					
				}
				else if(!fire.isActive()) {
					
					WorldObject fireWorldObject = fire.getWorldObject();
					
					int firePositionX = fireWorldObject.getPositionX();
					int firePositionY = fireWorldObject.getPositionY();
					
					this.worldAgent.removeFire(firePositionX, firePositionY, 0);
				}	
			}
		}
	}
}
