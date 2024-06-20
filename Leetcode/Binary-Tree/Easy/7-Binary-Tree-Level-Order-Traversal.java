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
    public List<List<Integer>> levelOrder(TreeNode root) {
             
        List<List<Integer>> Tlist = new ArrayList<List<Integer>>();
        //ArrayList<List<Integer>> yhe under ka same hona chaiye

        Queue<TreeNode> q = new LinkedList<>();

        if(root==null) return Tlist;

        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

            List<Integer> list = new ArrayList<Integer>();

            for(int i = 0; i<size; i++){
                if(q.peek().left!=null ) q.add(q.peek().left);
                if(q.peek().right!=null) q.add(q.peek().right);

                list.add(q.poll().val);
            }

            Tlist.add(list);
        }

        return Tlist;
    }
}