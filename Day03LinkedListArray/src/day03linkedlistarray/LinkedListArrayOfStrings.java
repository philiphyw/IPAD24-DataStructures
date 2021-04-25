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
public class LinkedListArrayOfStrings {

//	
//
//
//}
    private class Container {

        Container next;
        String value;
    }
    private Container start, end;
    private int size;

    public void add(String value) {
        Container newContainer = new Container();
        newContainer.value = value;
        newContainer.next = null;
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

    public String get(int index) {
        if (index < this.size || index >= 0) {
            int curIndex = 0;
            Container curContainer = this.start;
            if (index > 0) {
                while (curIndex < index) {
                    curContainer = curContainer.next;
                    curIndex++;
                }
            }
            return curContainer.value;

        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void insertValueAtIndex(int index, String value) {
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

    public boolean deleteByValue(String value) {// delete first value found
        if (this.size == 0) {
            return false;
        } else if (this.size == 1) {
            if (this.start.value.equals(value)) {
                this.start = null;
                this.end = null;
                this.size = 0;
                return true;
            }
            return false;
        } else if (this.size > 1) {
            int curIndex = 0;
            Container curContainer = this.start;
            for (int i = 0; i < this.size; i++) {
                if (curContainer.next.value.equals(value)) {
                    if (curContainer.next.next != null) { // the to-be-deleted container is NOT the tail
                        curContainer.next = curContainer.next.next; //point to-be-deleted container.prev.next to   to-be-deleted container.next
                    } else {
                        curContainer.next = null;// the to-be-deleted container is  the tail
                        this.end = curContainer;
                    }
                    this.size--;
                    return true;

                }
                curContainer = curContainer.next;
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
            return this.start.value;
        } else {
            StringJoiner sj = new StringJoiner(",");
            Container curContainer = this.start;
            for (int i = 0; i < this.size; i++) {
                sj.add(curContainer.value);
                curContainer = curContainer.next;
            }
            return sj.toString();
        }
    }

    public String[] toArray() { // could be used for Unit testing
        if (this.size == 0) {
            return null;
        } else {
            String[] strArray = new String[this.size];

            Container curContainer = this.start;
            for (int i = 0; i < this.size; i++) {
                strArray[i] = curContainer.value;
                curContainer = curContainer.next;
            }
            return strArray;
        }
    }

}
