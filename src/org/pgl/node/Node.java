package org.pgl.node;
/**
 * This interface represents a Node.
 * */
public interface Node {
    
    int getValue();
    
    Node getRightChild();
    
    Node getLeftChild();
    
    void addChild(Node node);
}
