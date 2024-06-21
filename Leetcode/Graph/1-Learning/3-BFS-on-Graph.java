class Solution {
    
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
        // GFG
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        boolean vis[] = new boolean[V];
        
        Queue<Integer> q  = new LinkedList<>();
        
        q.add(0);
        vis[0] = true;
        
        while(!q.isEmpty()){
            Integer node = q.poll();
            list.add(node);
            
            for(Integer a : adj.get(node)){
                if(vis[a]==false){
                    q.add(a);
                    vis[a] = true;
                }
            }
            
        } 
        
        return list;
    
    }
}

// TC -> O(V+2E)
// SC -> O(2V) -> vis , queue
