class solution{
    public void changeTree(BinaryTreeNode root){
        if(root==null){
            return;
        }

        int child = 0; 
        if(root.left!=null) child += root.left.val;
        if(root.right!=null) child += root.right.val;

        if(child>=root.val) root.val = child;
        else{
            if(root.left!=null){
                root.left.val = root.val; 
            }

            if(root.right!=null) {
                root.right.val = root.val;
            }
        }

        changeTree(root.left);
        changeTree(root.right);
        
        // Backtrack
        int tot = 0;

        if(root.left!=null) tot += root.left.val;
        if(root.right!=null) tot += root.right.val;
        if(root.left!= null && root.right!=null) root.val = tot ; // left node -> root = root's val -> other node -> root -> tot

    }
}
// TC -> O(N)
// SC -> O(H) -> recursion stack