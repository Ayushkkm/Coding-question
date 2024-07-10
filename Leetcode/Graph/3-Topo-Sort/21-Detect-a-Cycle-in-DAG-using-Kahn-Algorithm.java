class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
        int indegree[] = new int[V];
        
        for(int i = 0 ; i < V ; i++){
            
            for(Integer a : adj.get(i)){
                indegree[a]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0 ; i < V ; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        int count = 0 ; // use count
        
        while(!q.isEmpty()){
            
            Integer node = q.poll();
            count++;
            
            for(Integer a : adj.get(node)){
                
                indegree[a]--;
                
                if(indegree[a]==0){
                    q.add(a);
                }
            }
        }
        
        if(count != V){ // cycle present
            return true;
        }
        
        return false;
    }
}
// TC -> O(V+E)
// SC -> O(V) -> indegree[] , q