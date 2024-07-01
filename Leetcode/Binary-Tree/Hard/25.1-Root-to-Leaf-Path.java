/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    
    public static boolean isLeaf(Node root){
        return root.left == null && root.right==null;
    }
    
    public static void inorder(Node root ,ArrayList<ArrayList<Integer>> arr
    , ArrayList<Integer> list){
       
        if(root==null){
            return ;
        }
        
        list.add(root.data);
        
        if(isLeaf(root)){
            
            arr.add(new ArrayList(list)); // create a new list-> for each recursive call
            
            list.remove(list.size()-1); // remove last element -> for other list 
            return ;
        }
        
        inorder(root.left , arr, list);
        inorder(root.right , arr , list);
        
        list.remove(list.size()-1); // Remove element -> not at leaf -> to travel -> other path
        // like -> root.left complete -> go -> root.right -> by removing root.left from -> list
        
        
    }
    
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {

        // GFG
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        if(root==null){
            return arr;
        }
        
        inorder(root , arr , list);
        
        return arr;
      
    }
}

// TC -> O(N) 
// SC -> O(H) 
