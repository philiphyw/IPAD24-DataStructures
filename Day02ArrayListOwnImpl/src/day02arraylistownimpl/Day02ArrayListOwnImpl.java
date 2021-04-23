/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day02arraylistownimpl;

/**
 *
 * @author phili
 */
public class Day02ArrayListOwnImpl {

    public static void main(String[] args) {
        OwnArrayList list = new OwnArrayList();

        System.out.printf("Current size:%d\n", list.size());

        list.add(10);
        list.add(9);
        list.add(8);
        list.add(7);
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        System.out.printf("Current size:%d\n", list.size());
        list.insertValueAtIndex(2, 1);
        System.out.printf("Current size:%d\n", list.size());
        System.out.println(list);
        list.deleteByIndex(1);
        System.out.println(list);
        System.out.println(list.deleteByValue(1));
        System.out.println(list.deleteByValue(9));
        System.out.println(list);
        System.out.println(list.get(2));
        int []slicedData = list.getSlice(2, 4);
       
        for(int num : slicedData){
            System.out.print(num + " ");
        }
        System.out.println();
        list.clear();
        System.out.printf("Current size:%d\n", list.size());
        System.out.println(list);
    }

}
