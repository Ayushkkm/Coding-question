class Solution {
    
    class pair implements Comparable <pair>{
        
        int dis;
        int node;
        
        public pair(int dis , int node){
            this.dis = dis;
            this.node = node;
        }
        
        public int compareTo(pair other){
            
            return Integer.compare(this.dis , other.dis);
        }
    }
    
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        
       // make adjacent list
       
       for(int i = 0 ; i <= n ; i++){  // 1 based -> indexing
           adj.add(new ArrayList<>());
       }
       
       for(int i = 0 ; i < m ; i++){
          
            ArrayList<Integer> edge1 = new ArrayList<>(); //  adj.get(edges[i][0]).add(new ArrayList<>(edges[i][1] , edges[i][2])); -> this will -> not work -> only arraylist -> pass () -> in bracket -> <>(edges[i][1] , edges[i][2])
            edge1.add(edges[i][1]);
            edge1.add(edges[i][2]);
            adj.get(edges[i][0]).add(edge1);

            ArrayList<Integer> edge2 = new ArrayList<>();
            edge2.add(edges[i][0]);
            edge2.add(edges[i][2]);
            adj.get(edges[i][1]).add(edge2);
        
       }
       
       int dist[] = new int[n+1]; // n is total -> vertices -> 1 based  -> indexing
       int parent[] = new int[n+1];
       
       for(int i = 1 ; i < n+1 ; i++){
           
           dist[i] = Integer.MAX_VALUE;
           
           parent[i] = i; // self -> parent
       }
       
       PriorityQueue<pair> minHeap = new PriorityQueue<>();
       
       minHeap.add(new pair(0 , 1));
       
       dist[1] = 0; // 1 based indexing
       
       while(!minHeap.isEmpty()){
           
           pair p = minHeap.remove();
           
           int node = p.node;
           int currdis = p.dis;
           
           for(ArrayList<Integer> a : adj.get(node)){
               
               int adjNode = a.get(0);
               int weight = a.get(1);
               
               if(weight + currdis < dist[adjNode]){
                   
                   dist[adjNode] = weight + currdis;
                   
                   minHeap.add(new pair(dist[adjNode] , adjNode));
                   
                   parent[adjNode] = node; // parent -> node
               }
           }
           
       }
       
       
        // Trace the path from n to 1 using the parent array
        List<Integer> path = new ArrayList<>();
        
        if (dist[n] == Integer.MAX_VALUE) {
            
            path.add(-1);
            return path;
        }
        
        int node = n ;
        
        
        while(parent[node] != node){
            
            path.add(node);
            
            node = parent[node] ; // now find parent -> of -> parent node
        }
        
        path.add(1);
        
        Collections.reverse(path);
        
        // Add the total distance at the beginning of the path
        path.add(0, dist[n]);
        
        return path;
    }
}

// TC -> O(VlogV + ElogV) -> O(ElogV)
// SC -> O(V) -> for storing distance of each node