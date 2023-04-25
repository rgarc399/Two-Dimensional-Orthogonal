/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmrnt2;

import java.awt.*;

abstract public class GeometricObject
{
    private Color boundaryColor;        //boundary color
    private Color interiorColor;        //interior color

    public GeometricObject()
    {
        interiorColor = Color.yellow;
        boundaryColor = Color.black;
    }

    public GeometricObject(Color iC, Color bC)
    {
        interiorColor = iC;
        boundaryColor = bC;
    }

    abstract public void draw(Graphics g);

    public Color getBoundaryColor()
    {
        return boundaryColor;
    }
    
    public Color getInteriorColor()
    {
        return interiorColor;
    }

    public void setBoundaryColor(Color boundaryColor)
    {
        this.boundaryColor = boundaryColor;
    }
    
    public void setInteriorColor(Color interiorColor)
    {
        this.interiorColor = interiorColor;
    }

    @Override
    public String toString()
    {
        String str;
        str = boundaryColor.getRed() + " " +
              boundaryColor.getGreen() + " " +
              boundaryColor.getBlue() + " " +
              boundaryColor.getAlpha() + " " +
              interiorColor.getRed() + " " +
              interiorColor.getGreen() + " " +
              interiorColor.getBlue() + " " +
              interiorColor.getAlpha();
        
        return str;
    }
    
}