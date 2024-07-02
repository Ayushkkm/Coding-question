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

    public TreeNode building(int inorder[] , int instart ,int inend , int postorder[] , 
    int poststart ,int postend , Map<Integer , Integer> map){
        
        if(poststart > postend || instart > inend){
            return null;
        }

        TreeNode root = new TreeNode(postorder[postend]);

        // find -> x

        int inval = map.get(postorder[postend]);

        int x = inval - instart;

        root.left = building(inorder , instart , inval-1 , 
        postorder , poststart , poststart+x-1 , map);

        root.right = building(inorder , inval +1 , inend ,
        postorder , poststart + x  , postend-1 , map);

        return root;     

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer , Integer> map = new HashMap<>();
        int size = inorder.length;

        for(int i = 0 ; i < size ; i++){
            map.put(inorder[i] , i);
        }

        TreeNode root = building(inorder , 0 , size-1 , 
        postorder , 0 , postorder.length-1 , map);

        return root;

    }
}
// TC -> O(N)
// SC -> O(N)