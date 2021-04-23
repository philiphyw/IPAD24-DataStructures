
package day01carssorted;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;



public class Car {
    
    public Car(){}
    
    
    public Car(String dataString) throws InvalidDataException {
        String[] dataStringArr = dataString.split(";");
        if (dataStringArr.length!=3) {
            throw new InvalidDataException("Invalid data string;");
        }
        
        String makeModel;
        double engineSizeL=0;
        int prodYear=0;
        
        List<String>errList= new ArrayList<>();
        //get mamkeModel
         makeModel = dataStringArr[0];
        if (makeModel.equals("")) {
            errList.add("Make Model must not be empty");
        }
        
        
        //get engineSizeL
        try {
            engineSizeL = Double.parseDouble(dataStringArr[1]);//FormatException
        } catch (Exception e) {
           errList.add("Invalid data on engine size: " + dataStringArr[1]);
        }
        
        //get engineSizeL
          try {
            prodYear = Integer.parseInt(dataStringArr[2]);//FormatException
           Calendar c = Calendar.getInstance();  
           if (prodYear<=1900 ||prodYear>= c.get(Calendar.YEAR)) {
                  errList.add("Production year must between 1900 to current year: " + dataStringArr[2]);
              }
        } catch (Exception e) {
           errList.add("Invalid data on production year:"+ dataStringArr[2]);
        }
        
        if (errList.size()>0) {
            String errStr = "";
            for(String s:errList)
            {
            errStr+=s+"\n";
            }
            System.out.println(errStr);
            return;
        }
  
       this.setMakeModel(makeModel);
       this.setEngineSizeL(engineSizeL);
       this.setProdYear(prodYear);
        
          
    }
    
    
    public Car(String makeModel, double engineSizeL, int prodYear) {
        this.setMakeModel(makeModel);
        this.setEngineSizeL(engineSizeL);
        this.setProdYear(prodYear);
    }

    
    private String makeModel;
	private double engineSizeL;
	private int prodYear;

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public double getEngineSizeL() {
        return Math.round(this.engineSizeL * 100.0) / 100.0;
    }

    public void setEngineSizeL(double engineSizeL) {
        this.engineSizeL = engineSizeL;
    }

    public int getProdYear() {
        return prodYear;
    }

    public void setProdYear(int prodYear) {
        this.prodYear = prodYear;
    }


    @Override
    public String toString(){
    return String.format("%s;%s;%d", this.getMakeModel(),String.format("%.1f", this.getEngineSizeL()),this.getProdYear());
    }
   
}
