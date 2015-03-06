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
    
    private NodeProcess<Integer, Integer> nodeProcess;

    private Node<Integer, Integer> nodeRoot;
    private int[] arrayValues;

    private int firstValue;
    private int anyValue;
    private int lastValue;
    
    @Before
    public void prepareAnyTest(){
        this.nodeProcess = new NodeProcessImpl<Integer, Integer>();
        
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
        this.nodeRoot = new NodeImpl<Integer, Integer>(rootValue);
        this.arrayValues = new int[50];
        
        for(int i = 0; i<50;i++){
            int val = random.nextInt(100);
            this.arrayValues[i] = val;

            Node<Integer, Integer> newNode = new NodeImpl<Integer, Integer>(val);
            this.nodeRoot.addChild(newNode);
        }
    }
    
    /**
//     * Check findMax return really the max value of tree.
//     * */
//    @Test
//    public void testFindMax(){        
//        int expectedMaxValue = getMaxValueArray(this.arrayValues);
//        
//        int maxValue = this.nodeProcess.findMax(this.nodeRoot);
//        
//        Assert.assertTrue("The max value is incorrect", maxValue == expectedMaxValue);
//    }
    
    
    @Test
    public void testAddNode(){
        //TODO
    }
    
    @Test
    public void testUpdateNode(){
        //TODO
    }
    
    /**
     * Get different values located at several place in tree.
     * */
    @Test
    public void testGetNode(){
        Node<Integer, Integer> nodeFirst = this.nodeProcess.getNodeByKey(this.nodeRoot, this.firstValue);
        Node<Integer, Integer> nodeAny = this.nodeProcess.getNodeByKey(this.nodeRoot, this.anyValue);
        Node<Integer, Integer> nodeLast = this.nodeProcess.getNodeByKey(this.nodeRoot, this.lastValue);
        
        Assert.assertTrue("The node ["+this.firstValue+"] has not been found", nodeFirst != null && nodeFirst.getKey() == this.firstValue); 
        Assert.assertTrue("The node ["+this.anyValue+"] has not been found", nodeAny != null && nodeAny.getKey() == this.anyValue); 
        Assert.assertTrue("The node ["+this.lastValue+"] has not been found", nodeLast != null && nodeLast.getKey() == this.lastValue);
    }
    
    /**
     * Removes different values in a tree. An try to get the matching nodes to assure that they are removed.
     * */
    @Test
    public void testRemoveGetNode(){

        boolean firstIsRemoved = this.nodeProcess.removeNodeByKey(this.nodeRoot, this.firstValue);
        boolean anyIsRemoved = this.nodeProcess.removeNodeByKey(this.nodeRoot, this.anyValue);
        boolean lastIsRemoved = this.nodeProcess.removeNodeByKey(this.nodeRoot, this.lastValue);
        
        //If the nodes has been removed the return value is true
        Assert.assertTrue("The first node ["+this.firstValue+"] has not been removed", firstIsRemoved); 
        Assert.assertTrue("The any node ["+this.anyValue+"] has not been removed", anyIsRemoved); 
        Assert.assertTrue("The last node ["+this.lastValue+"] has not been removed", lastIsRemoved); 
        
        //If a nodes has been removed no node returned, then the value is null.
        Node<Integer, Integer> nodeFirst = this.nodeProcess.getNodeByKey(this.nodeRoot, this.firstValue);
        Node<Integer, Integer> nodeAny = this.nodeProcess.getNodeByKey(this.nodeRoot, this.anyValue);
        Node<Integer, Integer> nodeLast = this.nodeProcess.getNodeByKey(this.nodeRoot, this.lastValue);
        
        Assert.assertTrue("The first node ["+this.firstValue+"] exists again", nodeFirst == null); 
        Assert.assertTrue("The any node ["+this.anyValue+"] exists again", nodeAny == null); 
        Assert.assertTrue("The last node ["+this.lastValue+"] exists again", nodeLast == null); 
    }
    
    
//    /**
//     * Provides the max value in a defined array.
//     * */
//    private int getMaxValueArray(int[] array){
//        int result = Integer.MIN_VALUE;
//        
//        for (int i : array) {
//            if(i> result){
//                result = i;
//            }
//        }
//        
//        return result;
//    }
}
