/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day01carssorted;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author phili
 */
public class Day01CarsSorted {
    static ArrayList<Car> parking = new ArrayList<>();

    public static void main(String[] args) {
        loadDataFromFile();
        
        for(var c:parking)
        {
            System.out.println(c.toString());
        }
    }
    
        static void loadDataFromFile() {
        try (Scanner fileReader = new Scanner(new File("cars.txt"))) {
            while (fileReader.hasNextLine()) {
                parking.add(new Car(fileReader.nextLine()));
            }
        } catch (IOException | InvalidDataException e  ) {
            System.out.println(e.getMessage());
        }

    }
    
}
