/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaltreepatterns;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author phili
 */
 class TreeStringIntSetIterator implements Iterator<Pair<String, Integer>> {
    private List<Pair<String, Integer>> valuesInOrder;
    private int currIndex;
    
     public TreeStringIntSetIterator(List<Pair<String, Integer>>valuesInOrder) {
            this.valuesInOrder = valuesInOrder;
        }
        
        @Override
        public boolean hasNext() {
            return currIndex < valuesInOrder.size();
        }

        @Override
        public Pair<String, Integer> next() {
            return valuesInOrder.get(currIndex++);
        }
    
}
