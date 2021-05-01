/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day07crossfractal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author phili
 */
public class CrossFractalPanel extends javax.swing.JPanel {

    /**
     * Creates new form CrossFractalPanel
     */
    public CrossFractalPanel() {
        // initComponents();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        //get shorter length in getWidth() and getHeight(), use it as the baseline to make sure the triangle is always equilateral
        int bl = getWidth() <= getHeight() ? getWidth() : getHeight();//set baseline
        bl -= 10;
        int pd = 5;
        Point A = new Point(pd,pd);
        Point B = new Point (pd+bl,pd);
        drawFractal(g2d, A, B,0);
    }

    private void drawFractal(Graphics2D g2d, Point a, Point b,int level) {
        //1. Set end recursion condition
        int bl = Math.abs(a.x - b.x);
        if (level> 4) {
            return;
        }

        //2. set color and points
         g2d.setColor(colorArray[level]);

        //Set the first point
        Point pT0 = new Point(a.x, a.y);//first point at the top left conner; 
        Point pB0 = new Point(a.x, a.y + bl);//first point at the bottom left conner; 

        //set the  top horizental points 
        Point pT1 = new Point(a.x + bl * 1 / 5, a.y);
        Point pT2 = new Point(a.x + bl * 2 / 5, a.y);
        Point pT3 = new Point(a.x + bl * 3 / 5, a.y);
        Point pT4 = new Point(a.x + bl * 4 / 5, a.y);
        Point pT5 = new Point(a.x + bl, a.y);

        //set the  bottom horizental points 
        Point pB1 = new Point(a.x + bl * 1 / 5, a.y + bl);
        Point pB2 = new Point(a.x + bl * 2 / 5, a.y + bl);
        Point pB3 = new Point(a.x + bl * 3 / 5, a.y + bl);
        Point pB4 = new Point(a.x + bl * 4 / 5, a.y + bl);
        Point pB5 = new Point(a.x + bl, a.y + bl);

        //set the left vertical point
        Point pL1 = new Point(a.x, a.y + bl * 1 / 5);
        Point pL2 = new Point(a.x, a.y + bl * 2 / 5);
        Point pL3 = new Point(a.x, a.y + bl * 3 / 5);
        Point pL4 = new Point(a.x, a.y + bl * 4 / 5);

        //set the right vertical point
        Point pR1 = new Point(a.x + bl, a.y + bl * 1 / 5);
        Point pR2 = new Point(a.x + bl, a.y + bl * 2 / 5);
        Point pR3 = new Point(a.x + bl, a.y + bl * 3 / 5);
        Point pR4 = new Point(a.x + bl, a.y + bl * 4 / 5);

        //set the 4 points at the middle 
        Point pM1 = new Point(a.x + bl * 2 / 5, a.y + bl * 2 / 5);
        Point pM2 = new Point(a.x + bl * 3 / 5, a.y + bl * 2 / 5);
        Point pM3 = new Point(a.x + bl * 2 / 5, a.y + bl * 3 / 5);
        Point pM4 = new Point(a.x + bl * 3 / 5, a.y + bl * 3 / 5);

        //draw the outside box
        g2d.drawLine(pT0.x, pT0.y, pT5.x, pT5.y);
        g2d.drawLine(pT5.x, pT5.y, pB5.x, pB5.y);
        g2d.drawLine(pT0.x, pT0.y, pB0.x, pB0.y);
        g2d.drawLine(pB0.x, pB0.y, pB5.x, pB5.y);

        //draw the 8 lines at the middle to form a cross
        g2d.drawLine(pL2.x, pL2.y, pM1.x, pM1.y);
        g2d.drawLine(pT2.x, pT2.y, pM1.x, pM1.y);
        g2d.drawLine(pT3.x, pT3.y, pM2.x, pM2.y);
        g2d.drawLine(pR2.x, pR2.y, pM2.x, pM2.y);
        g2d.drawLine(pL3.x, pL3.y, pM3.x, pM3.y);
        g2d.drawLine(pB2.x, pB2.y, pM3.x, pM3.y);
        g2d.drawLine(pR3.x, pR3.y, pM4.x, pM4.y);
        g2d.drawLine(pB3.x, pB3.y, pM4.x, pM4.y);

        //3. recursive calls,
        level+=1;
        drawFractal(g2d, pT0, pT2,level);
        drawFractal(g2d, pT3, pT5,level);
        drawFractal(g2d, pL3, pM3,level);
        drawFractal(g2d, pM4, pR3,level);
    }

    private class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

     private Color [] colorArray = {
        new Color(255, 90, 90),
        new Color(0, 200, 0),
        new Color(90, 90, 255),
        new Color(10, 10, 84),
        new Color(22, 21, 61),
        new Color(21, 98, 69),
        new Color(217, 146, 54),
        new Color(63, 121, 186),
        new Color(131, 121, 11)
    };
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
