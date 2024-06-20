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

class pair{
    TreeNode node;
    int data;

    pair(TreeNode node , int data){
        this.node = node;
        this.data = data;
    }
}

class solution{

public List<List<Integer>> PreInPost(TreeNode root){
  
  List<List<Integer>> list = new ArrayList<>();

  List<Integer> pre = new ArrayList<>();
  List<Integer> in = new ArrayList<>();
  List<Integer> post = new ArrayList<>();

  Stack<pair> str = new Stack<>();

  if(root==null) return list;

  str.push(new pair(root,1));

  while(!str.isEmpty()){
     pair p = str.pop();

     if(p.data==1){
        pre.add(p.node.val);

        p.data = 2;
        str.push(p);

        if(p.node.left!=null) str.push(new pair(p.node.left,1));

     }

     else if(p.data==2){
       
       in.add(p.node.val);

       p.data = 3;

       str.push(p);

       if(p.node.right!=null) str.push(new pair(p.node.right,1));
     }

     else{
        post.add(p.node.val);
     }
  }

    list.add(pre);
    list.add(in);
    list.add(post);

    return list;

}

}
