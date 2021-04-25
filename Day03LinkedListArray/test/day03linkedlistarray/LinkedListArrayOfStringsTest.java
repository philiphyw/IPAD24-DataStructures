/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day03linkedlistarray;

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
public class LinkedListArrayOfStringsTest {

    public LinkedListArrayOfStringsTest() {
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

    /**
     * Test of add and get method, of class LinkedListArrayOfStrings.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        String value = "1st record";
        LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
        instance.add(value);
        String expResult = "1st record";
        String result = instance.get(0);
        assertEquals(expResult, result);

    }

    /**
     * Test of insertValueAtIndex method, of class LinkedListArrayOfStrings.
     */
    @Test
    public void testInsertValueAtIndex() {
        System.out.println("insertValueAtIndex");
        int index = 2;
        String value = "I am an inserted record";
        LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
        instance.add("originally 1st record");
        instance.add("originally 2nd record");
        instance.add("originally 3rd record");
        instance.add("originally 4th record");
        instance.insertValueAtIndex(index, value);
        String expResult = "I am an inserted record";
        String result = instance.get(2);
        assertEquals(expResult, result);

    }

    /**
     * Test of deleteByValue method, of class LinkedListArrayOfStrings.
     */
    @Test
    public void testDeleteByValue() {
        System.out.println("deleteByValue");
        String value = "originally 2nd record";
        LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
        instance.add("originally 1st record");
        instance.add("originally 2nd record");
        instance.add("originally 3rd record");
        instance.add("originally 4th record");
        boolean expResult = true;
        boolean result = instance.deleteByValue(value);
        assertEquals(expResult, result);

    }

    /**
     * Test of getSize method, of class LinkedListArrayOfStrings.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
                instance.add("originally 1st record");
        instance.add("originally 2nd record");
                instance.add("originally 3rd record");
        instance.add("originally 4th record");
        instance.deleteByValue("originally 3rd record");
        int expResult = 3;
        int result = instance.getSize();
        assertEquals(expResult, result);

    }

    /**
     * Test of toString method, of class LinkedListArrayOfStrings.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);

    }

    /**
     * Test of toArray method, of class LinkedListArrayOfStrings.
     */
    @Test
    public void testToArray() {
        System.out.println("toArray");
        LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
        instance.add("originally 1st record");
        instance.add("originally 2nd record");
        String[] expResult = new String[]{"originally 1st record", "originally 2nd record"};
        String[] result = instance.toArray();
        assertArrayEquals(expResult, result);

    }

}
