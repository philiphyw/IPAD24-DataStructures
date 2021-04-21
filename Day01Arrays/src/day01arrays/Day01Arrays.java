/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day01arrays;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 *
 * @author phili
 */
public class Day01Arrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int arrSize=0;
        while (true) {
            try {
                System.out.print("Pls enter the size of the array: ");
                arrSize = sc.nextInt();
                sc.nextLine();
                if (arrSize>=1) {
                    break;
                }else
                {System.out.println("Number must be 1 or greater");}
                
            } catch (InputMismatchException ex) {
                System.out.println("Invalid number");   
                sc.nextLine();
                continue;
            }
        }
        
        StringJoiner sj = new StringJoiner(",");
        int[] intArr = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            intArr[i] = 1+ (int)(100* Math.random());
            sj.add( String.valueOf(intArr[i]));
        }
        System.out.println(sj);
    }

}
