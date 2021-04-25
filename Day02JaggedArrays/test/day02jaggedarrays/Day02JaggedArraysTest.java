/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day02jaggedarrays;

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
public class Day02JaggedArraysTest {
    
    public Day02JaggedArraysTest() {
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
     * Test of maxColumnCount method, of class Day02JaggedArrays.
     */
    @Test
    public void testMaxColumnCount() {
        System.out.println("maxColumnCount");
        int[][] arr = new int[][]{
            {0,1},
            {0,1,2,3,4},
                {0,1,2}
                };
        int expResult = 5;
        int result = Day02JaggedArrays.maxColumnCount(arr);
        assertEquals(expResult, result);
//        fail("testMaxColumnCount failed");
    }

//    /**
//     * Test of getIfExists method, of class Day02JaggedArrays.
//     */
    @Test
    public void testGetIfExists() {
        System.out.println("getIfExists");
        int[][] arr = new int[][]{
            {0,1},
            {0,1,2,3,4},
                {0,1,2}
                };
        int row = 1;
        int col = 3;
        int expResult =3;
        int result = Day02JaggedArrays.getIfExists(arr, row, col);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
//
//    /**
//     * Test of sumOfCross method, of class Day02JaggedArrays.
//     */
//    @Test
//    public void testSumOfCross() {
//        System.out.println("sumOfCross");
//        int[][] arr = null;
//        int row = 0;
//        int col = 0;
//        int expResult = 0;
//        int result = Day02JaggedArrays.sumOfCross(arr, row, col);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of colCountByRow method, of class Day02JaggedArrays.
//     */
    @Test
    public void testColCountByRow() {
        System.out.println("colCountByRow");
         int[][] arr = new int[][]{
            {0,1},
            {0,1,2,3,4},
                {0,1,2}
                };
        int[] expResult = new int[]{2,5,3};
        int[] result = Day02JaggedArrays.colCountByRow(arr);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
//
//    /**
//     * Test of main method, of class Day02JaggedArrays.
//     */
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        Day02JaggedArrays.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
