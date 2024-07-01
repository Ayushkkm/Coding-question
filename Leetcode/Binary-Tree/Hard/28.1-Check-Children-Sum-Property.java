class Node{
	int data;
	Node left,right;
	
	Node(int key)
	{
	    data = key;
	    left = right = null;
	}
}

*/
class Solution
{
    public static boolean inorder(Node root){
        if(root==null) return true;
        
         // If the node is a leaf node, it satisfies the property
        if (root.left == null && root.right == null) return true;
        
        int l = 0 ; // use child 
        int r = 0;
        
        if(root.left!=null) {
            l = root.left.data;
        }
        
        if(root.right!=null){
            r = root.right.data;
        }
        
        // check
        
        if(root.data!=l+r) return false;
        
        // inorder call
        
        if(inorder(root.left)==false){
            return false;
        }
        
        if(inorder(root.right)==false){
            return false;
        }
        
        
        return true;
        
        //return inorder(root.left) && inorder(root.right);
        
    }
    
    public static int isSumProperty(Node root)
    {
        // GFG

        if(inorder(root)==true){
            return 1;
        }
        
        return 0;
        
       // return inorder(root) ? 1 : 0;
        
    }
}
// TC -> O(N)
// SC -> O(H) -> recursion stack