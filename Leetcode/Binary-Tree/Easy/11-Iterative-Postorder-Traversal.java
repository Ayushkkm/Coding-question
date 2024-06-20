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

    // Using 1 stack
    
    public List<Integer> postorderTraversal(TreeNode root) {
       
       List<Integer> post = new ArrayList<>();

       Stack<TreeNode> str = new Stack<>();

       if(root==null) return post;

       TreeNode curr = root;

       while(curr!=null || !str.isEmpty()){
        if(curr!=null){
            str.push(curr);
            curr = curr.left;

        }
        else{
            TreeNode temp = str.peek().right;

            if(temp==null){
                temp = str.pop();
                post.add(temp.val);

                while(!str.isEmpty() && temp == str.peek().right){
                    temp = str.pop();
                    post.add(temp.val);
                }
            }

            else{
                curr = temp;
            }

        }
       }

       return post;

        
    }
}