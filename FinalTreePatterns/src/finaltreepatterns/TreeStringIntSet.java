package finaltreepatterns;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class TreeStringIntSet implements Iterable<Pair<String, Integer>> {

    private class Node {

        Node left, right;
        String key; // keys are unique
        // HashSet is like ArrayList except it does not hold duplicates
        HashSet<Integer> valuesSet = new HashSet<>(); // unique only

        public Node(String key, int value) {
            this.key = key;
            this.valuesSet.add(value);
        }
    }

    private Node root;
    private int nodesCount;
    private String[] resultKeysArray;
    private int resultKeysIndex;
    private List<Pair<String, Integer>> resultPairsList;
    private int resultPairsIndex;
    private  Pair<String, Integer>[] pairArr;
    

    // throws DuplicateValueException if this key already contains such value
    public void add(String key, int value) throws DuplicateValueException {
        if (root == null) {
            root = new Node(key, value);
            nodesCount++;
            return;
        }
        Node currNode = root;
        while (true) {
            if (currNode.key.equals(key)) { // key exists, try to add the value to the hashset
                // throws DuplicateValueException if this key already contains such value
                for (int val : currNode.valuesSet) {
                    if (val == value) {
                        throw new DuplicateValueException(String.format("Value already existed in this key: {%s : %d}", currNode.key, value));
                    }
                }
                currNode.valuesSet.add(value);
                return;
            }
            if (key.compareTo(currNode.key) < 0) {
                if (currNode.left == null) { // create a new node with the key , and add value to the valueSet
                    currNode.left = new Node(key, value);
                    nodesCount++;
                    return;
                } else {
                    currNode = currNode.left;
                }
            } else {
                if (currNode.right == null) { // create a new node with the key , and add value to the valueSet
                    currNode.right = new Node(key, value);
                    nodesCount++;
                    return;
                } else {
                    currNode = currNode.right;
                }
            }
        }
    }

    public boolean containsKey(String key) {
        Node currNode = root;
        while (true) {
            if (currNode == null) {
                return false;
            }
            if (currNode.key.equals(key)) { // key found, return true
                return true;
            }
            if (key.compareTo(currNode.key) < 0) {
                currNode = currNode.left;
            } else {
                currNode = currNode.right;
            }
        }
    }

    // return empty list if key not found
    // return values sorted
    public List<Integer> getValuesOfKey(String key) {
        Node currNode = root;
        List<Integer> resultList = new ArrayList<>();
        while (true) {
            if (currNode == null) {
                return resultList;
            }
            if (currNode.key.equals(key)) { // key found
                resultList = new ArrayList<>(currNode.valuesSet);
                if (resultList.size() > 0) {
                    resultList.sort((Integer n1, Integer n2) -> { //sort value 
                        return Integer.compare(n1, n2);
                    });
                }

                return resultList;
            }
            if (key.compareTo(currNode.key) < 0) {
                currNode = currNode.left;
            } else {
                currNode = currNode.right;
            }
        }
    }

    // use traversal of all nodes to collect keys that have this value in valuesSet
    public List<String> getKeysContainingValue(int value) {
        List<String> resultList = new ArrayList<>();
        if (this.nodesCount <= 0) {
            return resultList;
        }
        Node currNode = root;
        resultKeysArray = new String[this.nodesCount];
        resultKeysIndex = 0;
        getKeyIfItContainsValue(root, value);

        for (String s : resultKeysArray) {
            if (s != null) {// there maight be null value on the resultKeysArray
                resultList.add(s);
            }
        }
        if (resultList.size() > 0) {
            resultList.sort((String s1, String s2) -> {
                return s1.compareTo(s2);
            });
        }

        return resultList;
    }

    private void getKeyIfItContainsValue(Node currNode, Integer value) {
        if (currNode == null) {
            return;
        }
        getKeyIfItContainsValue(currNode.left, value);
        if (currNode.valuesSet.contains(value)) {
            resultKeysArray[resultKeysIndex] = currNode.key;
            resultKeysIndex++;
        }
        getKeyIfItContainsValue(currNode.right, value);
    }

    // use traversal to collect all keys
    public List<String> getAllKeys() {
        List<String> resultList = new ArrayList<>();
        resultKeysArray = new String[this.nodesCount];
        resultKeysIndex = 0;
        if (this.root == null) {
            return resultList;
        }
        collectKeysInOrder(this.root);
        for (String s : resultKeysArray) {
            if (s != null) {// there maight be null value on the resultKeysArray
                resultList.add(s);
            }
        }
        if (resultList.size() > 0) {
            resultList.sort((String s1, String s2) -> {
                return s1.compareTo(s2);
            });
        }
        return resultList;
    }

    private void collectKeysInOrder(Node currNode) {
        if (currNode == null) {
            return;
        }
        collectKeysInOrder(currNode.left);
        resultKeysArray[resultKeysIndex++] = currNode.key;
        collectKeysInOrder(currNode.right);
    }

    private void collectPairsInOrder(Node currNode) {
        if (currNode == null) {
            return;
        }
        collectPairsInOrder(currNode.left);
        for (Integer i : currNode.valuesSet) {
            Pair<String, Integer> p = new Pair<>(currNode.key, i);
            resultPairsList.add(p);
        }
        collectPairsInOrder(currNode.right);
    }

    private List<Pair<String, Integer>> getParisInOrder() {
        resultPairsList = new ArrayList<>();
        if (this.root == null) {
            Pair<String, Integer>[] pairArr = (Pair<String, Integer>[]) new Object[0];
            return resultPairsList;
        }
        collectPairsInOrder(this.root);
//        Pair<String, Integer>[] pairArr = new Pair<String, Integer>[resultPairsList.size()];
        
      
//        pairArr = (Pair<String, Integer>[]) Array.newInstance(new Pair<String,Integer>().getClass(), nodesCount);

        //sort the resultPairsList
        resultPairsList.sort((Pair<String, Integer> p1, Pair<String, Integer> p2) -> {
            if (p1.key.compareTo(p2.key) != 0) {
                return p1.key.compareTo(p2.key);
            } else {
                return Integer.compare(p1.value, p2.value);
            }

        });


        return resultPairsList;
    }

    @Override
    public Iterator<Pair<String, Integer>> iterator() {
        return new TreeStringIntSetIterator(getParisInOrder());
    }
}

class Pair<K, V> {

    K key;
    V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("(%s=>%s)", key.toString(), value.toString());
    }
}
