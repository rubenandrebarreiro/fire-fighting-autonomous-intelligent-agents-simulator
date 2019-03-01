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
import jade.core.behaviours.TickerBehaviour;
import utils.configuration.Config;

/**
 * The class responsible for the Detect Enough Fuel Quantity Behaviour.
 */
public class DetectEnoughFuelQuantityBehaviour extends TickerBehaviour {

	// Constants/Invariants:

	/**
	 * The default UID of the Detect Enough Fuel Quantity Behaviour.
	 */
	private static final long serialVersionUID = 1L;
	
	
	// Global Instance Variables:
	
	/**
	 * The Vehicle Agent responsible for this Detect Enough Fuel Quantity Behaviour and
	 * to detect if it have its fuel tank empty, and in that case, if it needs to refuel it.
	 */
	private VehicleAgent vehicleAgent;
	
	
	// Constructors:
	
	/**
	 * Constructor #1 of the Detect Enough Fuel Quantity Behaviour.
	 * 
	 * @param vehicleAgent the Vehicle Agent responsible for this Behaviour and to detect if it have its fuel tank empty,
	 * 		  and in that case, if it needs to refuel it
	 * @param tryToDetectEnoughFuelTankQuantityPeriod TODO
	 */
	public DetectEnoughFuelQuantityBehaviour(VehicleAgent vehicleAgent,
											long tryToDetectEnoughFuelTankQuantityPeriod) {
		
		super(vehicleAgent, tryToDetectEnoughFuelTankQuantityPeriod);
		this.vehicleAgent = vehicleAgent;
	}

	
	// Methods/Functions:
	
	/**
	 * Returns the Vehicle Agent responsible for this Behaviour and to detect if it have its fuel tank empty,
	 * and in that case, if it needs to refuel it.
	 * 
	 * @return the Vehicle Agent responsible for this Behaviour and to detect if it have its fuel tank empty,
	 * 		   and in that case, if it needs to refuel it
	 */
	public VehicleAgent getAircraftAgent() {
		return this.vehicleAgent;
	}
		
	/**
	 * All the operations needed to be made during all the calls of this Detect Enough Fuel Quantity Behaviour.
	 * 
	 * If this Vehicle Agent doesn't have enough or necessary fuel quantity in its fuel tank to perform all the required actions,
	 * go to the nearest Fire Station Agent refuel its fuel tank.
	 */
	@Override
	protected void onTick() {
		
		switch (vehicleAgent.getClass().getName()) {
		  case Config.INSTANCE_OF_AIRCRAFT_CLASS_NAME:
			  if(this.vehicleAgent.getFuelTankQuantity() < (Config.AIRCRAFT_MAX_FINAL_FUEL_TANK_CAPACITY / 2) && !this.vehicleAgent.isBusy())	
				  //this.vehicleAgent.goToNearestFireStationAgentRefuelFuelTank();
			  
			  break;
		  case Config.INSTANCE_OF_DRONE_CLASS_NAME:
			  if(this.vehicleAgent.getFuelTankQuantity() < (Config.DRONE_MAX_FINAL_FUEL_TANK_CAPACITY / 2) && !this.vehicleAgent.isBusy())	
				  //this.vehicleAgent.goToNearestFireStationAgentRefuelFuelTank();
			  
			  break;
		  case Config.INSTANCE_OF_FIRE_TRUCK_CLASS_NAME:
			  if(this.vehicleAgent.getFuelTankQuantity() < (Config.FIRE_TRUCK_MAX_FINAL_FUEL_TANK_CAPACITY / 2) && !this.vehicleAgent.isBusy())	
				  //this.vehicleAgent.goToNearestFireStationAgentRefuelFuelTank();
			  
			  break;
		  default:
			  break;
		}		
	}
}