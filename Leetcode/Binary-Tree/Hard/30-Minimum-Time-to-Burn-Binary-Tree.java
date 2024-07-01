class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    public static Node MakeParent(Node root , int target, Map<Node,Node> parent){
        Queue<Node> q = new LinkedList<>();
        Node rt = null ;
        
        q.add(root);
        
        while(!q.isEmpty()){
            Node n = q.poll();
            
            if(n.data==target) {
                rt = n;  // set the target
            }
            
            if(n.left!=null){
                parent.put(n.left,n);
                q.add(n.left);
            }
            
            if(n.right!=null){
                parent.put(n.right,n);
                q.add(n.right);
            }
        }
        
        return rt;
        
        
    }
    
    public static int minTime(Node root, int target) 
    {
        // GFG
        Map<Node,Node> parent = new HashMap<>();
        
        Node node = MakeParent(root , target , parent);
        
        Map<Node , Boolean> vis = new HashMap<>(); // visited
        
        Queue<Node> q = new LinkedList<>();
        
        q.add(node);
        vis.put(node,true);
        
        int time = 0 ; 
        
        while(!q.isEmpty()){
            
            int flag = 0;
            
            int size = q.size();
            
            for(int i = 0 ; i < size ; i++){
                Node n = q.poll();
                
                if(n.left!=null && !vis.containsKey(n.left)){
                    vis.put(n.left,true);
                    flag = 1;
                    q.add(n.left);
                }
                
                if(n.right!=null && !vis.containsKey(n.right)){
                    vis.put(n.right,true);
                    flag = 1;
                    q.add(n.right);
                }
                
                if(parent.containsKey(n) && !vis.containsKey(parent.get(n))){
                    vis.put(parent.get(n),true);
                    flag = 1;
                    q.add(parent.get(n));
                }
            }
            
            if(flag==1) time++;
            
        }
        
        return time;
        
        
    }
}
// TC -> O(N)
// SC -> O(N)