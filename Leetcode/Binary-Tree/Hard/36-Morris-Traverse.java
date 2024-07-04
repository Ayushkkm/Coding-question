
// Inorder
// Morris Traversal

class Solution { 
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(root==null) {
            return list;
        }

        TreeNode curr = root;

        while(curr!=null){
            if(curr.left==null){ // curr.left -> is null 
                list.add(curr.val);
                curr = curr.right;
            }
            else{  // curr.left -> is not null
               
               TreeNode prev = curr.left; // make -> to left part of tree

               while(prev.right!=null && prev.right != curr){  // check prev -> right is not null -> thread is not made -> or prev.right -> is curr -> thread is already made
                   prev = prev.right; // find left part -> right most -> node
               }

               if(prev.right==null){ // thread -> not present
                  prev.right = curr;
                  curr = curr.left;
               }
               else{ // thread -> already made -> we traverse -> left part before
                 
                 prev.right = null ; // remove thread
                 list.add(curr.val); // left( already traverse) -> now root 
                 curr = curr.right ;
                 // move right
               }

            }

        }

        return list;
    }
}

// TC -> O(N)
// SC -> O(1)


// Preorder
// Morris Traversal

class Solution { 
    public List<Integer> PreorderTraversal(TreeNode root) {
        List<Integer> pre = new ArrayList<>();

        if(root==null) {
            return pre;
        }

        TreeNode curr = root;

        while(curr!=null){
            if(curr.left==null){ // curr.left -> is null 
                pre.add(curr.val);
                curr = curr.right;
            }
            else{  // curr.left -> is not null
               
               TreeNode prev = curr.left; // make -> to left part of tree

               while(prev.right!=null && prev.right != curr){  // check prev -> right is not null -> thread is not made -> or prev.right -> is curr -> thread is already made
                   prev = prev.right; // find left part -> right most -> node
               }

               if(prev.right==null){ // thread -> not present
                  prev.right = curr;
                  pre.add(curr.val); // add pre -> move left to traverse
                  curr = curr.left;
               }
               else{ // thread -> already made -> we traverse -> left part before
                 
                 prev.right = null ; // remove thread
                 curr = curr.right ;
                 // move right

               }

            }

        }

        return pre;
    }
}

// PostOrder
// Morris Traversal

class Solution { 
    public List<Integer> PostorderTraversal(TreeNode root) {
        List<Integer> post = new ArrayList<>();

        if(root==null) {
            return post;
        }

        TreeNode curr = root;

        while(curr!=null){
            if(curr.right==null){ // curr.right -> is null 
                post.add(curr.val);
                curr = curr.left;
            }
            else{  // curr.right -> is not null
               
               TreeNode prev = curr.right; // make -> to right part of tree

               while(prev.left!=null && prev.left != curr){  // check prev -> left is not null -> thread is not made -> or prev.left -> is curr -> thread is already made
                   prev = prev.left; // find right part -> left most -> node
               }

               if(prev.left==null){ // thread -> not present
                  prev.left = curr;
                  post.add(curr.val); // add post -> move right to traverse
                  curr = curr.right;
               }
               else{ // thread -> already made -> we traverse -> right part before
                 
                 prev.left = null ; // remove thread
                 curr = curr.left ;
                 // move left

               }

            }

        }

        return post;
    }
}

// TC -> O(N)
// SC -> O(1)