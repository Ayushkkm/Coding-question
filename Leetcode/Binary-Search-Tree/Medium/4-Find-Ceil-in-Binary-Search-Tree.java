class Tree {
    // Function to return the ceil of given number in BST.
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        
        int ceil = -1;
        
        while(root != null){
            
            if(root.data == key){ // if equal -> return 
                ceil = key;
                return ceil;
            }
            
            if(root.data>key){ // if great -> store -> move left
                
                ceil = root.data;
                root = root.left;
            }
            
            else{  // if less -> move right
                
                root = root.right;
            }
        }
        
        return ceil;
    }
}
// TC -> O(log2(N)) 
// SC -> O(1)