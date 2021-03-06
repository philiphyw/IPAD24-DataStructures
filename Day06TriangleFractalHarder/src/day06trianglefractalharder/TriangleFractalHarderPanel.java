/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day06trianglefractalharder;

import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author phili
 */
public class TriangleFractalHarderPanel extends javax.swing.JPanel {

    /**
     * Creates new form TriangleFractalHarderPanel
     */
    public TriangleFractalHarderPanel() {
        //initComponents();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        //get shorter length in getWidth() and getHeight(), use it as the baseline to make sure the triangle is always equilateral
        int baseline = getWidth() <= getHeight() ? getWidth() : getHeight();
        baseline = baseline - 10;//set 10 padding
        int height = (int) Math.sqrt(Math.pow(baseline, 2) - Math.pow(baseline * 50 / 100, 2));

        int x1 = baseline * 50 / 100 + 5;//left padding = 5;
        int y1 = 5;//to padding = 6;
        int x2 = 5;
        int y2 = height + 5;
        int x3 = baseline + 5;
        int y3 = height + 5;

        g2d.drawLine(x1, y1, x2, y2);
        g2d.drawLine(x1, y1, x3, y3);
        g2d.drawLine(x2, y2, x3, y3);

        drawFractal(g2d, x1, y1, x2, y2, x3, y3);

        System.out.println("Triangle edge: " + baseline);
        System.out.println("Triangle height:" + height);

    }

    private void drawFractal(Graphics2D g2d, int x1, int y1, int x2, int y2, int x3, int y3) {
        //1. Set end recursion condition
        double edge = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
        if (edge < 2) {
            return;
        }

        //2. draws the first level 0 children triangle
        int lv0AX = (x2 + x3) / 2;
        int lv0AY = (y2 + y3) / 2;
        int lv0BX = (x1 + x3) / 2;
        int lv0BY = (y1 + y3) / 2;
        int lv0CX = (x1 + x2) / 2;
        int lv0CY = (y1 + y3) / 2;

        drawTriangle(g2d, lv0AX, lv0AY, lv0BX, lv0BY, lv0CX, lv0CY);

        //3. draw the first level 1 children triangle
        int lv1AX1 = (lv0CX + lv0BX) / 2;
        int lv1AY1 = (lv0CY + lv0BY) / 2;
        int lv1BX1 = (x1 + lv0CX) / 2;
        int lv1BY1 = (y1 + lv0CY) / 2;
        int lv1CX1 = (x1 + lv0BX) / 2;
        int lv1CY1 = (y1 + lv0BY) / 2;
         drawTriangle(g2d, lv1AX1, lv1AY1, lv1BX1, lv1BY1, lv1CX1, lv1CY1);
         
                 //4. draw the second level 1 children triangle
        int lv1AX2 = (lv0AX + lv0BX) / 2;
        int lv1AY2 = (lv0AY + lv0BY) / 2;
        int lv1BX2 = (lv0AX + x3) / 2;
        int lv1BY2 = (lv0AY + y3) / 2;
        int lv1CX2 = (lv0BX + x3) / 2;
        int lv1CY2 = (lv0BY + y3) / 2;
         drawTriangle(g2d, lv1AX2, lv1AY2, lv1BX2, lv1BY2, lv1CX2, lv1CY2);
         
           //5. draw the third level 1 children triangle
        int lv1AX3 = (lv0CX + lv0AX) / 2;
        int lv1AY3 = (lv0CY + lv0AY) / 2;
        int lv1BX3 = (lv0AX + x2) / 2;
        int lv1BY3 = (lv0AY + y2) / 2;
        int lv1CX3 = (lv0CX + x2) / 2;
        int lv1CY3 = (lv0CY + y2) / 2;
         drawTriangle(g2d, lv1AX3, lv1AY3, lv1BX3, lv1BY3, lv1CX3, lv1CY3);
        
        //3. recursive calls,
        drawFractal(g2d,lv0CX,lv0CY,x2,y2,lv0AX,lv0AY);
    }

    private void drawTriangle(Graphics2D g2d, int x1, int y1, int x2, int y2, int x3, int y3) {
        g2d.drawLine(x1, y1, x2, y2);
        g2d.drawLine(x1, y1, x3, y3);
        g2d.drawLine(x2, y2, x3, y3);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
