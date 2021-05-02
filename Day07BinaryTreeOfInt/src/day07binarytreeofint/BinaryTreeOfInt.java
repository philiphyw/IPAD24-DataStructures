/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day07binarytreeofint;

//
//	
//	// uses recursion to collect all values from largest to smallest
//	int [] getValuesInOrder() { // from largest to smallest
//        resultArray = new int[nodesCount];
//		...
//	}
//	
//	// private helper recursive method to implement the above method
//	private void collectValuesInOrder(NodeOfInt node) {
//    }
//	// data structures used to make collecting values in order easier
//    private int[] resultArray;
//    private int resultIndex;
/**
 *
 * @author phili
 */
public class BinaryTreeOfInt {

    private NodeOfInt root;
    private int nodesCount;

    public NodeOfInt getRoot() {
        return root;
    }

    public void setRoot(NodeOfInt root) {
        this.root = root;
    }

    public int getNodesCount() {
        return nodesCount;
    }

    public void setNodesCount(int nodesCount) {
        this.nodesCount = nodesCount;
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

        if (this.root != null) {
            this.root.put(value);
        } else {
            this.root = new NodeOfInt(value);
        }
        this.nodesCount += 1;
    }

    // uses recursion to collect all values from largest to smallest
    public int[] getValuesInOrder() { // from largest to smallest
        if (this.nodesCount == 0) {
            return null;
        }
        return this.root.getValueArray();
            }
}
