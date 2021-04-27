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
public class Day03LinkedListArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedListArrayOfStrings ls = new LinkedListArrayOfStrings();

        ls.add("This is the first string");

        ls.add("This is the second string");

        ls.add("This is originally the third string");

        ls.insertValueAtIndex(2, "This is the string which inerted before the original third string");
        ls.insertValueAtIndex(0, "This is the string which inerted before the original first string");

        for (int i = 0; i < ls.getSize(); i++) {
            System.out.println(ls.get(i));
        }
        
        
        System.out.println("-----------Delete by Index - 1: delete arr[arr.getSize()-1]---------------");
        ls.deleteByIndex(ls.getSize()-1);
                for (int i = 0; i < ls.getSize(); i++) {
            System.out.println(ls.get(i));
        }
        
        System.out.println("-----------Delete by value - 1: delete This is the first string---------------");

        ls.deleteByValue("This is the first string");

        for (int i = 0; i < ls.getSize(); i++) {
            System.out.println(ls.get(i));
        }

        System.out.println("-----------Delete by value - 2 delete not gonna match---------------");
        LinkedListArrayOfStrings ls2 = new LinkedListArrayOfStrings();
        ls2.add("this is the only record");
        boolean isDeleted = ls2.deleteByValue("not gonna match");
        System.out.println(isDeleted);

        System.out.println("-----------Delete by value - 3 delete this is the only record ---------------");
        isDeleted = ls2.deleteByValue("this is the only record");
        System.out.println(isDeleted);

        System.out.println("-----------Delete by value - 4 delete this is the only record from an empty list---------------");
        isDeleted = ls2.deleteByValue("this is the only record");
        System.out.println(isDeleted);

        System.out.println("-----------Delete by value - 5 delete the tail:This is originally the third string --------------");

        System.out.println(ls.deleteByValue("This is originally the third string"));

        for (int i = 0; i < ls.getSize(); i++) {
            System.out.println(ls.get(i));
        }

        System.out.println("-----------toString--------------");
        System.out.println(ls.toString());

        System.out.println("-----------toArray--------------");
        String[] strArray = ls.toArray();

        for (String s : strArray) {
            System.out.println(s);
        }
        
        
        
        System.out.println("-------Generic list -1 : Car with integer-------");
        Car c1 = new Car(12345);
        Car c2 = new Car(12346);
        
        LinkedListArrayOfGeneric<Car> carList = new LinkedListArrayOfGeneric<Car>();
        carList.add(c1);
        carList.add(c2);
        System.out.println(carList.getSize());
        System.out.println(carList.get(1));
        
        
                System.out.println("-------Generic list -1 : Boat with string-------");
        Boat b1 = new Boat("Flying Dutchman");
        Boat b2 = new Boat("Black Pearl");
        
        LinkedListArrayOfGeneric<Boat> boatList = new LinkedListArrayOfGeneric<Boat>();
        boatList.add(b1);
        boatList.add(b2);
        boatList.insertValueAtIndex(1, new Boat("St Queen's Whip"));
        System.out.println(boatList.get(1));
        
    }

}
