/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day02twodimarrays;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 *
 * @author phili
 */
public class Day01TwoDimArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrRow = 0;
        int arrColumn = 0;
        while (true) {
            try {
                System.out.print("Pls enter the row of the array: ");
                arrRow = sc.nextInt();
                System.out.print("Pls enter the column of the array: ");
                arrColumn = sc.nextInt();
                sc.nextLine();
                if (arrRow >= 1 && arrColumn >= 1) {
                    break;
                } else {
                    System.out.println("The row and column be 1 or greater");
                }

            } catch (InputMismatchException ex) {
                System.out.println("Invalid number");
                sc.nextLine();
                continue;
            }
        }

        int[][] twoDimArr = new int[arrRow][arrColumn];
        for (int i = 0; i < arrRow; i++) {
            for (int j = 0; j < arrColumn; j++) {
                twoDimArr[i][j] = -99 + (int) (199 * Math.random());
            }
        }

        TwoDimArraysHelper helper = new TwoDimArraysHelper();

        //0 show all numbers in one line, separate by comma
        String allNumber = helper.listAllNumbers(twoDimArr);
        System.out.printf("All numbers in the array: %s\n", allNumber);

        // 1) Sum of all numbers in the array
        int allNumberSum = helper.sumAllNumbers(twoDimArr);
        System.out.printf("Sum of all numbers in the array: %d\n", allNumberSum);
        
        // 2) Sum of each of the row of the array
        System.out.println("Sum of each of the row of the array");
        int[] sumByRowArr = helper.sumByRow(twoDimArr);
        for (int i = 0; i < sumByRowArr.length; i++) {
            System.out.printf("The sum of row %d is %d\n", i + 1, sumByRowArr[i]);
        }

        // 3) Sum of each of the column of the array
         System.out.println("Sum of each of the column of the array");
         int[] sumByColArr = helper.sumByColumn(twoDimArr);
          for (int i = 0; i < sumByColArr.length; i++) {
            System.out.printf("The sum of column %d is %d\n", i + 1, sumByColArr[i]);
        }
         
          
        //  4) Standard deviation of all numbers in the array
        System.out.println("Standard deviation of all numbers in the array ");
        double strdDeviation = helper.getStrdDeviation(twoDimArr);
        System.out.printf("The stanard deviation of the array is %f\n", strdDeviation);
        
        
        //5) Find pairs of numbers in the array whose sum is a prime number and display those pairs and their sum. Make sure you only show each pair *once*. You are allowed to use ArrayList here to hold the result.
         System.out.println("Find pairs of numbers in the array whose sum is a prime number and display those pairs and their sum ");
         List<String> primeSumList = helper.getPrimeSum(twoDimArr);
     
         for (int i = 0; i < primeSumList.size(); i++) {
             System.out.println(primeSumList.get(i));
        }
        
        
//        StringJoiner sj;
//        int rowSum;
//        int elementCount=0;
//
//        String[] rowContent = new String[arrRow];
//        int[] rowSumArr = new int[arrRow];
//
//       
//        for (int i = 0; i < arrRow; i++) {
//            sj = new StringJoiner(",");
//            rowSum = 0;
//            for (int j = 0; j < arrColumn; j++) {
//                twoDimArr[i][j] = -99 + (int) (199 * Math.random());
//                sj.add(String.valueOf(twoDimArr[i][j]));
//                rowSum += twoDimArr[i][j];
//                elementCount+=1;
//            }
//
//            rowContent[i] = sj.toString();
//            rowSumArr[i] = rowSum;
//        }
//        //print out elements by row
//        System.out.println("print out elements by row");
//        for (int i = 0; i < rowContent.length; i++) {
//            System.out.println("Elements in row " + (i + 1) + ": " + rowContent[i]);
//        }
//        System.out.println("\n");
//
//        //print out the row sum by row
//        System.out.println("print out the row sum by row");
//        for (int i = 0; i < rowSumArr.length; i++) {
//            System.out.println("Element sum in row " + (i + 1) + ": " + rowSumArr[i]);
//        }
//        System.out.println("\n");
//        //Sum of each of the column of the array
//        System.out.println("print out the Sum of each of the column ");
//        int[] columnSumArr = new int[arrColumn];
//        int columnArr;
//
//        for (int i = 0; i < arrColumn; i++) {
//            columnArr = 0;
//            for (int j = 0; j < arrRow; j++) {
//                columnArr += twoDimArr[j][i];
//            }
//            columnSumArr[i] = columnArr;
//        }
//
//        for (int i = 0; i < columnSumArr.length; i++) {
//            System.out.println("Element sum in column " + (i + 1) + ": " + columnSumArr[i]);
//        }
//
//        System.out.println("\n");
//        //Standard deviation of all numbers in the array
//        System.out.println("Standard deviation of all numbers in the array ");
//        int totalNum = 0;
//        for (int i = 0; i < rowSumArr.length; i++) {
//            totalNum += rowSumArr[i];
//        }
//        double meanNum = (double) totalNum / elementCount;
//
//        double devSum = 0;
//        for (int i = 0; i < arrRow; i++) {
//            for (int j = 0; j < arrColumn; j++) {
//                devSum += Math.pow((double) twoDimArr[i][j] - meanNum, 2);
//            }
//
//        }
//        
//        double standardDeviation = Math.sqrt(devSum/elementCount); //Math.pow(devSum/elementCount,0.5);
//        
//        System.out.printf("Standard deviation of all numbers in the array is %f ",standardDeviation);
//         System.out.println("\n");
//         
//         
//        //Find pairs of numbers in the array whose sum is a prime number and display those pairs and their sum.
//        System.out.println("Find pairs of numbers in the array whose sum is a prime number and display those pairs and their sum ");
//       //step 1 convert multidimesional array to one dimesional array
//       int[] oneDimArr = new int[elementCount];
//       int curIndex=0;
//        for (int i = 0; i < arrRow; i++) {         
//            for (int j = 0; j < arrColumn; j++) {
//               oneDimArr[curIndex]=twoDimArr[i][j] ;
//               curIndex+=1;
//            }
//        }
//        
//         //step 2 check elements sum in oneDimArr
//        for (int i = 0; i < oneDimArr.length-1; i++) {
//            int curValue = oneDimArr[i];
//            for (int j = i+1; j < oneDimArr.length; j++) {
//                if (isPrime(curValue,oneDimArr[j])) {
//                    System.out.printf("The sum of %d number and %d number is a prime number, %d plus %d equals %d\n", i+1,j+1,curValue,oneDimArr[j],curValue+oneDimArr[j]);
//                }
//            }
//        }        
    }

}
