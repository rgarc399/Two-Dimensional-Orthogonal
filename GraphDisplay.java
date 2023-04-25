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
import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JFrame;

public class GraphDisplay extends JPanel implements MouseMotionListener, MouseListener
{
    GeometricObject[] gArray; //geometric objects
    RectPolygon[] rArray;
    Point begin; //initial point of the selection rectangle
    Rectangle selectionRectangle; //rectangle that the user draws dynamically
    private BufferedImage image;
    String description;

    /**
     * Parameterized constructor.
     */
    public GraphDisplay(int width, int height, RectPolygon[] r, GeometricObject[] g)
    {
        this.gArray = g;
        this.rArray = r;
        begin = null;
        selectionRectangle = null;
       
        addMouseMotionListener(this);
        addMouseListener(this);
        
        setBackground(Color.black);
        Dimension d = new Dimension(width, height);
        setPreferredSize(d);
        
        try
        {
            image = ImageIO.read(new File("South Florida.png"));
        }
        catch (IOException ex)
        {
            System.out.println("Image file not found!");
        } 
        description = "";
        
    }

    @Override
    public void mouseClicked(MouseEvent e){
    
    
    
    }

    /**
     * Continuously redefines the second corner of the selection rectangle 
     * as the user drags the mouse.
     * 
     * @param e 
     */
    @Override
    public void mouseDragged(MouseEvent e)
    {
        Point end = new Point(e.getX(), e.getY());
        selectionRectangle = new Rectangle(begin, end);
        
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e){}

    @Override
    public void mouseExited(MouseEvent e){}

    @Override
    public void mouseMoved(MouseEvent e){}

    /**
     * The first corner of the selection rectangle is set in this method.
     * 
     * @param e 
     */
    @Override
    public void mousePressed(MouseEvent e)
    {
        begin = new Point(e.getX(), e.getY());
    }

    /**
     * The final value of the second corner of the selection rectangle is set
     * in this method (the first corner was set in mousePressed); range search
     * is then performed.
     * 
     * @param e 
     */
    @Override
    public void mouseReleased(MouseEvent e)
    {
        Point end = new Point(e.getX(), e.getY());
        selectionRectangle = new Rectangle(begin, end);
        begin = null;
        JFrame frame = new JFrame();
        
        int numCounties = 0;
        int min = 0;
        int max = 0;
        int total = 0;
        
        Point[] pArray = Algorithms.inRectangle(gArray, selectionRectangle);
        
        if(pArray.length == 0)
        {
            JOptionPane.showMessageDialog(frame, "Nothing Selected");
        }
        else
        {
        
            for(int i = 0; i < pArray.length; i++)
            {
                for(int j=0; j<rArray.length; j++)
                {
                    if(pArray[j].getPopulation() == rArray[i].getPopulation());
                    numCounties++;
                    total += pArray[i].getPopulation();
                    break;
                } 
            }
            
            min = pArray[0].getPopulation();
            for(int i=0; i<pArray.length; i++)
            {
                if(pArray[i].getPopulation() < min)
                    min = pArray[i].getPopulation();
            }
            
            max = pArray[0].getPopulation();
            for(int i=0; i<pArray.length; i++)
            {
                if(pArray[i].getPopulation() > max)
                    max = pArray[i].getPopulation();
            }
            
            
            
            int avg = total / numCounties;
            
            
            JOptionPane.showMessageDialog(frame, "number of Counties(s) selected: "
                    + numCounties + " \n"
                    + "Minimum population: " + min + "\n"
                    + "Maximim: " + max + "\n"
                    + "Average: " + avg + "\n"
                    + "Total: " + total);
        }
        repaint();
    }

    /**
     * Paints this panel; the system invokes it every time
     * it deems necessary to redraw the panel.
     */
    @Override
    public void paint(Graphics g)
    {
        super.paint(g); //clears window

        //draws geometric objects
        if (selectionRectangle != null)
            selectionRectangle.draw(g);

        for (GeometricObject e:gArray)
        {
            e.draw(g); //invokes object's draw method through polymorphism
        }
        Dimension d = getSize();
        g.drawImage(image, 0, 0, d.width, d.height, this);
        
        
    }
}
