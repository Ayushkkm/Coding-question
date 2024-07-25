class Solution
{
    static class pair implements Comparable <pair>{
        
        int distance ;
        int node;
        
        public pair(int distance , int node){
            this.distance = distance;
            
            this.node = node;
        }
        
        public int compareTo(pair other){
            if(this.distance == other.distance){
                return Integer.compare(this.node , other.node);
            }
            
            else{
                return Integer.compare(this.distance , other.distance);
            }
        }
    }
    
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        PriorityQueue<pair> minHeap = new PriorityQueue<>();
        
        int dis[] = new int[V];
        
        Arrays.fill(dis , Integer.MAX_VALUE);
        
        dis[S] = 0;
        
        minHeap.add(new pair(0 ,S));
        
        while(!minHeap.isEmpty()){
            
            pair it = minHeap.remove();
            
            int currdist = it.distance;
            
            int node = it.node;
            
            for(ArrayList<Integer> a : adj.get(node)){
                
                int weight = a.get(1);
                int adjnode = a.get(0);
                
                if(weight + currdist < dis[adjnode]){
                    
                    dis[adjnode] = currdist + weight ;
                    
                    minHeap.add(new pair(dis[adjnode] , adjnode));
                }
            }
            
        }
        
        return dis;
        
    }
}

// TC -> O(E * logV)
// SC -> O(V + E)