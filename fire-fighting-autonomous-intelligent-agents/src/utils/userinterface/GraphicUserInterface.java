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

package utils.userinterface;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import agents.world.WorldAgent;

/**
 * The class responsible for the Graphic User Interface.
 */
public class GraphicUserInterface {
	
	// Constants/Invariants:
	
	private static boolean active;
	private static WorldAgent worldAgent;
	
	
	// Global Instance Variables:
	
	private JFrame mainFrame;
	private static JLabel[][] WorldMapGrid;
    private static JTextArea textArea;
    private JPanel panel_3;
    private JPanel panel_4;
    
    // Constructors:
    
    /**
     * 
     */
    public GraphicUserInterface() {
    	GraphicUserInterface.active = false;
    }
}
