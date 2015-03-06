package org.pgl.node;

import java.io.Serializable;

/**
 * The default implementation of Node class.
 * */
public class NodeImpl<K extends Comparable<K> & Serializable, E extends Serializable> implements Node<K, E> {

    private K key;
    
    private E entity;
    
    private Node<K, E> parent;

    private Node<K, E> leftChild;
    private Node<K, E> rightChild;
    
    public NodeImpl(K key){
        this.key = key;
    }
    
    public NodeImpl(K key, E entity){
        this.key = key;
        this.entity = entity;
    }
    
    public void addChild(Node<K, E> node){
        
        if(node.getKey().compareTo(this.key) > 0){
            if(this.rightChild == null){
                node.setParent(this);
                this.rightChild = node;                
            }else{
                this.rightChild.addChild(node);
            }
        }else if(node.getKey().compareTo(this.key) < 0){
            if(this.leftChild == null){
                node.setParent(this);
                this.leftChild = node;
            }else{
                this.leftChild.addChild(node);
            }
        }
        
//        if(node.getKey() > this.key){
//            if(this.rightChild == null){
//                node.setParent(this);
//                this.rightChild = node;                
//            }else{
//                this.rightChild.addChild(node);
//            }
//        }else if(node.getKey() < this.key){
//            if(this.leftChild == null){
//                node.setParent(this);
//                this.leftChild = node;
//            }else{
//                this.leftChild.addChild(node);
//            }
//        }
        //The node already exist
    }
    
    @Override
    public K getKey() {
        return key;
    }
    
    @Override
    public E getEntity() {
        return entity;
    }

    @Override
    public Node<K, E> getParent() {
        return parent;
    }
    
    @Override
    public void setParent(Node<K, E> parent) {
        this.parent = parent;        
    }
    
    @Override
    public Node<K, E> getRightChild() {
        return rightChild;
    }
    
    @Override
    public void setRightChild(Node<K, E> node) {
        this.rightChild = node;        
    }
    
    @Override
    public void setLeftChild(Node<K, E> node) {
        this.leftChild = node;        
    }

    @Override
    public Node<K, E> getLeftChild() {
        return leftChild;
    }

}
