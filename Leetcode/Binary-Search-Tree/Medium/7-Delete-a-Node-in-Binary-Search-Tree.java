/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public TreeNode extremeRight(TreeNode root){
       
        while(root.right != null){
            root = root.right;
        }

        return root; // extreme right
    }

    public TreeNode delete(TreeNode root , int key){

        if(root.left == null){ // if delete node -> no left -> return root.right -> to get attach -> to parent of delete root
            return root.right;
        }

        if(root.right == null){ 
            return root.left ;
        }

        TreeNode deleteRight = root.right ;

        TreeNode leftExtremeRight = extremeRight(root.left) ; // find extreme right -> of left part -> of delete node 

        leftExtremeRight.right = deleteRight ; // left -> right

        return root.left; // return left node -> of delete node -> to get attach to -> delete parent node
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }

        if(root.val == key){ // our root is -> delete node -> return left of delete node -> after make -> arrangement
       
         return delete(root , key);

        }

        TreeNode dummy = root ; // need -> to return -> root

        while(root != null){ // search start
        
          if(root.val >= key){ // move to left
           
           if(root.left != null && root.left.val == key){ // find our delete node -> parent is root
                
                root.left = delete(root.left , key ); // make link -> and pass delete node -> to make arrangement
            } 
            else{ // not found -> move left
                root = root.left;
            }
          }

          else{ // move right 

            if(root.right !=null && root.right.val == key){

                root.right = delete(root.right , key); // pass delete node -> and parent make link -> to it's right
            }

            else {
                root = root.right;
            }
          }
          
        }

        return dummy;
    }
}

// TC -> O(log2(N))
// SC -> O(1)