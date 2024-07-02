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

    public TreeNode building(int preorder[] ,int prestart ,int preend , int inorder[],
    int instart , int inend ,  Map<Integer,Integer> map){
        
        if(prestart > preend || instart > inend){ // our two pointer
            return null;
        } 

        TreeNode root = new TreeNode(preorder[prestart]);

        // find -> x

        int inval = map.get(preorder[prestart]);

        int x = inval - instart;

        root.left = building(preorder , prestart + 1, prestart+x , 
        inorder , instart , inval-1 , map); // left -> get attached

        root.right = building(preorder , prestart + x +1 , preend , 
        inorder , inval +1 , inend ,map);

        return root;

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();

        int size = inorder.length;

        for(int i = 0 ; i  <size ; i++){
            map.put(inorder[i],i);
        }

        TreeNode root = building(preorder, 0 , preorder.length-1, inorder , 0 , 
         size-1 , map) ;

         return root; 


    }
}
// TC -> O(N)
// SC -> O(N)
