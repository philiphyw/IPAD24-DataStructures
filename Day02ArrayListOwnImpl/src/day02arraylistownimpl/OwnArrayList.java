/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day02arraylistownimpl;

import java.util.StringJoiner;

/**
 *
 * @author phili
 */
public class OwnArrayList {

    /**
     *
     *
     *  
     * may throw IndexOutOfBoundsException public int[] getSlice(int startIdx,
     * int length) { ... } // may throw IndexOutOfBoundsException
     *
     *
     */
    // private int [] data = new int[1]; // only grows by doubling size, never shrinks 
    private int[] data = new int[1];
    private int size = 0;

    // private int size = 0; // how many items do you really have
    public int size() {
        return size;
    }

    //public void add(int value) { ... }
    public void add(int value) {
        if (size <= data.length) {
            int[] newData = new int[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
        data[size] = value;
        size++;
    }

    //public void deleteByIndex(int index) { ... } 
    public void deleteByIndex(int index) {
        //check if the index is out of bound
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }else if(index == size){
        
        }
        
        else{
            for (int i = index; i < size; i++) {
                data[i] = data[i + 1];
            }
        }
        data[size] = 0;
        size--;
    }

    // public boolean deleteByValue(int value) { ... } // delete first value matching, true if value found, false otherwise
    public boolean deleteByValue(int value) {
        for (int i = 0; i <size; i++) {
            if (data[i] == value) {
                for (int j = i; j < size; j++) {
                    data[j] = data[j + 1];
                }
                data[size] = 0;
                size--;
                return true;
            }
        }
        return false;
    }

    //public void insertValueAtIndex(int value,int * index) { ... } 
    public void insertValueAtIndex(int value, int index) {
        //check if the index is out of bound
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        } else if (index == size) {//the last element
            data[index] = value;
        } else {
            for (int i = size; i > index; i--) {
                data[i] = data[i - 1];
            }
            data[index] = value;
            size++;
        }
        
    }

    //public void clear() { size = 0;}
    public void clear() { size = 0;data=new int[1]; }
    
    
    //public int get(int index) { ... } 
    public int get(int index) {
    if (index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
         return data[index];  
        }
    } 
    
    
    //public int[] getSlice(int startIdx, int length) { ... } // may throw IndexOutOfBoundsException
    public int[] getSlice(int startIdx, int length) {
        if (startIdx>=size ||startIdx + length>=size ) {
            throw new IndexOutOfBoundsException();
        }else{
            int[]slicedData = new int[length];
            int curIndex=0;
            for (int i = startIdx; i < startIdx+length; i++) {
                slicedData[curIndex] = data[i];
                curIndex++;
            }
            return slicedData;
        }
    }
    
    
     //@Override public String toString() { ... } // returns String similar to: [3, 5, 6, -23]
    @Override
    public String toString() {    
        if (size==0) {
            return "";
        }
         StringJoiner sj = new StringJoiner(",");
        for (int i = 0; i < size; i++) {
            sj.add(String.format("%d", data[i]));
        }
        return sj.toString();
    }
}
