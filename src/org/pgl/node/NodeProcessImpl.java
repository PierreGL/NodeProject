package org.pgl.node;

public class NodeProcessImpl implements NodeProcess {

    @Override
    public int findMax(Node root) {

        int rootValue = root.getValue();
        int rightValueMax;
        int leftValueMax;
        Node rightChild = root.getRightChild();
        Node leftChild = root.getLeftChild();

        if(rightChild != null){
            rightValueMax = findMax(rightChild);
        }else{
            rightValueMax = Integer.MIN_VALUE;
        }

        if(leftChild != null){
            leftValueMax = findMax(leftChild);
        }else{
            leftValueMax = Integer.MIN_VALUE;
        }

        int valueMax = getMaxValue(rootValue, leftValueMax, rightValueMax);

        return valueMax;
    }

    @Override
    public Node getNodeByValue(Node root, int value) {

        Node result = null;

        int rootValue = root.getValue();

        if(value > rootValue){
            Node rightNode = root.getRightChild();
            if(rightNode != null){
                result = getNodeByValue(rightNode, value);
            }
        }else if(value < rootValue){
            Node leftNode = root.getLeftChild();
            if(leftNode != null){
                result = getNodeByValue(leftNode, value);
            }
        }else{//value == rootValue
            result = root;
        }

        return result;
    }

    @Override
    public boolean removeNodeByValue(Node current, int valueToRemove) {
        boolean result = false;
        
        Node leftChild = current.getLeftChild();
        Node rightChild = current.getRightChild();
        int currentValue = current.getValue();

        if(valueToRemove < currentValue){
            if(leftChild != null){
                if(leftChild.getValue() == valueToRemove){
                    removing(current, leftChild);
                    result = true;
                }else{
                    result = removeNodeByValue(leftChild, valueToRemove);
                }
            }//else inexisting child the value has not been found

        }else if(valueToRemove > currentValue){
            if(rightChild != null){
                if(rightChild.getValue() == valueToRemove){
                    removing(current, rightChild);
                    result = true;
                }else{
                    result = removeNodeByValue(rightChild, valueToRemove);
                }
            }//else inexisting child the value has not been found
        }
            
        return result;
    }

    /**
     * Remove the node and if necessary, move the child of removed node in its parent.
     * */
    private void removing(Node parent, Node nodeToRemove){

    }

    /**
     * Compare 3 int values and return the max.
     * */
    private int getMaxValue(int a, int b, int c){
        int result;
        if(a > b){
            if(a > c){
                result = a;
            }else{
                result = c;
            }
        }else{
            if(b > c){
                result = b;
            }else{
                result = c;
            }
        }

        return result;
    }

}
