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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if(root==null) return list;

        Queue<TreeNode> q = new LinkedList<>();

        boolean flag = true; // true -> noraml -> flase -> zigzag

        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

            List<Integer> wrap = new ArrayList<>();

            for(int i = 0 ; i < size ; i++){
               if( q.peek().left!= null){
                 q.add(q.peek().left);
               }

               if( q.peek().right!= null){
                 q.add(q.peek().right);
               }

               if(flag){
                wrap.add(q.poll().val);
               }

               else{
                wrap.add(0,q.poll().val);
               }

            // can use
            //    int index = flag ? i : (size - 1 - i);
            //    wrap.add(index,q.poll().val);

            }

            flag = !flag;
            list.add(wrap);
        }

        return list;
    }
}
// Time Complexity : O(N)   
// Space Complexity : O(N)   