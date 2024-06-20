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

    public List<Integer> inorderTraversal(TreeNode root) {
   
    List<Integer> in = new ArrayList<>();

    if(root==null) return in;

    Stack<TreeNode> str = new Stack<>();

    TreeNode node = root;

    while(true){
        if(node!=null){
            str.push(node);
            node = node.left;
        }
        else{
            if(str.isEmpty()) break;

            node = str.pop();
            in.add(node.val);
            node = node.right;

        }
    }

    return in;

    // str.push(root);
    // while(!str.isEmpty){
    //     if(node != null){
    //         str.push(node);
    //         node = node.left;
    //     }
    // } wrong here -> in str.push -> two time

    }
}