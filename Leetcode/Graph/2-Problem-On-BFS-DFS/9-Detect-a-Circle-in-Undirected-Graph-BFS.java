class Solution {
    
    class pair{
        int first;
        int second;
        
        pair(int first , int second){
            this.first = first;
            this.second = second;
        }
    }
    
    public boolean detect(int node , boolean vis[] , ArrayList<ArrayList<Integer>> adj ){
        
        vis[node] = true;
        Queue<pair> q = new LinkedList<>();
        
        q.add(new pair(node,-1)); // node , parents
        
        
        while(!q.isEmpty()){
            pair p = q.poll();
            
            int nd = p.first;
            int parent = p.second;
            
            for(Integer a : adj.get(nd)){
                if(vis[a]==false){
                    vis[a] = true;
                    q.add(new pair(a,nd));
                }
                else if(parent != a){
                    return true;
                }
            }
        }
        
        return false;
    }
   
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
      boolean vis[] = new boolean[V];    
      
      for(int i = 0 ; i < V ; i++){
          if(vis[i]==false){
              if(detect(i,vis,adj)==true){
                  return true;
              } 
          }
      }
      
      return false;
    }
}

// TC -> O(V+2E) + O(N) -> connected component
// SC -> O(2V) -> vis[] , queue