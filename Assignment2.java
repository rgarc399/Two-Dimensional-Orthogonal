/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmrnt2;
import java.awt.Color;
import java.util.Random;
import javax.swing.*;
/**
 *
 * @author rgarc
 */
public class Assignment2
{
    public static void main(String[] args)
    {
        new Assignment2();
    }
    
    public Assignment2()
    {       
        //frame size
        //int frameWidth = 1200;
        //int frameHeight = 600;
        
        //Defining the geometric objects that represent the problem data
        int pointNumber = 20;
        Point[] pArray = new Point[pointNumber];
        RectPolygon[]rArray = new RectPolygon[5];
        Point p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20;
            
        //Miami- Dade
        p1 = new Point(374, 400);
        p2 = new Point(314, 412);
        p3 = new Point(463, 503);
        p4 = new Point(370, 520);
        
        p1.setPopulation(100);
        p2.setPopulation(900);
        p3.setPopulation(100);
        p4.setPopulation(2000);
        
        pArray[0] = p1;
        pArray[1] = p2;
        pArray[2] = p3;
        pArray[3] = p4;
        
        rArray[0] = new RectPolygon();
        rArray[0].addVertex(p1);
        rArray[0].addVertex(p2);
        rArray[0].addVertex(p3);
        rArray[0].addVertex(p4);
        rArray[0].setPopulation(600);
        
        
        //Broward
        p5 = new Point(383, 343);
        p6 = new Point(532, 353);
        p7 = new Point(520, 383);
        p8 = new Point(374, 393);
        
        p5.setPopulation(350);
        p6.setPopulation(487);
        p7.setPopulation(600);
        p8.setPopulation(900);
        
        pArray[4] = p5;
        pArray[5] = p6;
        pArray[6] = p7;
        pArray[7] = p8;
        
        rArray[1] = new RectPolygon();
        rArray[1].addVertex(p5);
        rArray[1].addVertex(p6);
        rArray[1].addVertex(p7);
        rArray[1].addVertex(p8);
        rArray[0].setPopulation(2000);
        
        //Palm Beach
        p9 = new Point(424, 247);
        p10 = new Point(514, 254);
        p11 = new Point(528, 330);
        p12 = new Point(365, 336);
        
        p9.setPopulation(150);
        p10.setPopulation(100);
        p11.setPopulation(300);
        p12.setPopulation(900);
        
        pArray[8] = p9;
        pArray[9] = p10;
        pArray[10] = p11;
        pArray[11] = p12;
        
        rArray[2] = new RectPolygon();
        rArray[2].addVertex(p9);
        rArray[2].addVertex(p10);
        rArray[2].addVertex(p11);
        rArray[2].addVertex(p12);
        rArray[0].setPopulation(4000);
        
        //Martin County
        p13 = new Point(406, 224);
        p14 = new Point(497, 219);
        p15 = new Point(515, 239);
        p16 = new Point(432, 247);
        
        p13.setPopulation(350);
        p14.setPopulation(600);
        p15.setPopulation(900);
        p16.setPopulation(1000);
        
        pArray[12] = p13;
        pArray[13] = p14;
        pArray[14] = p15;
        pArray[15] = p16;
        
        rArray[3] = new RectPolygon();
        rArray[3].addVertex(p13);
        rArray[3].addVertex(p14);
        rArray[3].addVertex(p15);
        rArray[3].addVertex(p16);
        rArray[0].setPopulation(5000);
        
        //Manattan
        p17 = new Point(410, 157);
        p18 = new Point(464, 161);
        p19 = new Point(490, 205);
        p20 = new Point(398, 215);
        
        p17.setPopulation(600);
        p18.setPopulation(2000);
        p19.setPopulation(3000);
        p20.setPopulation(900);
        
        pArray[16] = p17;
        pArray[17] = p18;
        pArray[18] = p19;
        pArray[19] = p20;
        
        rArray[4] = new RectPolygon();
        rArray[4].addVertex(p17);
        rArray[4].addVertex(p18);
        rArray[4].addVertex(p19);
        rArray[4].addVertex(p20);
        rArray[4].setPopulation(6000);
        
        //graphing
        FrameDisplay frame = new FrameDisplay(650, 650, rArray, pArray);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
