/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day03linkedlistarray;

/**
 *
 * @author phili
 */
public class Car {
    private int engineNum;

    public Car(int engineNum) {
        this.engineNum = engineNum;
    }

    @Override
    public String toString() {
        return "Car{" + "engineNum=" + engineNum + '}';
    }

    public int getEngineNum() {
        return engineNum;
    }

    public void setEngineNum(int engineNum) {
        this.engineNum = engineNum;
    }
   
}
