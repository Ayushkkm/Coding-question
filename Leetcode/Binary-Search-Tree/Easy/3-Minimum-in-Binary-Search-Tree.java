
/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
class Solution {
    // Function to find the minimum element in the given BST.
    int minValue(Node root) {
        
        int min = 0 ;
        
        // Just -> move -> left
        
        while(root!=null){
            
            min = root.data ;
            root = root.left;
            
        }
        
        return min;
    }
}
// TC -> O(log2(N)) 
// SC -> O(1)
