/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmrnt2;

/**
 *
 * @author rgarc
 */

import javax.swing.*;

public class FrameDisplay extends JFrame
{   
    private GraphDisplay panel;

    /**
     * Creates an initializes the window frame.
     * 
     * @param width frame width
     * @param height frame height
     * @param g geometric objects to be depicted in this frame
     */
    public FrameDisplay(int width, int height, RectPolygon[] r, GeometricObject[] p)
    {
        setTitle("Selection of Points");
        setSize(width, height);
        //setResizable(false);

        panel = new GraphDisplay(width, height, r, p);
        add(panel);
        pack(); //sizes the frame so that all its contents (panel in this case) 
                //are at or above their preferred sizes
    }
}
