/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day02arraylistownimpl;

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
public class OwnArrayListTest {

    public OwnArrayListTest() {
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
     * Test of size method, of class OwnArrayList.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        OwnArrayList instance = new OwnArrayList();
        instance.add(1);
        instance.add(2);
        int expResult = 2;
        int result = instance.size();
        assertEquals(expResult, result);

    }

    /**
     * Test of add method, of class OwnArrayList.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int value = 99;
        OwnArrayList instance = new OwnArrayList();
        instance.add(value);
        int expResult = 99;
        int result = instance.get(0);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteByIndex method, of class OwnArrayList.
     */
    @Test
    public void testDeleteByIndex() {
        System.out.println("deleteByIndex");
        int index = 0;
        OwnArrayList instance = new OwnArrayList();
        instance.add(99);
        instance.add(98);
        instance.deleteByIndex(index);
        int expSize = 1;
        int size = instance.size();
        assertEquals(expSize, size);
        int expResult = 98;
        int result = instance.get(0);
        assertEquals(expResult, result);

    }

    /**
     * Test of deleteByValue method, of class OwnArrayList.
     */
    @Test
    public void testDeleteByValue() {
        System.out.println("deleteByValue");
        int value = 0;
        OwnArrayList instance = new OwnArrayList();
        instance.add(99);
         instance.add(value);
        instance.add(98);
        boolean expResult = true;
        boolean result = instance.deleteByValue(value);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of insertValueAtIndex method, of class OwnArrayList.
     */
    @Test
    public void testInsertValueAtIndex() {
        System.out.println("insertValueAtIndex");
        int value = 0;
        int index = 1;
        OwnArrayList instance = new OwnArrayList();
        instance.add(99);
        instance.add(98);
        instance.insertValueAtIndex(value, index);
        int expResult = 0;
        int result = instance.get(1);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of clear method, of class OwnArrayList.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        OwnArrayList instance = new OwnArrayList();
        instance.clear();
       int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
    }

//    /**
//     * Test of get method, of class OwnArrayList.
//     */
//    @Test
//    public void testGet() {
//        System.out.println("get");
//        int index = 0;
//        OwnArrayList instance = new OwnArrayList();
//        int expResult = 0;
//        int result = instance.get(index);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getSlice method, of class OwnArrayList.
//     */
//    @Test
//    public void testGetSlice() {
//        System.out.println("getSlice");
//        int startIdx = 0;
//        int length = 0;
//        OwnArrayList instance = new OwnArrayList();
//        int[] expResult = null;
//        int[] result = instance.getSlice(startIdx, length);
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of toString method, of class OwnArrayList.
//     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        OwnArrayList instance = new OwnArrayList();
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

}
