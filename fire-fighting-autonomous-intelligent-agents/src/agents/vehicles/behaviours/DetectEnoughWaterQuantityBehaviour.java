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
 * The class responsible for the Detect Enough Water Quantity Behaviour.
 */
public class DetectEnoughWaterQuantityBehaviour extends TickerBehaviour {

	// Constants/Invariants:

	/**
	 * The default UID of the Detect Enough Water Quantity Behaviour.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The complete class name of the Aircraft Agent's instance.
	 * e.g. some.package.object-class-name.
	 */
	private static final String INSTANCE_OF_AIRCRAFT_CLASS_NAME = "agents.vehicles.aircraft.AircraftAgent";
	
	/**
	 * The complete class name of the Drone Agent's instance.
	 * e.g. some.package.object-class-name.
	 */
	private static final String INSTANCE_OF_DRONE_CLASS_NAME = "agents.vehicles.drone.DroneAgent";
	
	/**
	 * The complete class name of the Fire Truck Agent's instance.
	 * e.g. some.package.object-class-name.
	 */
	private static final String INSTANCE_OF_FIRE_TRUCK_CLASS_NAME = "agents.vehicles.firetruck.FireTruckAgent";
	
	
	// Global Instance Variables:
	
	/**
	 * The Vehicle Agent responsible for this Detect Enough Water Quantity Behaviour and
	 * to detect if it have its water tank empty, and in that case, if it needs to refuel it.
	 */
	private VehicleAgent vehicleAgent;
	
	
	// Constructors:
	
	/**
	 * Constructor #1 of the Detect Enough Water Quantity Behaviour.
	 * 
	 * @param vehicleAgent the Vehicle Agent responsible for this Behaviour and to detect if it have its water tank empty,
	 * 		  and in that case, if it needs to refuel it
	 * @param tryToDetectEnoughWaterTankQuantityPeriod
	 */
	public DetectEnoughWaterQuantityBehaviour(VehicleAgent vehicleAgent,
											long tryToDetectEnoughWaterTankQuantityPeriod) {
		
		super(vehicleAgent, tryToDetectEnoughWaterTankQuantityPeriod);
		this.vehicleAgent = vehicleAgent;
	}

	
	// Methods/Functions:
	
	/**
	 * Returns the Vehicle Agent responsible for this Behaviour and to detect if it have its water tank empty,
	 * and in that case, if it needs to refuel it.
	 * 
	 * @return the Vehicle Agent responsible for this Behaviour and to detect if it have its water tank empty,
	 * 		   and in that case, if it needs to refuel it
	 */
	public VehicleAgent getAircraftAgent() {
		return this.vehicleAgent;
	}
		
	/**
	 * All the operations needed to be made during all the calls of this Detect Enough Water Quantity Behaviour.
	 * 
	 * If this Vehicle Agent doesn't have enough or necessary water quantity in its water tank to perform all the required actions,
	 * go to the nearest Water Resource refuel its water tank.
	 */
	@Override
	protected void onTick() {
		
		switch (vehicleAgent.getClass().getName()) {
		  case INSTANCE_OF_AIRCRAFT_CLASS_NAME:
			  if(this.vehicleAgent.getWaterTankQuantity() < (Config.AIRCRAFT_MAX_WATER_TANK_CAPACITY / 2) && !this.vehicleAgent.isBusy())	
				  //this.vehicleAgent.goToNearestWaterResourceRefuelWaterTank();
			  
			  break;
		  case INSTANCE_OF_DRONE_CLASS_NAME:
			  if(this.vehicleAgent.getWaterTankQuantity() < (Config.DRONE_MAX_WATER_TANK_CAPACITY / 2) && !this.vehicleAgent.isBusy())	
				  //this.vehicleAgent.goToNearestWaterResourceRefuelWaterTank();
			  
			  break;
		  case INSTANCE_OF_FIRE_TRUCK_CLASS_NAME:
			  if(this.vehicleAgent.getWaterTankQuantity() < (Config.FIRE_TRUCK_MAX_WATER_TANK_CAPACITY / 2) && !this.vehicleAgent.isBusy())	
				  //this.vehicleAgent.goToNearestWaterResourceRefuelWaterTank();
			  
			  break;
		  default:
			  break;
		}		
	}
}