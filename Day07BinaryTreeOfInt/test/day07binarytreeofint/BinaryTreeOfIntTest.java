/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day07binarytreeofint;

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
public class BinaryTreeOfIntTest {

    public BinaryTreeOfIntTest() {
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
     * Test of getRoot method, of class BinaryTreeOfInt.
     */
    @Test
    public void testGetRoot() {
        System.out.println("getRoot");
        BinaryTreeOfInt instance = new BinaryTreeOfInt();

        NodeOfInt expResult = new NodeOfInt(30);
        instance.setRoot(expResult);
        NodeOfInt result = instance.getRoot();
        assertEquals(expResult, result);

    }

    /**
     * Test of setRoot method, of class BinaryTreeOfInt.
     */
    @Test
    public void testSetRoot() {
        System.out.println("setRoot");
        NodeOfInt root = new NodeOfInt(30);
        BinaryTreeOfInt instance = new BinaryTreeOfInt();
        instance.setRoot(root);
        int expResult = instance.getRoot().value;
        int result = 30;
        assertEquals(expResult, result);
    }

    /**
     * Test of getNodesCount method, of class BinaryTreeOfInt.
     */
    @Test
    public void testGetNodesCount() {
        System.out.println("getNodesCount");
        BinaryTreeOfInt instance = new BinaryTreeOfInt();
        instance.put(30);
        instance.put(14);
        instance.put(15);
        instance.put(4);
        instance.put(35);
        instance.put(34);
        instance.put(40);

        int expResult = 7;
        int result = instance.getNodesCount();
        assertEquals(expResult, result);

    }

    /**
     * Test of setNodesCount method, of class BinaryTreeOfInt.
     */
    /**
     * Test of getSumOfAllValues method, of class BinaryTreeOfInt.
     */
    @Test
    public void testGetSumOfAllValues() {
        System.out.println("getSumOfAllValues");
        BinaryTreeOfInt instance = new BinaryTreeOfInt();
        instance.put(14);
        instance.put(15);
        instance.put(5);
        instance.put(4);//this one shouldn't be calcuated since it's not root's direct children(left or right)
        instance.put(7);//this one shouldn't be calcuated since it's not root's direct children(left or right)
        int expResult = 34;
        int result = instance.getSumOfAllValues(instance.getRoot());
        assertEquals(expResult, result);

    }

    /**
     * Test of getSumOfThisAndSubNodes method, of class BinaryTreeOfInt.
     */
    @Test
    public void testGetSumOfThisAndSubNodes() {
        System.out.println("getSumOfThisAndSubNodes");
        BinaryTreeOfInt instance = new BinaryTreeOfInt();
        instance.put(14);
        instance.put(15);
        instance.put(5);
        instance.put(4);
        instance.put(7);
        int expResult = 45;
        int result = instance.getSumOfThisAndSubNodes(instance.getRoot());
        assertEquals(expResult, result);

    }

    /**
     * Test of put method, of class BinaryTreeOfInt.
     */
    /**
     * Test of getValuesInOrder method, of class BinaryTreeOfInt.
     */
    @Test
    public void testGetValuesInOrder() {
        System.out.println("getValuesInOrder");
        BinaryTreeOfInt instance = new BinaryTreeOfInt();
        instance.put(30);
        instance.put(14);
        instance.put(15);
        instance.put(4);
        instance.put(35);
        instance.put(34);
        instance.put(40);
        int[] expResult = new int[]{40, 35, 34, 30, 15, 14, 4};
        int[] result = instance.getValuesInOrder();
        assertArrayEquals(expResult, result);

    }

}
