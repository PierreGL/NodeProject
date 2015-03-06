package org.pgl.node;

/**
 * Defined process could be able on tree node.
 * */
public interface NodeProcess<K extends Comparable<K>, E> {
    
    //TODO
//    /**
//     * Search and return the entity with max value contented in the tree of node root.
//     * */
//    E findMax(Node<K, E> root);
    
    /**
     * Provides the Node in a tree matching with key.
     * 
     * @param root The node root of tree.
     * @param key The key to find.
     * 
     * @return return the Node if exist, else return null.
     * */
    Node<K, E> getNodeByKey(Node<K, E> root, K key);
    
    /**
     * Removes the Node defined by key in a tree.
     * 
     * @param root The root of tree.
     * @param key The key of node to remove.    
     * 
     * @return true if the node has been found and removed, else return false.
     **/
    boolean removeNodeByKey(Node<K, E> root, K key);
    
    /**
     * Update the defined node in the tree of the root node.
     * 
     * @param root Root node while the tree must be updated.
     * @param node Node need to update.
     * 
     * @return True if update made, false if no update.
     * 
     * */
    boolean updateNode(Node<K, E> root, Node<K, E> node);
}
