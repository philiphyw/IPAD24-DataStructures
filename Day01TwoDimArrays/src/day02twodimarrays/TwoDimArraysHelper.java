/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day02twodimarrays;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 *
 * @author phili
 */
public class TwoDimArraysHelper {

    public String listAllNumbers(int[][] intArr) {
        StringJoiner sj = new StringJoiner(",");

        for (int i = 0; i < intArr.length; i++) {
            for (int j = 0; j < intArr[i].length; j++) {
                sj.add(String.valueOf(intArr[i][j]));
            }
        }
        return sj.toString();
    }

    public int sumAllNumbers(int[][] intArr) {
        int result = 0;

        for (int i = 0; i < intArr.length; i++) {
            for (int j = 0; j < intArr[i].length; j++) {
                result += intArr[i][j];
            }
        }
        return result;
    }

    public int countAllNumbers(int[][] intArr) {
        int result = 0;

        for (int i = 0; i < intArr.length; i++) {
            for (int j = 0; j < intArr[i].length; j++) {
                result += 1;
            }
        }
        return result;
    }

    public int[] sumByRow(int[][] intArr) {
        int rowCount = intArr.length;
        if (rowCount <= 0) {
            return null;
        } else {
            int[] sumRowArr = new int[rowCount];
            int rowSum;
            for (int i = 0; i < intArr.length; i++) {
                rowSum = 0;
                if (intArr[i].length > 0) {
                    for (int j = 0; j < intArr[i].length; j++) {
                        rowSum += intArr[i][j];
                    }
                }
                sumRowArr[i] = rowSum;
            }
            return sumRowArr;
        }

    }

    public int[] sumByColumn(int[][] intArr) {
        int rowCount = intArr.length;
        int colCount = intArr[0].length;
        if (colCount <= 0) {
            return null;
        } else {
            int[] sumColArr = new int[colCount];
            int colSum;
            for (int i = 0; i < colCount; i++) {
                colSum = 0;
                for (int j = 0; j < rowCount; j++) {
                    colSum += intArr[j][i];
                }
                sumColArr[i] = colSum;
            }
            return sumColArr;
        }
    }

    public double getStrdDeviation(int[][] intArr) {
        double standardDeviation;
        TwoDimArraysHelper helper = new TwoDimArraysHelper();
        int totalSum = helper.sumAllNumbers(intArr);
        int totalCount = helper.countAllNumbers(intArr);
        double meanNum = (double) totalSum / totalCount;

        double devSum = 0;
        for (int[] intArr1 : intArr) {
            for (int j = 0; j < intArr[0].length; j++) {
                devSum += Math.pow((double) intArr1[j] - meanNum, 2);
            }
        }

        standardDeviation = Math.pow(devSum / totalCount, .5);
        return standardDeviation;
    }

    public List<String> getPrimeSum(int[][] intArr) {
        TwoDimArraysHelper helper = new TwoDimArraysHelper();
        int elementCount = helper.countAllNumbers(intArr);
        List<String> PrimeSumStringList = new ArrayList<>();

        ThreeDimArr[] ThreeDimArrArray = new ThreeDimArr[elementCount];
        // List<ThreeDimArr> ThreeDimArrList = new ArrayList<ThreeDimArr>();
        int curIndex = 0;

        for (int i = 0; i < intArr.length; i++) {
            for (int j = 0; j < intArr[0].length; j++) {
                ThreeDimArr tda = new ThreeDimArr(i, j, intArr[i][j]);
                ThreeDimArrArray[curIndex] = tda;
                curIndex++;
            }
        }

        for (int i = 0; i < ThreeDimArrArray.length - 1; i++) {
            ThreeDimArr curTda = ThreeDimArrArray[i];
            for (int j = i + 1; j < ThreeDimArrArray.length; j++) {
                ThreeDimArr nextTda = ThreeDimArrArray[j];
                if (helper.isPrime(curTda.getCellValue(), nextTda.getCellValue())) {
                    String primeSumString = String.format("Prime sum %d of pair value=%d at [%d,%d] and value=%d at [%d,%d]",
                            curTda.getCellValue() + nextTda.getCellValue(),
                            curTda.getCellValue(),
                            curTda.getRowNum(),
                            curTda.getColNum(),
                            nextTda.getCellValue(),
                            nextTda.getRowNum(),
                            nextTda.getColNum()
                    );
                    PrimeSumStringList.add(primeSumString);                   
                }

            }

        }

        return PrimeSumStringList;
    }

    public boolean isPrime(int n1, int n2) {
        int sum = n1 + n2;
        //definition of prime numbers: 
        //the number is larger than 1;
        //the number has only 2 factors: 1 and itself. Like 2,3,5,7,11

        if (sum < 1) {
            return false;
        }

        for (int i = 2; i < sum / 2; i++) {
            if (sum % i == 0) {
                return false;
            }
        }
        return true;
    }
}
