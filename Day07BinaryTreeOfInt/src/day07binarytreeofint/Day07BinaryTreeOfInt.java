/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day07binarytreeofint;

import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author phili
 */
public class Day07BinaryTreeOfInt {

    public static void main(String[] args) {
        BinaryTreeOfInt bt = new BinaryTreeOfInt();

//        NodeOfInt n0 = new NodeOfInt(20);
//        NodeOfInt n1 = new NodeOfInt(13);
//        NodeOfInt n2 = new NodeOfInt(23);
//        NodeOfInt n3 = new NodeOfInt(8);
//        NodeOfInt n4 = new NodeOfInt(15);
//        NodeOfInt n5 = new NodeOfInt(21);
//        NodeOfInt n6 = new NodeOfInt(29);
//        NodeOfInt n7 = new NodeOfInt(4);
//        n0.left = n1;
//        n0.right = n2;
//        n1.left = n3;
//        n1.right = n4;
//        n2.left = n5;
//        n2.right = n6;
//        n3.left = n7;
//        bt.setRoot(n0);
        bt.put(20);
        bt.put(13);
        bt.put(23);
        bt.put(8);
        bt.put(15);
        bt.put(21);
        bt.put(29);
        bt.put(4);

        System.out.println("Sum of root and its direct children :" + bt.getSumOfAllValues(bt.getRoot()));
        System.out.println("Sum of root and its direct children :" + bt.getSumOfThisAndSubNodes(bt.getRoot()));
        System.out.println("NodeCount of the binary tree:" + bt.getNodesCount());

        System.out.println("try to put not duplicate value to the binary tree:");
        try {
            bt.put(99);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("NodeCount of the binary tree:" + bt.getNodesCount());

        System.out.println("try to put duplicate value to the binary tree:");
        try {
            bt.put(99);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("NodeCount of the binary tree:" + bt.getNodesCount());

        System.out.println(bt.getRoot().left.left.value);
        System.out.println(bt.getRoot().left.left.left.value);
        System.out.println("Get all values in an array from largest to smallest");

        int[] valueArr = bt.getValuesInOrder();
        for (int i = 0; i < valueArr.length; i++) {
            System.out.print(valueArr[i] + " ");
        }
        System.out.println("");

        System.out.println("Use for(Integer i:bt) to loop through integer value in nodes of the binary tree");
        for (Integer i : bt) {
            System.out.print(i + " ");
        }
        System.out.println("");
        
          System.out.println("Use integer i.hasNext() to find the last integer value in nodes of the binary tree");
       Iterator<Integer> iterator = bt.iterator();
       int lastValue=0;
       while(iterator.hasNext()){
           lastValue = iterator.next();
       }
        System.out.println("The last value in the interator is " + lastValue);
    }

}
