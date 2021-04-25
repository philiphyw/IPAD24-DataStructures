package day02jaggedarrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringJoiner;

public class Day02JaggedArrays {

    /**
     * @param args the command line arguments
     */
//    0. Print out the original array, one row per line
//1. Sum of all items
//2. Sum of each row
//3. Sum of each column (tricky)
//4. Cross-sum of surrounding elements (similar to a previous task) and create a new array with sum values.
    private static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            StringJoiner sj = new StringJoiner(",");
            for (int j = 0; j < arr[i].length; j++) {
                sj.add(String.valueOf(arr[i][j]));
            }
            System.out.println(sj.toString());
        }

    }

    private static int countAllItems(int[][] arr) {
        int itemCount = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                itemCount += 1;
            }
        }
        return itemCount;
    }

    private static int sumAllItems(int[][] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[i].length; j++) {
                result += arr[i][j];
            }
        }

        return result;
    }

    private static void sumByRow(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            int result = 0;
            for (int j = 0; j < arr[i].length; j++) {
                result += arr[i][j];
            }
            System.out.printf("The sum of row %d is:%d\n", i + 1, result);
        }

    }

    private static int[] sumByColumn(int[][] arr) {
        int maxColCount = maxColumnCount(arr);
        int[] colSumArr = new int[maxColCount];

        for (int i = 0; i < maxColCount; i++) {
            int colSum = 0;

            for (int j = 0; j < arr.length; j++) {
                try {
                    if (arr[j][i] != 0) {
                        colSum += arr[j][i];
                    }
                } catch (Exception e) {
                    continue;

                }
            }

            colSumArr[i] = colSum;
        }
        return colSumArr;
    }

    //use this function for easy count how many column per row for JaggedArray
    public static int maxColumnCount(int[][] arr) {
        int maxColCount = 0;
        int[] colCountArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            colCountArr[i] = arr[i].length;
            if (arr[i].length > maxColCount) {
                maxColCount = arr[i].length;
            }
        }

        return maxColCount;
    }

    //4. Cross-sum of surrounding elements (similar to a previous task) and create a new array with sum values.
    static int[][] getCrossSumArray(int[][] arr) {
        //initialize a 2d array, only declare its row, and the column will be dynamic
        int[][] crossSumArr = new int[arr.length][];

        for (int i = 0; i < arr.length; i++) {
            int[] rowArr = new int[arr[i].length];
            for (int j = 0; j < arr[i].length; j++) {
                rowArr[j] = sumOfCross(arr, i, j);
            }
            crossSumArr[i] = rowArr;
        }

        return crossSumArr;
    }

    //use below funcitons for calculation cross sum
    static int getIfExists(int[][] arr, int row, int col) {
        // If exists, return the element, otherwise return 0
        try {
            return arr[row][col];
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
    }

    static int sumOfCross(int[][] arr, int row, int col) {
        // return sum of the element at row/col
        // plus (if they exist) element above, below, to the left and right of it
        try {
            return getIfExists(arr, row, col)
                    + getIfExists(arr, row - 1, col - 1)
                    + getIfExists(arr, row, col - 1)
                    + getIfExists(arr, row + 1, col)
                    + getIfExists(arr, row, col + 1);
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
    }
    
    static int [] colCountByRow (int[][] arr){
        int[] colCountArr = new int[arr.length];
         for (int i = 0; i < arr.length; i++) {
            colCountArr[i] = arr[i].length;
            }
         return colCountArr;
    }



    public static void main(String[] args) {
        int[][] jaggedArray2d = {
            {1, 2},
            {3, 4, 5, 6, 7},
            {11, 12, 13, 14, 15, 16},
            {8, 9, 10}};
        //0. Print out the original array, one row per line
        System.out.println("0. Print out the original array, one row per line");
        printArray(jaggedArray2d);

        //1. Sum of all items
        System.out.println("1.Sum of all items:" + sumAllItems(jaggedArray2d));

        //2. Sum of each row
        System.out.println("2. Sum of each row");
        sumByRow(jaggedArray2d);

        //3. Sum of each column (tricky)
        int[] colSumArr = sumByColumn(jaggedArray2d);
        System.out.println("3. Sum of each column");
        for (int i = 0; i < colSumArr.length; i++) {
            System.out.printf("The sum of column %d is %d\n", i + 1, colSumArr[i]);
        }

        //4. Cross-sum of surrounding elements (similar to a previous task) and create a new array with sum values.
        System.out.println("4.  Cross-sum of surrounding elements");
        int[][] crossSumArr = getCrossSumArray(jaggedArray2d);
        //StringJoiner sj = new StringJoiner(",");
        StringJoiner sj;
        for (int i = 0; i < crossSumArr.length; i++) {
            sj = new StringJoiner(",");
            for (int j = 0; j < crossSumArr[i].length; j++) {
                sj.add(crossSumArr[i][j] + "");
            }
            System.out.println(sj.toString());
        }

    }

}
