class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // Make adjacent list

        int n = prerequisites.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < numCourses ; i++){
           
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i < n ; i++){
        
           adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        // Topological sort

        int indegree[] = new int[numCourses];

        Queue<Integer> q = new LinkedList<>();

        List<Integer> topo = new ArrayList<>();

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

        while(!q.isEmpty()){
            Integer node = q.poll();
            topo.add(node);

            for(Integer a : adj.get(node)){
                indegree[a]--;

                if(indegree[a]==0){
                    q.add(a);
                }
            }
        }

        if(topo.size()==numCourses){
            return true;
        }

        return false;
    }
}
// TC -> O(V+E)
// SC -> O(V+E) -> adj[] , indegree[] , q[] , topo[]
