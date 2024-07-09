class Solution {
    public static int floor(Node root, int x) {
        
        int floor = -1;
        
        while(root!=null){
            
            if(root.data == x){ // equal
                
                floor = root.data;
                return floor;
            }
            
            if(root.data < x){ // less -> store -> move right
                
                floor = root.data;
                
                root = root.right;
            
            }
            
            else{ // greater -> move left
                
                root = root.left;
            }
        }
        
        return floor;
    }
}
// TC -> O(log2(N)) 
// SC -> O(1)