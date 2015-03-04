package org.pgl.node;

/**
 * @author pguilletlhomat
 * */
public interface NodeProcess {
    
    /**
     * Search and return the max value contented in the tree of node root.
     * */
    int findMax(Node root);
    
    /**
     * Provides the Node in a tree matching with value.
     * 
     * @param root The node root of tree.
     * @param value The value to find.
     * 
     * @return return the Node if exist, else return null.
     * */
    Node getNodeByValue(Node root, int value);
    
    /**
     * Removes the Node defined by value in a tree.
     * 
     * @param root The root of tree.
     * @param value The value of node to remove.    
     * 
     * @return true if the node has been found and removed, else return false.
     **/
    boolean removeNodeByValue(Node root, int value);
}
