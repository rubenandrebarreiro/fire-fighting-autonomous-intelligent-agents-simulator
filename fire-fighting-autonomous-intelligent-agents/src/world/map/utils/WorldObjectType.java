/**
 * 
 * Fire Fighting - Autonomous Intelligent Agents
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

package world.map.utils;

/**
 * The enumeration responsible for the type of a World's object.
 */
public enum WorldObjectType {
	
	// Enumeration definitions:
	
	/**
	 * The possible enumerations and their parameters.
	 */
	FIRE_STATION((byte) 0, "Fire Station"),
	WATER_RESOURCE((byte) 1, "Water Resource"),
	FIRE((byte) 2, "Fire"),
	AIRCRAFT((byte) 3, "Aircraft"),
	DRONE((byte) 4, "Drone"),
	FIRE_TRUCK((byte) 5, "Fire Truck");
	
	
	// Global Instance Variables:
	
	/**
	 * The ID of the type of the World's object.
	 */
    private final byte id;
    
    /**
     * The name of the type of the World's object.
     */
    private final String name;
	
	
	// Constructors:
    
    /**
     * The constructor #1 of the World's object type.
     * 
     * @param id the ID of the type of World's object
     * @param name the name of the type of World's object
     */
    private WorldObjectType(byte id, String name) {
        this.id = id;
        this.name = name;
    }
    
    
    // Methods/Functions:
    
    /**
     * Returns the id of the type of the World's object.
     * 
     * @return the id of the type of the World's object
     */
    public byte getID() {
    	return this.id;
    }

    /**
     * Returns the name of the type of the World's object.
     * 
     * @return the name of the type of the World's object
     */
	public String getName() {
		return this.name;
	}
}