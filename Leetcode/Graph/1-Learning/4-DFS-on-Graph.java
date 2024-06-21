class Solution {
    
    public void dfs(Integer node , boolean vis[] , ArrayList<Integer> list , 
    ArrayList<ArrayList<Integer>> adj){
        // GFG
        vis[node] = true;
        
        list.add(node);
        
        for(Integer a : adj.get(node)){
            if(vis[a]==false){
                dfs(a, vis, list , adj);
            }
        }
        
    }
    
    
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        boolean vis[] = new boolean[V];
        
        dfs(0, vis , list , adj);
        
        return list;
        
        
    }
}

// TC -> O(V+E)
// SC -> O(3V) -> vis[] -> list -> stack