class Solution
{
    
    public boolean bfs(int node , int V , int colour[] ,
    ArrayList<ArrayList<Integer>>adj ){
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(node);
        colour[node]=0;
        
        while(!q.isEmpty()){
            Integer nd = q.poll();
            
            for(Integer a : adj.get(nd)){
            
            if(colour[a]==-1){
                colour[a] = 1 - colour[nd];
                q.add(a);
            }
            
            if(colour[a]==colour[nd]){
                return false;
            }
        }
        
        }
        
        return true;
    }
    
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
       // GFG
       int colour[]  = new int[V];
       Arrays.fill(colour , -1);
       
       for(int i = 0 ; i < V ; i++){
           if(colour[i]==-1){
               
               if(bfs(i , V , colour , adj)==false){
                   return false;
               }
           }
       }
       
       return true;
    }
}
// TC -> O(V+E)
// SC -> O(V) -> colour[]
