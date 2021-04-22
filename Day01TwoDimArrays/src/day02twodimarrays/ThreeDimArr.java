/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day02twodimarrays;

/**
 *
 * @author phili
 */



public class ThreeDimArr {
   
    public ThreeDimArr(){};
    
    public ThreeDimArr(int rowNum, int colNum, int cellValue) {
        this.setRowNum (rowNum);
        this.setColNum(colNum);
        this.setCellValue(cellValue);
    }

    
    
    private int rowNum;
    private int colNum;
    private int cellValue;
    
    
    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getColNum() {
        return colNum;
    }

    public void setColNum(int colNum) {
        this.colNum = colNum;
    }

    public int getCellValue() {
        return cellValue;
    }

    public void setCellValue(int cellValue) {
        this.cellValue = cellValue;
    }
    
    
}
