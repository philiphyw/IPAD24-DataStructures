/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day01arraysearch;

/**
 *
 * @author phili
 */
public class Day01ArraySearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] data2D = {
            {1, 3, 6, 8},
            {7, 1, 2, 3},
            {8, 3, 2, 1},
            {1, 7, 1, 9}};
        int row;
        int col;
        row = 0;
        col = 2;
        System.out.printf("The value of row %d, column %d is %d\n", row, col, getIfExists(data2D, row, col));
        System.out.printf("The cross sum of row %d, column %d is %d\n", row, col, sumOfCross(data2D, row, col));

        row = 13;
        col = 22;
        System.out.printf("The value of row %d, column %d is %d\n", row, col, getIfExists(data2D, row, col));
        System.out.printf("The cross sum of row %d, column %d is %d\n", row, col, sumOfCross(data2D, row, col));

        row = 2;
        col = 2;
        System.out.printf("The value of row %d, column %d is %d\n", row, col, getIfExists(data2D, row, col));
        System.out.printf("The cross sum of row %d, column %d is %d\n", row, col, sumOfCross(data2D, row, col));

    }

    static int getIfExists(int[][] data, int row, int col) {
        // If exists, return the element, otherwise return 0
        try {
            return data[row][col];
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
    }

    static int sumOfCross(int[][] data, int row, int col) {
        // return sum of the element at row/col
        // plus (if they exist) element above, below, to the left and right of it
        try {
            return getIfExists(data, row, col)
                    + getIfExists(data, row - 1, col - 1)
                    + getIfExists(data, row, col - 1)
                    + getIfExists(data, row + 1, col)
                    + getIfExists(data, row, col + 1);
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
    }

    // later: static void print2D(int[][] data) { ... }
   
    
    // later: static int[][] duplicateArray2D(int[][] orig2d) { ... }
}
