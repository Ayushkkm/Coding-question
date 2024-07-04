class Solution {
    
    public boolean dfs(int node , int vis[] , int pathvis[] , 
    ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        pathvis[node] =1;
        
        for(Integer a : adj.get(node)){
            
            if(vis[a]==0){ // not visited
               if( dfs(a , vis, pathvis, adj) == true){
                   return true;
               }
            }
            
            else if(pathvis[a]==1){ // visited and pathvisited -> cycle
                return true ;
            }
        }
        
        pathvis[node] = 0 ; // if in -> one direction -> cycle not found -> mark not on same path
        
        return false;
    } 
   
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
       
       int vis[] = new int[V];
       int pathvis[] = new int[V];
       
       for(int i = 0 ; i < V ; i++){
           if(vis[i]==0){
               
               if(dfs(i , vis , pathvis , adj) == true){
                   return true;
               }
           }
       }
       
       return false;
    }
}
// TC -> O(V+E) -> directed -> not 2E
// SC -> O(2V) -> vis[] , pathvis[]