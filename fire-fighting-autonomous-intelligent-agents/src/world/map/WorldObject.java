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

package world.map;

import java.awt.Point;

import world.map.utils.WorldObjectType;

/**
 * Class responsible for a World's object.
 */
public class WorldObject {
	
	// Global Instance Variables:
	
	private WorldObjectType worldObjectType;
	
	private Point worldObjectPosition;
	
	/**
	 * 
	 * 
	 * @param worldObjectType
	 * @param worldObjectPosition
	 */
	public WorldObject(WorldObjectType worldObjectType, Point worldObjectPosition) {
		this.worldObjectType = worldObjectType;
		this.worldObjectPosition = worldObjectPosition;
	}

	// Methods/Functions:
	
	/**
	 * Returns the Position of the World's object.
	 * 
	 * @return the Position of the World's object
	 */
	private Point getPosition() {
		return this.worldObjectPosition;
	}

	/**
	 * Returns the coordinate X of the Position of the World's object.
	 * 
	 * @return the coordinate X of the Position of the World's object
	 */
	private int getPositionX() {
		return this.worldObjectPosition.x;
	}

	/**
	 * Returns the coordinate Y of the Position of the World's object.
	 * 
	 * @return the coordinate Y of the Position of the World's object
	 */
	private int getPositionY() {
		return this.worldObjectPosition.y;
	}

	/**
	 * Updates the both coordinates of the current Position of the World's object.
	 * 
	 * @param x the coordinate X of the Position of the World's object
	 * @param y the coordinate Y of the Position of the World's object
	 */
	public void updatePosition(int x, int y) {
		this.worldObjectPosition.x = x;
		this.worldObjectPosition.y = y;
	}
}