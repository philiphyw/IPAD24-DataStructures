
package day02twodimarrays;



// Purpose of this class is to act as a entity to enbale prime number check result with row,col and value info.
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
