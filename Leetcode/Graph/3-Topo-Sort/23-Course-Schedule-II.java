class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         // Make adjacent list

        int n = prerequisites.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < numCourses ; i++){
           
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i < n ; i++){
        
           adj.get(prerequisites[i][1]).add(prerequisites[i][0]); // u,v -> v->u edge -> opposite -> v 1st -> then u
        }

        // Topological sort

        int indegree[] = new int[numCourses];

        Queue<Integer> q = new LinkedList<>();


        for(int i = 0 ; i < numCourses ; i++){

            for(Integer a : adj.get(i)){
                indegree[a]++;
            }
        }

        for(int i = 0 ; i < numCourses ; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

         int topo[] = new int[numCourses];
         int i = 0;

        while(!q.isEmpty()){
            Integer node = q.poll();
            topo[i++] = node;

            for(Integer a : adj.get(node)){
                indegree[a]--;

                if(indegree[a]==0){
                    q.add(a);
                }
            }
        }

        if(i == numCourses){
            return topo;
        }

        return new int[]{} ;
    }
}
// TC -> O(V+E)
// SC -> O(V+E) -> adj[] , indegree[] , q[] , topo[]

// Check -> GFG -> course schedule
