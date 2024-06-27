class Solution {
   
    public boolean detect(int node , int parent , boolean vis[] ,
     ArrayList<ArrayList<Integer>> adj){
         
         vis[node] = true;
         
         for(Integer a : adj.get(node)){
             if(vis[a]==false){
                 if(detect(a , node , vis , adj)==true){
                     return true;
                 }
             }
             
             else if(parent != a){
                 return true;
             }
         }
         
         return false;
     }
    
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
       boolean vis[] = new boolean[V];
       
       for(int i = 0  ; i < V ; i++){
           if(vis[i]==false){
               if(detect(i, -1, vis, adj)==true){
                   return true;
               }
           }
       }
       
       return false;
    }
}

// TC -> O(V+2E) + O(N) -> connected component
// SC -> O(2V) -> vis[] , queue