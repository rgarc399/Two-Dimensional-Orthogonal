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
import java.awt.Graphics;

/**
 * This class represents a rectilinear polygon with sides parallel to the axis;
 * polygon is given by its vertices listed in counterclockwise order.
 * 
 * Helped me with the isPointin method Gilbert Gomez (6025927)
 */
public class RectPolygon extends GeometricObject
{

    private Point[] vertexList; //list of vertices in clockwise order
    private int size;   //capacity of array vertexList
    private int vertNumber; //number of vertices of this polygon
    int population;
    

    /**
     * Instantiates an empty RectPolygon object. Vertex array size is
     * set to 4.
     */
    RectPolygon()
    {
        size = 100;
        vertexList = new Point[size];
        vertNumber = 0;
        
    }
    
    public void setPopulation(int pop)
    {
        population = pop;
    }
    
    public int getPopulation()
    {
        return population;
    }


    /**
     * Adds a vertex as the last one in the sequence of vertices. Vertex array
     * will be expanded to double its size if vertex cannot be added because
     * array is full.
     *
     * @param v the new vertex
     */
    public void addVertex(Point v)
    {
        vertexList[vertNumber] = v;
        vertNumber ++;
        
    }

    /**
     * Computes the area of this polygon using shoelace algorithm.
     *
     * @return area of this polygon
     */
    public double area()
    {
        if(vertNumber<4) 
            return Double.NaN;
        double sum1 = 0.0, sum2 = 0.0;
        Point v1, v2;
        for(int i = 0; i < vertNumber; i++) 
        {
            v1 = vertexList[i];
            v2 = vertexList[(i + 1) % vertNumber];
            
            sum1 += v1.getX() * v2.getY();
            sum2 += v2.getX() * v1.getY();
        }
        
        double area = 0.5 * Math.abs(sum1 -sum2);
        return area;
        
    }

    /**
     * Determines the smallest rectangle bounding this polygon.
     *
     * @return bounding rectangle
     */
    public Rectangle boundingRectangle()
    {
        return new Rectangle();
    }

    /**
     * Draws this polygon.
     *
     * @param g graphics context
     */
    @Override
    public void draw(Graphics g)
    {
        
        int x[] = new int [vertNumber];
        int y[] = new int [vertNumber];
        for(int i = 0; i < size; i++){
            x[i] = (int) vertexList[i].getX();
            y[i] = (int) vertexList[i].getY();
        }
        g.setColor(getInteriorColor());
        g.fillPolygon(x, y, size);
        
        g.setColor(getBoundaryColor());
        g.drawPolygon(x, y, size);
    }

    /**
     * Returns the number of vertices in this polygon
     *
     * @return number of vertices in this polygon
     */
    public int getNumberOfVertices()
    {
        return vertNumber;
    }

    /**
     * Determines the greatest x.
     *
     * @return the greatest x
     */
    public double greatestX()
    {
        double gx = vertexList[0].getX();
        
        for(int i = 1; i <= vertNumber; i++)
        {
            double vi = vertexList[i].getX();
            if(gx < vi)
                gx = vi;
        }
        return gx;
    }

    /**
     * Determines the greatest y.
     *
     * @return the greatest y
     */
    public double greatestY()
    {
        double gy = vertexList[0].getY();
        
        for(int i = 1; i <= vertNumber; i++)
        {
            double vi = vertexList[i].getY();
            if(gy < vi)
                gy = vi;
        }
        return gy;
    }

    /**
     * Determines if given point is contained in this polygon.
     *
     * @param p given point
     * @return true if p is on the boundary or the interior of this polygon.
     */
    
    
    public boolean isPointInRectPolygon(Point p)
    {  
      int i,j ;
      double iY, iX, jY, jX;
              
      boolean result = false;
      
      for (i = 0, j = vertNumber - 1; i < vertNumber; j = i++) 
      {
          
          iY = vertexList[i].getY();
          iX = vertexList[i].getX();
          jY = vertexList[j].getY();
          jX = vertexList[j].getX();
          
        if ((iY > p.getY()) != (jY > p.getY()) && (p.getX() < (jX - iX) 
                * (p.getY() - iY) / (jY - iY) + iX)) {
          result = !result;
         }
      }
      return result;
    }
    

    /**
     * Determines the smallest x.
     *
     * @return the smallest x
     */
    public double smallestX()
    {
        double gx = vertexList[0].getX();
        
        for(int i = 1; i <= vertNumber; i++)
        {
            double vi = vertexList[i].getX();
            if(gx > vi)
                gx = vi;
        }
        return gx;
    }

    /**
     * Determines the smallest y.
     *
     * @return the smallest y
     */
    public double smallestY()
    {
        double gy = vertexList[0].getY();
        
        for(int i = 1; i <= vertNumber; i++)
        {
            double vi = vertexList[i].getY();
            if(gy > vi)
                gy = vi;
        }
        return gy;
    }

    /**
     * Constructs a String description of this polygon.
     *
     * @return String containing vertices of this polygon.
     */
    @Override
    public String toString()
    { 
        String str = "Polygon " + super.toString() + "\n";
        for(int i = 0; i < vertNumber; i++)
        {
            str += vertexList[i].getX() + "\n" + vertexList[i].getY();
                    
        }
        return str;
    }

    /**
     * Translates this polygon by given vector.
     *
     * @param v given vector
     */
    public void translate(Vector v)
    {
        for(Point vertexList1 : vertexList) {
            vertexList1.translate(v);
        }
    }

}
