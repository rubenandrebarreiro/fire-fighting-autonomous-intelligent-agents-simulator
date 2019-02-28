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

package world.nature;

import java.util.Random;
import world.map.WorldObject;

/**
 * Class responsible for a Fire.
 */
public class Fire {
	
	// Global Instance Variables:
	
	/**
	 * ID of the Fire.
	 */
	private byte id;
	
	/**
	 * World's object of the Fire.
	 */
	private WorldObject worldObject;
	
	/**
	 * TimeStamp of the Fire's creation.
	 */
	private long creationTimeStamp;
	
	/**
	 * Current intensity of the Fire.
	 */
	private int currentIntensity;
	
	/**
	 * Original intensity of the Fire.
	 */
	private final int originalIntensity;
	
	/**
	 * Probability of spreading of the Fire. 
	 */
	private float spreadProbability;
	
	/**
	 * Number of spreads of the Fire.
	 */
	private int numSpreads;
	
	/**
	 * Number of increases of the intensity of the Fire.
	 */
	private int numIntensityIncreases;
	
	/**
	 * Number of decreases of the intensity of the Fire.
	 */
	private int numIntensityDecreases;
	
	/**
	 * Status to inform that the Fire is currently active or not.
	 */
	private boolean active;
	
	/**
	 * Status to inform that the Fire is currently attended or not.
	 */
	public boolean attended;
	
	
	// Constructors:
	
	/**
	 * Constructor #1 of the Fire.
	 * 
	 * @param id the ID of the Fire
	 * @param worldObject the World's object associated to the Fire
	 */
	public Fire(byte id, WorldObject worldObject) {
		Random random = new Random();
		
		this.worldObject = worldObject;
		
		this.creationTimeStamp = System.currentTimeMillis();
		
		this.currentIntensity = random.nextInt(Config.FIRE_MAX_INITIAL_INTENSITY) + 1;
		this.originalIntensity = currentIntensity;
		
		this.spreadProbability = random.nextFloat();
		
		this.numSpreads = 0;
		this.numIntensityIncreases = 0;
		this.numIntensityDecreases = 0;
		
		this.active = true;
		this.attended = false;
	}
	
	// Methods/Functions:
	
	/**
	 * Returns the ID of the Fire.
	 * 
	 * @return the ID of the Fire
	 */
	public byte getID() {
		return this.id;
	}
	
	/**
	 * Returns the world's object of the Fire.
	 * 
	 * @return the world's object of the Fire
	 */
	public byte getWorldObject() {
		return this.worldObject;
	}
	
	/**
	 * Returns the TimeStamp of the Fire's creation.
	 * 
	 * @return the TimeStamp of the Fire's creation
	 */
	public long getCreationTimeStamp() {
		return this.creationTimeStamp;
	}
	
	/**
	 * Returns the current intensity of the Fire.
	 * 
	 * @return the current intensity of the Fire
	 */
	public int getCurrentIntensity() {
		return this.currentIntensity;
	}
	
	/**
	 * Returns the original intensity of the Fire.
	 * 
	 * @return the original intensity of the Fire
	 */
	public int getOriginalIntensity() {
		return this.originalIntensity;
	}
	
	/**
	 * Returns the probability of spreading of the Fire.
	 * 
	 * @return the probability of spreading of the Fire
	 */
	public float getSpreadProbability() {
		return this.spreadProbability;
	}
	
	/**
	 * Returns the number of spreads of the Fire.
	 * 
	 * @return the number of spreads of the Fire
	 */
	public int getNumSpreads() {
		return this.numSpreads;
	}
	
	/**
	 * Increases the number of spreads of the Fire.
	 */
	public void getIncreaseNumSpreads() {
		this.numSpreads++;
	}
	
	/**
	 * Returns the number of increases of the intensity of the Fire.
	 * 
	 * @return the number of increases of the intensity of the Fire
	 */
	public int getNumIntensityIncreases() {
		return this.numIntensityIncreases;
	}
	
	/**
	 * Increases the intensity of the Fire, given a value of increasing.
	 * 
	 * @param value value of increasing of the intensity of the Fire
	 */
	public void increaseIntensity(int value) {
		
		if((this.currentIntensity + value) > Config.FIRE_MAX_FINAL_INTENSITY) {
			this.currentIntensity += value;
			this.numIntensityIncreases++;
		}
	}
	
	/**
	 * Returns the number of decreases of the intensity of the Fire.
	 * 
	 * @return the number of decreases of the intensity of the Fire
	 */
	public int getNumIntensityDecreases() {
		return this.numIntensityDecreases;
	}
	
	/**
	 * Increases the intensity of the Fire, given a value of increasing.
	 * 
	 * @param value value of increasing of the intensity of the Fire
	 */
	public void decreaseIntensity(int value) {
		
		this.currentIntensity = this.currentIntensity - value;
		
		if(this.currentIntensity <= 0)
			this.active = false;
		
		this.numIntensityDecreases++;
	}
	
	/**
	 * Returns the status to inform that the Fire is currently active or not.
	 * 
	 * @return the status to inform that the Fire is currently active or not
	 */
	public boolean isActive() {
		return this.active;
	}
	
	/**
	 * Returns the status to inform that the Fire is currently attended or not.
	 * 
	 * @return the status to inform that the Fire is currently attended or not
	 */
	public boolean isAttended() {
		return this.attended;
	}

	/**
	 * Returns the current information about the Fire.
	 * 
	 * @return the current information about the Fire
	 */
	public String getFireInfo() {
		// TODO
		
		return "Fire " + this.id;
	}
	
	/**
	 * Returns the basic information to be displayed in a graphic user interface about the Fire.
	 */
	@Override
	public String toString() {
		return "F" + this.currentIntensity;
	}
}