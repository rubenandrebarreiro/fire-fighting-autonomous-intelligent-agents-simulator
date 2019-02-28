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

package world.map;

import java.awt.Point;

import world.map.utils.WorldObjectType;

/**
 * The class responsible for a World's object.
 */
public class WorldObject {
	
	// Global Instance Variables:
	
	/**
	 * The type of the World's object.
	 */
	private WorldObjectType worldObjectType;
	
	/**
	 * The position/point of the World's object.
	 */
	private Point worldObjectPosition;
	
	
	// Constructors:
	
	/**
	 * The constructor #1 of the World's object.
	 * 
	 * @param worldObjectType the type of the World's object
	 * @param worldObjectPosition the position of the World's object
	 */
	public WorldObject(WorldObjectType worldObjectType, Point worldObjectPosition) {
		this.worldObjectType = worldObjectType;
		this.worldObjectPosition = worldObjectPosition;
	}

	// Methods/Functions:
	
	/**
	 * Returns the type of the World's object.
	 * 
	 * @return the type of the World's object
	 */
	public WorldObjectType getWorldObjectType() {
		return this.worldObjectType;
	}
	
	/**
	 * Returns the position/point of the World's object.
	 * 
	 * @return the position/point of the World's object
	 */
	public Point getPosition() {
		return this.worldObjectPosition;
	}

	/**
	 * Returns the coordinate X of the position/point of the World's object.
	 * 
	 * @return the coordinate X of the position/point of the World's object
	 */
	private int getPositionX() {
		return this.worldObjectPosition.x;
	}

	/**
	 * Returns the coordinate Y of the position/point of the World's object.
	 * 
	 * @return the coordinate Y of the position/point of the World's object
	 */
	private int getPositionY() {
		return this.worldObjectPosition.y;
	}

	/**
	 * Updates the both coordinates of the current position/point of the World's object.
	 * 
	 * @param x the coordinate X of the position/point of the World's object
	 * @param y the coordinate Y of the position/point of the World's object
	 */
	public void updatePosition(int x, int y) {
		this.worldObjectPosition.x = x;
		this.worldObjectPosition.y = y;
	}
}