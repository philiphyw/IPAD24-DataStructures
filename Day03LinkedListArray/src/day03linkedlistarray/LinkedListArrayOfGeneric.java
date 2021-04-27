/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day03linkedlistarray;

import java.util.StringJoiner;

/**
 *
 * @author phili
 */
public class LinkedListArrayOfGeneric<T> {

//	
//
//
//}

    
    private class Container {

        Container next;
        T value;
    }
    private Container start, end;
    private int size;

    public void add( T value) {
        Container newContainer = new Container();
        newContainer.value = value;
//        newContainer.next = null;
        //Check if current array is empty
        if (this.size == 0) {
            this.start = newContainer;
            this.end = newContainer;
            this.size = 1;
        } else {
            this.end.next = newContainer;
            this.end = newContainer;
            this.size++;
        }
    }

    public T get(int index) {
               if (index < this.size && index >= 0) {
            if (index==0) {
                return this.start.value;
            }
            if (index == this.size-1) {
                return this.end.value;
            }
            int curIndex = 0;
            Container curContainer = this.start;            
                while (curIndex < index) {
                    curContainer = curContainer.next;
                    curIndex++;
                }            
            return curContainer.value;

        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void insertValueAtIndex(int index,T value) {
        if (index < this.size || index >= 0) {
            if (index == 0) {
                Container newContainer = new Container();
                newContainer.next = this.start;
                newContainer.value = value;
                this.start = newContainer;
            } else {
                Container curContainer = this.start;
                int curIndex = 0;
                //location the Container before inserted index
                while (curIndex < index - 1) {
                    curContainer = curContainer.next;
                    curIndex++;
                }
                //after the while loop. curContainer = this.get(index-1);
                Container newContainer = new Container();
                newContainer.next = curContainer.next;// point new container.next to this.get(index)
                newContainer.value = value;
                curContainer.next = newContainer;//point this.get(index-1).next to new container
            }
            this.size++;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean deleteByValue(T value) {// delete first value found
        //this.size ==0;
        if (this.size == 0) {
            return false;
        }
        //this.size == 1 and match the delete condition;
        if (this.size == 1 && this.start.value.equals(value)) {
            this.size = 0;
            this.start = null;
            return true;
        }
        //this.size >1, find which container.next's value == value;
        if (this.size > 1) {
            Container curContainer = this.start;
            for (int i = 0; i < this.size - 1; i++) {
                if (curContainer.next.value.equals(value)) {
                    curContainer.next = curContainer.next.next;
                    //check if the deleted item is the end
                    if (curContainer.next == null) {
                        this.end = curContainer;
                    }
                    this.size--;
                    return true;
                }
            }
        }

        return false;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {  // comma-separated values list similar to: [5,8,11]
        if (this.size == 0) {
            return "";
        } else if (this.size == 1) {
            return this.start.value.toString();
        } else {
            StringJoiner sj = new StringJoiner(",");
            Container curContainer = this.start;
            for (int i = 0; i < this.size; i++) {
                sj.add(curContainer.value.toString());
                curContainer = curContainer.next;
            }
            return sj.toString();
        }
    }



}
