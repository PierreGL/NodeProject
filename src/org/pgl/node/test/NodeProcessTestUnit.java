package org.pgl.node.test;

import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.pgl.node.Node;
import org.pgl.node.NodeImpl;
import org.pgl.node.NodeProcess;
import org.pgl.node.NodeProcessImpl;

public class NodeProcessTestUnit {
    
    private NodeProcess nodeProcess;

    private Node nodeRoot;
    private int[] arrayValues;

    private int firstValue;
    private int anyValue;
    private int lastValue;
    
    @Before
    public void prepareAnyTest(){
        this.nodeProcess = new NodeProcessImpl();
        
        createTree();
        
        this.firstValue = this.arrayValues[0];
        this.anyValue = this.arrayValues[this.arrayValues.length/2];
        this.lastValue = this.arrayValues[this.arrayValues.length-1];
    }
    
    /**
     * Create a tree with 50 random values, and store this values in a separated array, to use in different tests.
     * */
    public void createTree(){        
        Random random = new Random ();
        int rootValue = random.nextInt(100);
        this.nodeRoot = new NodeImpl(rootValue);
        this.arrayValues = new int[50];
        
        for(int i = 0; i<50;i++){
            int val = random.nextInt(100);
            this.arrayValues[i] = val;

            Node newNode = new NodeImpl(val);
            this.nodeRoot.addChild(newNode);
        }
    }
    
    /**
     * Check findMax return really the max value of tree.
     * */
    @Test
    public void testFindMax(){        
        int expectedMaxValue = getMaxValueArray(this.arrayValues);
        
        int maxValue = this.nodeProcess.findMax(this.nodeRoot);
        
        Assert.assertTrue("The max value is incorrect", maxValue == expectedMaxValue);
    }
    
    /**
     * Get different values located at several place in tree.
     * */
    @Test
    public void testGetNode(){
        Node nodeFirst = this.nodeProcess.getNodeByValue(this.nodeRoot, this.firstValue);
        Node nodeAny = this.nodeProcess.getNodeByValue(this.nodeRoot, this.anyValue);
        Node nodeLast = this.nodeProcess.getNodeByValue(this.nodeRoot, this.lastValue);
        
        Assert.assertTrue("The node ["+this.firstValue+"] has not been found", nodeFirst != null && nodeFirst.getValue() == this.firstValue); 
        Assert.assertTrue("The node ["+this.anyValue+"] has not been found", nodeAny != null && nodeAny.getValue() == this.anyValue); 
        Assert.assertTrue("The node ["+this.lastValue+"] has not been found", nodeLast != null && nodeLast.getValue() == this.lastValue);
    }
    
    /**
     * Removes different values in a tree. An try to get the matching nodes to assure that they are removed.
     * */
    @Test
    public void testRemoveGetNode(){

        boolean firstIsRemoved = this.nodeProcess.removeNodeByValue(this.nodeRoot, this.firstValue);
        boolean anyIsRemoved = this.nodeProcess.removeNodeByValue(this.nodeRoot, this.anyValue);
        boolean lastIsRemoved = this.nodeProcess.removeNodeByValue(this.nodeRoot, this.lastValue);
        
        //If the nodes has been removed the return value is true
        Assert.assertTrue("The first node ["+this.firstValue+"] has not been removed", firstIsRemoved); 
        Assert.assertTrue("The any node ["+this.anyValue+"] has not been removed", anyIsRemoved); 
        Assert.assertTrue("The last node ["+this.lastValue+"] has not been removed", lastIsRemoved); 
        
        //If a nodes has been removed no node returned, then the value is null.
        Node nodeFirst = this.nodeProcess.getNodeByValue(this.nodeRoot, this.firstValue);
        Node nodeAny = this.nodeProcess.getNodeByValue(this.nodeRoot, this.anyValue);
        Node nodeLast = this.nodeProcess.getNodeByValue(this.nodeRoot, this.lastValue);
        
        Assert.assertTrue("The first node ["+this.firstValue+"] exists again", nodeFirst == null); 
        Assert.assertTrue("The any node ["+this.anyValue+"] exists again", nodeAny == null); 
        Assert.assertTrue("The last node ["+this.lastValue+"] exists again", nodeLast == null); 
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
