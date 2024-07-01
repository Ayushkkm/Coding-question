class Solution {
    public boolean inorder(TreeNode root , int value ,List<Integer> list){
        if(root==null){
            return false;
        }
        
        // add curr value
        list.add(root.val);
        
        // our value is found -> path is found 
        if(root.val==value){
            return true;
        }
        
        // anyone -> find path -> return true 
        if(inorder(root.left, value, list)==true){
            return true;
        }

        if(inorder(root.right , value , list)==true){
            return true;
        }

        // if(inorder(root.left, value, list) || inorder(root.right , value , list))
        //     return true;
        
        // both left and right -> cannot -> find path -> remove it -> return false
        list.remove(list.size()-1);
        return false;

    }

    public List<String> binaryTreeNodePaths(TreeNode root, int value) {
        List<Integer> list = new ArrayList<>();

        if(root==null) return list;
        inorder(root,value,list);

        return list;
    
    }
}  
// TC -> O(N) 
// SC -> O(H) -> list -> path