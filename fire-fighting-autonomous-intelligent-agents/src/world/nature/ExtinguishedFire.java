/**
 * Fire Fighting - Autonomous Intelligent Agents
 * 
 * Agents and Distributed Artificial Intelligence
 * 
 * Integrated Master of Informatics and Computing
 * Faculty of Engineering of University of Porto
 * 
 * Authors:
 * @author Bernardo Jose Leite - up
 * @author Bruno Miguel Pinto - up
 * @author Ruben Andre Barreiro - up201808917
 *
 */

package world.nature;

/**
 * Class responsible for an Extinguished Fire.
 */
public class ExtinguishedFire {
	
	// Global Instance Variables:
	
	/**
	 * The Fire Extinguished.
	 */
	private Fire extinguishedFire;
	
	/**
	 * The TimeStamp of the extinguish of the Fire.
	 */
	private long extinguishedFireTimeStamp;
	
	/**
	 * The ID of the Vehicle responsible for the extinguish of the Fire.
	 */
	private byte idVehicleResponsibleForExtinguishFire;
	
	/**
	 * Constructor #1 of the Extinguished Fire.
	 * 
	 * @param fireExtinguished the 
	 * @param idVehicleResponsibleForExtinguishFire
	 */
	public ExtinguishedFire(Fire extinguishedFire, byte idVehicleResponsibleForExtinguishFire) {
		this.extinguishedFire = extinguishedFire;
		this.extinguishedFireTimeStamp = System.currentTimeMillis();
		this.idVehicleResponsibleForExtinguishFire = idVehicleResponsibleForExtinguishFire;
	}
	
	// Methods/Functions:
	
	/**
	 * Returns the Fire Extinguished.
	 * 
	 * @return the Fire Extinguished
	 */
	public Fire getExtinguishedFire() {
		return this.extinguishedFire;
	}
	
	/**
	 * Returns the TimeStamp of the extinguish of the Fire.
	 * 
	 * @return the TimeStamp of the extinguish of the Fire
	 */
	public long getExtinguishedFireTimeStamp() {
		return this.extinguishedFireTimeStamp;
	}
	
	/**
	 * Returns the ID of the Vehicle responsible for the extinguish of the Fire.
	 * 
	 * @return the ID of the Vehicle responsible for the extinguish of the Fire
	 */
	public byte getIdVehicleResponsibleForExtinguishFire() {
		return this.idVehicleResponsibleForExtinguishFire;
	}
}
