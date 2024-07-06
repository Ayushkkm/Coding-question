class Solution {
    
    public boolean dfs(int node , int vis[] , int pathVis[] , int check[],
    List<List<Integer>> adj){
        vis[node] =1;
        pathVis[node] = 1;
        
        check[node] = 0;
        
        for(Integer a : adj.get(node)){
            
            if(vis[a]==0){
                
                if(dfs(a,vis,pathVis, check , adj)==true){
                    check[node] = 0; // node is -> part of cycle -> has path toward cycle
                    
                    return true; // not -> able to make -> pathVis = 0 -> and tell other -> node is not safe 
                }
            }
            else if(pathVis[a]==1){ // cycle -> or path toward cycle
                check[node] = 0;
                return true;
                
            }
        }
        
        check[node] = 1 ; // safe node
        
        pathVis[node] = 0;
        
        return false;
    }

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        
        // GFG
        int vis[] = new int[V];
        int pathVis[] = new int[V];
        int check[] = new int[V];
        
        for(int i = 0 ; i < V; i++){
            if(vis[i]==0){
                dfs(i , vis, pathVis, check , adj); // traverse all -> node 
            }
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0 ; i < V ; i++){
            if(check[i]==1){
                list.add(i);
            }
        }
        
        return list;
    }
}

// TC -> O(V+E)
// SC -> O(3V) -> vis[] , pathVis[] , check[]
