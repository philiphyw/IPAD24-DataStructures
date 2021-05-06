/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day07binarytreeofint;

//

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class BinaryTreeOfInt implements Iterable<Integer> {

    private NodeOfInt root;
    private int nodesCount;
    //to implement Iterable, need to build this List and reference its iterator method
    private final List<Integer> vList = new ArrayList<Integer>();
    
    public NodeOfInt getRoot() {
        return root;
    }

    public void setRoot(NodeOfInt root) {
        this.root = root;
    }

    public int getNodesCount() {
        return nodesCount;
    }

    // uses compute the sum of all values in the entire tree using the recursive method below
    public int getSumOfAllValues(NodeOfInt node) {
        int valueSum = 0;
        if (node != null) {
            valueSum += node.getChildrenValues();
            valueSum += node.value;
        }

        return valueSum;
    }

    public int getSumOfThisAndSubNodes(NodeOfInt node) {
        int valueSum = 0;
        if (node != null) {
            valueSum += node.getAllChildrenValues();
            valueSum += node.value;
        }

        return valueSum;
    }

    // throws exception if put attempts to insert value that already exists (a duplicate)
    void put(int value) throws IllegalArgumentException {
        int key=0;
        if (this.nodesCount>0) {
            key=this.nodesCount-1;
        }
        
        if (this.root != null) {
            this.root.put(key, value);
        } else {
            this.root = new NodeOfInt(key, value);
        }
        vList.add(value);
        this.nodesCount += 1;
    }

    // uses recursion to collect all values from largest to smallest
    public int[] getValuesInOrder() { // from largest to smallest
        if (this.nodesCount == 0) {
            return null;
        }
        return this.root.getValueArray();
            }

    @Override
    public Iterator<Integer> iterator() {
        return vList.iterator();
    }

   
    
    
}
