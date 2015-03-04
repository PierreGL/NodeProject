package org.pgl.node;

public class NodeImpl implements Node {

    private int value;
    
    private Node parent;

    private Node leftChild;
    private Node rightChild;
    
    public NodeImpl(int value){
        this.value = value;
    }
    
    public void addChild(Node node){
        if(node.getValue() > this.value){
            if(this.rightChild == null){
                node.setParent(this);
                this.rightChild = node;                
            }else{
                this.rightChild.addChild(node);
            }
        }else if(node.getValue() < this.value){
            if(this.leftChild == null){
                node.setParent(this);
                this.leftChild = node;
            }else{
                this.leftChild.addChild(node);
            }
        }
        //The node already exist
    }
    
    @Override
    public int getValue() {
        return value;
    }

    @Override
    public Node getParent() {
        return parent;
    }
    
    @Override
    public void setParent(Node parent) {
        this.parent = parent;        
    }
    
    @Override
    public Node getRightChild() {
        return rightChild;
    }

    @Override
    public Node getLeftChild() {
        return leftChild;
    }

}
