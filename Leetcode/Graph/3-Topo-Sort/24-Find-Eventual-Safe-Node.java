class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
      
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int n = graph.length; // number of nodes

       // Make reverse -> adjacent list

       int indegree[] = new int[n];

        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i < n ; i++){

            for(int j = 0 ; j < graph[i].length ; j++){
              
              adj.get(graph[i][j]).add(i);

              indegree[i]++; // make indegree also

            }
        }

     

    /*
         If adjacent list given
         
    ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();

       int indegree[] = new int[V];

        for(int i = 0 ; i < V ; i++){
            adjRev.add(new ArrayList<>());
        }

        for(int i = 0 ; i < V ; i++){

            // i -> a
            // a -> i
           
            for(Integer a : adj.get(i)){
                adjRev.get(a).add(i);

                indegree[i]++;
            }
        }
    */



        Queue<Integer> q = new LinkedList<>();

        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
           Integer node = q.poll();
           
           list.add(node);

           for(Integer a : adj.get(node)){
              indegree[a]--;

              if(indegree[a]==0){
                q.add(a);
              }
           }
        }

        Collections.sort(list);

        return list;

     }
}
// TC -> O(V+E) + O(Vlog(V))
// SC -> O(V+E)