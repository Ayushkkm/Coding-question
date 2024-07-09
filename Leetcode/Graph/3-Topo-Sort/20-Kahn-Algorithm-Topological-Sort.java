class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int indegree[] = new int[V];
        
        
        for(int i = 0 ; i < V ; i++){ // making indegree array
            
            for(Integer a : adj.get(i)){
                indegree[a]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0 ; i <V; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        int ans[] = new int[V];
        int i = 0 ;
        
        while(!q.isEmpty()){
            
            Integer node = q.poll();
            
            ans[i++] = node;
            
            for(Integer a : adj.get(node)){ // for removing -> indegree of -> adjacent
                indegree[a]--;
                
                if(indegree[a]==0){ // if -> indegree of -> any adjacent -> 0 -> put in queue
                    q.add(a);
                }
            }
          
        }
        
        return ans;
        
    }
}

// TC -> O(V+E)
// SC -> O(V) -> indegree[] , q
