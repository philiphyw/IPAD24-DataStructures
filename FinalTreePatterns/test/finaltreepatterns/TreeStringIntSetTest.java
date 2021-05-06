/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaltreepatterns;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author phili
 */
public class TreeStringIntSetTest {

    public TreeStringIntSetTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAddAndContainsKey() {
        System.out.println("test Add() and ContainsKey()");
        TreeStringIntSet instance = new TreeStringIntSet();
        try {
            instance.add("Jim", 1);
            instance.add("Sam", 2);
            instance.add("Tom", 3);
            instance.add("Tom", 4);
            instance.add("Tom", 4);
        } catch (Exception e) {
            String expErrorMessage = String.format("Value already existed in this key: {%s : %d}", "Tom", 4);
            String errormessage = e.getMessage();
            assertEquals(expErrorMessage, errormessage);
        }
        boolean expResultTrue = true;
        boolean expResultFalse = false;
        assertEquals(expResultTrue, instance.containsKey("Sam"));
        assertEquals(expResultFalse, instance.containsKey("Dark Vetar"));

    }

    @Test
    public void testGetValuesOfKey() {
        System.out.println("test Add() and getValuesOfKey()");
        TreeStringIntSet instance = new TreeStringIntSet();
        try {
            instance.add("Jim", 1);
            instance.add("Sam", 2);
            instance.add("Tom", 3);
            instance.add("Tom", 4);
            instance.add("Tom", 5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Integer expResult0 = 3;
        Integer expResult1 = 4;
        Integer expResult2 = 5;
        List<Integer> resultList = instance.getValuesOfKey("Tom");
        assertEquals(resultList.get(0), expResult0);
        assertEquals(resultList.get(1), expResult1);
        assertEquals(resultList.get(2), expResult2);
    }

    @Test
    public void testGetKeyContainingValue() {
        System.out.println("test Add() and getKeyContainingValue()");
        TreeStringIntSet instance = new TreeStringIntSet();
        try {
            instance.add("Jim", 1);
            instance.add("Sam", 2);
            instance.add("Tom", 3);
            instance.add("Tom", 2);
            instance.add("Tom", 5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String expResult0 = "Sam";
        String expResult1 = "Tom";
        List<String> resultList = instance.getKeysContainingValue(2);
        assertEquals(resultList.get(0), "Sam");
        assertEquals(resultList.get(1), "Tom");
    }
    
    @Test
public void testGetAllKeys() {
        System.out.println("test Add() and getAllKeys()");
        TreeStringIntSet instance = new TreeStringIntSet();
        try {
            instance.add("Jim", 1);
            instance.add("Sam", 2);
            instance.add("Tom", 3);
            instance.add("Tom", 2);
            instance.add("Tom", 5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String expResult0 = "Jim";
        String expResult1 = "Sam";
        String expResult2 = "Tom";
        List<String> resultList = instance.getAllKeys();
        assertEquals(resultList.get(0), "Jim");
        assertEquals(resultList.get(1), "Sam");
         assertEquals(resultList.get(2), "Tom");
    }
    

   @Test
public void testInterator() {
        System.out.println("test Add() and getAllKeys()");
        TreeStringIntSet instance = new TreeStringIntSet();
        try {
            instance.add("Jim", 1);
            instance.add("Sam", 2);
            instance.add("Tom", 3);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        List<String> resultList=new ArrayList<>();
        for (Pair<String,Integer> val : instance) {
            resultList.add(val.toString());
        }
      
        assertEquals(resultList.get(0), "(Jim=>1)");
        assertEquals(resultList.get(1), "(Sam=>2)");
         assertEquals(resultList.get(2), "(Tom=>3)");
    }
}
