/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day01carssorted;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author phili
 */
public class Day01CarsSorted {

    static ArrayList<Car> parking = new ArrayList<>();

    public static void main(String[] args) {
        //0. Read data from the file, if file doesn't exist, continue to execute the rest of the codes
             loadDataFromFile();
      

       

        //1. Print out cars, one per line (implement toString that displays all fields)
        showData();

        //2. Sort cars by makeModel using Comparable<Car> interaface or lamba and display the list
        parking.sort((Car c1, Car c2) -> c1.getMakeModel().compareTo(c2.getMakeModel()));
        System.out.println("\nArray sorted by Make Model:");
        showData();

        //3. Sort cars by engineSizeL (using Comparator<Car> or lamba) and display the list 
        parking.sort((Car c1, Car c2) -> Double.compare(c1.getEngineSizeL(), c2.getEngineSizeL()));
        System.out.println("\nArray sorted by engine size:");
        showData();

        //4. Sort cars by prodYear (using Comparator<Car> or lamba) and display the list
        parking.sort((Car c1, Car c2) -> Integer.compare(c1.getProdYear(), c2.getProdYear()));
        System.out.println("\nArray sorted by production year:");
        showData();

        // Sort cars by prodYear then makeModel (using Comparator<Car> or lamba) and if prodYear is the same then by makeModel (you need to create a few entries with the same prodYear to test this)
        Collections.sort(parking, (Car c1, Car c2) -> {
            int compProdYearResult = Integer.compare(c1.getProdYear(), c2.getProdYear());
            int compMakeModelResult = c1.getMakeModel().compareTo(c2.getMakeModel());

            if (compProdYearResult != 0) {
                return compProdYearResult;
            } else {
                return compMakeModelResult;
            }
        });

        System.out.println("\nArray sorted by production year, then sorted by Make Model:");
        showData();

    }

    static void loadDataFromFile() {
        try ( Scanner fileReader = new Scanner(new File("cars.txt"))) {
            while (fileReader.hasNextLine()) {
                parking.add(new Car(fileReader.nextLine()));
            }
        } catch (IOException | InvalidDataException e) {
            System.out.println(e.getMessage());
            System.out.println("No data are imported");
        }

    }

    static void showData() {
        for (var c : parking) {
            System.out.println(c.toString());
        }
    }
}
