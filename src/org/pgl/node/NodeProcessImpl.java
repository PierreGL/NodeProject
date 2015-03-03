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

	@Override
	public Node getNodeByValue(Node root, int value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeNodeByValue(Node root, int value) {
		// TODO Auto-generated method stub
		return false;
	}
}
