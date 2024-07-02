/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        StringBuilder str = new StringBuilder();

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node==null){  // if null -> add n to string -> continue -> don't add -> left and right -> of null
                str.append("n ");
                continue;
            }

            str.append(node.val + " ");
            q.add(node.left); // add node -> null also -> we don't add null normally
            q.add(node.right); 
        }

        return  str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if(data=="") return null;

        Queue<TreeNode> q = new LinkedList<>();
        String str[] = data.split(" "); // make array -> remove space

        TreeNode root = new TreeNode(Integer.parseInt(str[0])); // our root
        q.add(root); // start -> make tree

        for(int i = 1 ; i< str.length ; i++){
            TreeNode parent = q.poll();

            if(!str[i].equals("n")){ // left
                TreeNode left = new TreeNode(Integer.parseInt(str[i]));
                parent.left = left;
                q.add(left);
            }
            
            if(!str[++i].equals("n")){ // right
              TreeNode right = new TreeNode(Integer.parseInt(str[i]));

              parent.right = right;
              q.add(right);
                 
            }
            // if null -> don't add anything to queue -> it become null itself

        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

// TC -> O(N)
// SC -> O(N)