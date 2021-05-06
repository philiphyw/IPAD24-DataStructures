/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day07binarytreeofint;

/**
 *
 * @author phili
 */
public class NodeOfInt {

    int key;
    int value;
    NodeOfInt left, right;

    public NodeOfInt(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getChildrenCount() {
        int result = 0;
        if (this == null) {
            return result;
        }
        if (this.right != null) {
            result += this.right.getChildrenCount();
        }
        if (this.left != null) {
            result += this.left.getChildrenCount();
        }
        result += 1;
        return result;
    }

    public int getChildrenValues() {
        int valueSum = 0;
        if (this.left != null) {
            valueSum += this.left.value;
        }
        if (this.right != null) {
            valueSum += this.right.value;
        }

        return valueSum;
    }

    public int getAllChildrenValues() {
        int valueSum = 0;
        if (this.left != null) {
            valueSum += this.left.getChildrenValues();
            valueSum += this.left.value;
        }
        if (this.right != null) {
            valueSum += this.right.getChildrenValues();
            valueSum += this.right.value;
        }

        return valueSum;
    }

    public boolean isExisted(int value) {
        boolean result = false;
        if (value == this.value) {
            return true;
        }

        if (this.left != null) {
            result = this.left.isExisted(value);
            if (result == true) {
                return result;
            }
        }
        if (this.right != null) {
            result = this.right.isExisted(value);
            if (result == true) {
                return result;
            }
        }

        return result;
    }

    public void put(int key, int value) {
        if (this.value == value) {
            throw new IllegalArgumentException("Value already exists");
        }
        if (this.value < value) {
            if (this.right == null) {
                this.right = new NodeOfInt(key, value);                
            } else {
                this.right.put(key, value);
            }
        } else {
            if (this.left == null) {
                this.left = new NodeOfInt(key, value);
            } else {
                this.left.put(key, value);
            }
        }
    }

    public int[] getValueArray() {
        int[] resultArr = new int[this.getChildrenCount()];
        int curIndex=0;
        if (this.right != null) {
            int[] tempArr = this.right.getValueArray();
            for (int i = 0; i < tempArr.length; i++) {
                resultArr[i] = tempArr[i];
                curIndex++;
            }
        }
        resultArr[curIndex]=this.value;
        curIndex++;
        if (this.left != null) {
            int[] tempArr = this.left.getValueArray();
            for (int i = 0; i < tempArr.length; i++) {
                resultArr[curIndex+i] = tempArr[i];
            }
        }

        return resultArr;
    }

}
