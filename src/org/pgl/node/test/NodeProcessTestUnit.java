package org.pgl.node.test;

import java.util.Random;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.pgl.node.Node;
import org.pgl.node.NodeImpl;
import org.pgl.node.NodeProcess;
import org.pgl.node.NodeProcessImpl;

public class NodeProcessTestUnit {

    private static Node nodeRoot;
    private static int[] arrayValues;
    
    /**
     * Prepare the resources needed and used in all tests.
     * */
    @BeforeClass
    public static void prepareTests(){
        createTree();
    }
    
    /**
     * Create a tree with 50 random values, and store this values in a separated array, to use in different tests.
     * */
    public static void createTree(){
        System.out.println("createRandomTree");
        
        Random random = new Random ();
        int rootValue = random.nextInt(100);
        nodeRoot = new NodeImpl(rootValue);
        arrayValues = new int[50];
        
        for(int i = 0; i<50;i++){
            int val = random.nextInt(100);
            arrayValues[i] = val;

            Node newNode = new NodeImpl(val);
            nodeRoot.addChild(newNode);
        }
    }
    
    /**
     * Check findMax return really the max value of tree.
     * */
    @Test
    public void testFindMax(){
        NodeProcess nodeProcess = new NodeProcessImpl();
        
        int expectedMaxValue = getMaxValueArray(arrayValues);
        
        int maxValue = nodeProcess.findMax(nodeRoot);
        
        Assert.assertTrue("The max value is incorrect", maxValue == expectedMaxValue);
    }
    
    @Test
    public void testRemoveNode(){
        NodeProcess nodeProcess = new NodeProcessImpl();

        int firstValue = arrayValues[0];
        int anyValue = arrayValues[arrayValues.length/2];
        int lastValue = arrayValues[arrayValues.length-1];

        nodeProcess.removeNodeByValue(nodeRoot, firstValue);
        //TODO to finish
    }
    
    
    /**
     * Provides the max value in a defined array.
     * */
    private int getMaxValueArray(int[] array){
        int result = Integer.MIN_VALUE;
        
        for (int i : array) {
            if(i> result){
                result = i;
            }
        }
        
        return result;
    }
}
