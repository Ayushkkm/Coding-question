// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
    boolean isLeaf(Node root){
        
        return root.left == null  && root.right == null;
    }
    
    void AddLeft(Node root , ArrayList<Integer> list){
        Node curr = root.left;
        
        while(curr != null){
            
            if(!isLeaf(curr)){
                list.add(curr.data);
                
             }
             
             if(curr.left!=null){
                 curr = curr.left;
             }
             else{
                 curr = curr.right;
             }
        }
    }
    
    void leaves(Node root , ArrayList<Integer> list){
        if(root==null) return;
        
        if(isLeaf(root)){
            list.add(root.data);
        }
        
        leaves(root.left, list);
        leaves(root.right,list);
        
    }
    
    void AddRight(Node root , ArrayList<Integer> list){
        Node curr = root.right;
        
        ArrayList<Integer> temp = new ArrayList<>();
        
        while(curr != null){
            
            if(!isLeaf(curr)){
                temp.add(curr.data);
            }
            
            if(curr.right!=null){
                curr = curr.right;
                
            }
            else{
                curr = curr.left;
            }
        }
        
        for(int i = temp.size()-1 ; i>=0 ; i--){
            list.add(temp.get(i));
        }
    }
    
	ArrayList <Integer> boundary(Node node)
	{
        // GFG
	    ArrayList<Integer> list = new ArrayList<>();
	    
	    if(!isLeaf(node)){
	        list.add(node.data);
	    }
	    
	    AddLeft(node,list);
	    leaves(node,list);
	    
	    AddRight(node,list);
	    
	    return list;
	}
}