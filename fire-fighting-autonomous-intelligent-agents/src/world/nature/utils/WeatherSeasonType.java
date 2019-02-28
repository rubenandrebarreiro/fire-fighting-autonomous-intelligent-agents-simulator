/**
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

package world.nature.utils;

/**
 * Enumeration responsible for the type of a Weather Season.
 */
public enum WeatherSeasonType {
	
	// Enumeration definitions:
	
	/**
	 * Possible enumerations and their parameters.
	 */
	SPRING((byte) 0, "Spring", Config.RAIN_FACTOR_SPRING, false),
	SUMMER((byte) 1, "Summer", Config.RAIN_FACTOR_SUMMER, true),
	AUTUMN((byte) 2, "Autumn", Config.RAIN_FACTOR_AUTUMN, false),
	WINTER((byte) 3, "Winter", Config.RAIN_FACTOR_WINTER, false);

	
	// Global Instance Variables:
	
	/*
	 * The ID of the type of the Weather Season.
	 */
    private final byte id;
    
    /**
     * The name of the type of the Weather Season.
     */
    private final String name;
    
    /**
     * The rain factor associated to the type of the Weather Season.
     */
    private final int rainFactor;

    /**
     * The boolean value that keeps the information about the possibility of 
     * droughts (extreme dry situations) occurrence, associated to the type of Weather Season.
     */
    private final boolean occurrenceOfDroughts;
	    
  
    // Constructors:
	    
    /**
     * Constructor #1 of the type of the Weather Season.
     * 
     * @param id the ID of the type of the Weather Season
     * @param name the name of the type of the Weather Season
     * @param rainFactor the rain factor associated to the type of the Weather Season
     * @param occurrenceOfDroughts the boolean value that keeps the information about the possibility of 
     * 		  droughts (extreme dry situations) occurrence, associated to the type of the Weather Season
     */
    private WeatherSeasonType(byte id, String name, int rainFactor, boolean occurrenceOfDroughts) {
        this.id = id;
        this.name = name;
        this.rainFactor = rainFactor;
        this.occurrenceOfDroughts = occurrenceOfDroughts;
    }
    
	        
    // Methods/Functions:
	    
    /**
     * Returns the ID of the type of the Weather Season.
     * 
     * @return the ID of the type of the Weather Season
     */
    public byte getID() {
    	return this.id;
    }

    /**
     * Returns the name of the type of the Weather Season.
     * 
     * @return the name of the type of the Weather Season
     */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Returns the rain factor associated to the type of the Weather Season.
	 * 
	 * @return the rain factor associated to the type of the Weather Season
	 */
	public int getRainFactor() {
		return this.rainFactor;
	}

	/**
	 * Returns the boolean value that keeps the information about the possibility of 
     * droughts (extreme dry situations) occurrence, associated to the type of the Weather Season.
	 * 
	 * @return the boolean value that keeps the information about the possibility of 
     * 		   droughts (extreme dry situations) occurrence, associated to the type of the Weather Season
	 */
	public boolean canOccurDroughts() {
		return this.occurrenceOfDroughts;
	}
}
