package org.pgl.node;

/**
 * This interface represents a Node.
 * */
public interface Node<K extends Comparable<K>, E> {
    
    /**
     * Get the key of this node.
     * */
    K getKey();
    
    /**
     * Get the entity of this node.
     * */
    E getEntity();
    
    Node<K, E> getParent();
    
    void setParent(Node<K, E> parent);
    
    
    /**
     * Get the right node of this node.
     * 
     * @return The right node or null if not exist.
     * */
    Node<K, E> getRightChild();
    
    /**
     * Set and replace if exist the right node of this node.
     * 
     * @param node The node to set.
     * */
    void setRightChild(Node<K, E> node);
    
    /**
     * Get the left node of this node.
     * 
     * @return The left node or null if not exist.
     * */
    Node<K, E> getLeftChild();
    
    /**
     * Set and replace if exist the left node of this node.
     * 
     * @param node The node to set.
     * */
    void setLeftChild(Node<K, E> node);
    
    /**
     * Add and place child the defined node in this node.
     * 
     * @param node The node to add.
     * */
    void addChild(Node<K, E> node);
}
