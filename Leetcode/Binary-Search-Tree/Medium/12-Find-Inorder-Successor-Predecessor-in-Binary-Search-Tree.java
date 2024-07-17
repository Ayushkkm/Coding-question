class Solution {
    
    public static void predecessor(Node root , Node pre[] , int key){
        
        pre[0] = null;
        
        while(root != null){
            
            if(root.data >= key){ // move left
                
                root = root.left;
            }
            
            else if( root.data < key){ // store -> move right
                
                pre[0] = root;
                
                root = root.right;
            }
        }
    }
    
    public static void successor(Node root , Node suc[] , int key){
        
        suc[0] = null;
        
        while(root != null){
            
            if(root.data <= key){ // less or equal -> move right
                
                root = root.right;
            }
            
            else if(root.data > key){ // store -> move left
                
                suc[0] = root;
                
                root = root.left;
            }
            
            
        }
    }
    
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        
        // GFG
        
        predecessor(root , pre , key);
        
        successor(root , suc , key);
        
    }
}

// TC -> O(H)
// SC -> O(1)
