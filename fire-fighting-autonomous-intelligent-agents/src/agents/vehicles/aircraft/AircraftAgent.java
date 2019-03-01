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

package agents.vehicles.aircraft;

import java.util.Random;
import agents.vehicles.VehicleAgent;
import utils.configuration.Config;
import world.map.WorldObject;

/**
 * The class responsible for an Aircraft Agent.
 */
public class AircraftAgent extends VehicleAgent {
	
	// Constants/Invariants:
	
	/**
	 * The default UID of the Aircraft Agent.
	 */
	private static final long serialVersionUID = 1L;
	
	
	// Constructors:
	
	/**
	 * The constructor #1 of the Aircraft Agent.
	 * 
	 * @param id the ID of the Aircraft Agent
	 * @param worldObject the World's object associated to the Aircraft Agent
	 */
	public AircraftAgent(byte id, WorldObject worldObject) {
		this.id = id;
		this.worldObject = worldObject;
	
		Random randomObject = new Random();
		
		this.waterTankQuantity = 0;
		AircraftAgent.maxWaterTankCapacity = randomObject.nextInt(Config.AIRCRAFT_MAX_WATER_TANK_CAPACITY) + 1;

		this.fuelTankQuantity = 0;
		AircraftAgent.maxFuelTankCapacity = randomObject.nextInt(Config.AIRCRAFT_MAX_INITIAL_FUEL_TANK_CAPACITY) + 1;

		this.attendingFire = false;
		this.refuellingWaterOrFuel = false;
		
		this.crashed = false;
		
		//this.vehicleMetricsStats = new VehicleMetricsStats();

		//this.sleepingThreads = new ConcurrentHashMap<>();
	}
	
	
	// Methods/Functions:
	
	/**
	 * Returns true if the Aircraft Agent have its water tank full and false, otherwise.
	 * 
	 * @return true if the Aircraft Agent have its water tank full and false, otherwise
	 */
	@Override
	public boolean haveFullWaterTank() {
		return this.getWaterTankQuantity() == Config.AIRCRAFT_MAX_WATER_TANK_CAPACITY;
	}

	/**
	 * Returns the maximum water tank's capacity of the Aircraft Agent.
	 * 
	 * @return the maximum water tank's capacity of the Aircraft Agent
	 */
	@Override
	public int getMaxWaterTankCapacity() {
		return Config.AIRCRAFT_MAX_WATER_TANK_CAPACITY;
	}
	
	/**
	 * Returns true if the Aircraft Agent have its fuel tank full and false, otherwise.
	 * 
	 * @return true if the Aircraft Agent have its fuel tank full and false, otherwise
	 */
	@Override
	public boolean haveFullFuelTank() {
		return this.getWaterTankQuantity() == Config.AIRCRAFT_MAX_FINAL_FUEL_TANK_CAPACITY;
	}

	/**
	 * Returns the maximum fuel tank's capacity of the Aircraft Agent.
	 * 
	 * @return the maximum fuel tank's capacity of the Aircraft Agent
	 */
	@Override
	public int getMaxFuelTankCapacity() {
		return Config.AIRCRAFT_MAX_FINAL_FUEL_TANK_CAPACITY;
	}
	
	/**
	 * Returns the basic information to be displayed in a graphic user interface about the Aircraft Agent.
	 */
	@Override
	public String toString() {
		return "A - fq: " + this.getFuelTankQuantity() + "; | wq: " + this.getWaterTankQuantity() + ";";
	}
}
