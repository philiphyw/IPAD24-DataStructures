package finaltreepatterns;

import java.util.Iterator;
import java.util.List;

public class FinalTreePatterns {

    public static void main(String[] args) {

        TreeStringIntSet ts = new TreeStringIntSet();

        //test add()
        try {
            ts.add("Bruce", 20);
            ts.add("Bruce", 10);
            ts.add("Bruce", 30);
            ts.add("Harlan", 20);
            ts.add("Harlan", 30);
            ts.add("Aiwa", 30);
            ts.add("Aiwa", 10);
            ts.add("Zoe", 30);
            ts.add("Zoe", 40);
            ts.add("Wendy", 20);
            ts.add("Wendy", 10);
            ts.add("John", 20);

            ts.add("Bruce", 10);//DuplicateValueException
        } catch (DuplicateValueException e) {
            System.out.println(e.getMessage());
        }

        //test containsKey()
        System.out.println("Contains the key \"Sam\"? " + ts.containsKey("Sam"));
        System.out.println("Contains the key \"Harlan\"? " + ts.containsKey("Harlan"));

        //test getValuesOfKey()
        System.out.println("\nValues in the key Bruce:");
        List<Integer> valueList = ts.getValuesOfKey("Bruce");
        valueList.forEach(r -> {
            System.out.print(r + " ");
        });

        System.out.println("\nValues in the key Jimmy:");

        valueList = ts.getValuesOfKey("Jimmy");
        valueList.forEach(r -> {
            System.out.print(r + " ");
        });

        //test getKeysContainingValue()
        List<String> keyList = ts.getKeysContainingValue(30);
        System.out.println("\nKeys contains the value 30:");
        keyList.forEach(r -> {
            System.out.print(r + " ");
        });

        //test geAllKeys() 
        keyList = ts.getAllKeys();
        System.out.println("\nGet all keys:");
        keyList.forEach(r -> {
            System.out.print(r + " ");
        });
        System.out.println("");

//         //test Iterator
        for (Pair<String,Integer> val : ts) {
            System.out.println("Using iterator: " + val);
        }

    }

}
