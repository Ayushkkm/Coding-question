class Solution {
    
    static class tuple implements Comparable<tuple> {
        
        int distance;
        int node;
        int parent;

        public tuple(int distance, int node, int parent) {
            
            this.distance = distance;
            this.node = node;
            this.parent = parent;
        }

        public int compareTo(tuple other) {
            
            return Integer.compare(this.distance, other.distance);
        }
    }

    static int spanningTree(int V, int E, List<List<int[]>> adj) {
       
        PriorityQueue<tuple> minHeap = new PriorityQueue<>();

        int[] vis = new int[V];
        
        List<int[]> mstEdges = new ArrayList<>(); // to store -> mst
        
        
        // {distance , node , parent}
        minHeap.add(new tuple(0, 0, -1));
        
        int sum = 0;

        while (!minHeap.isEmpty()) {
            
            tuple current = minHeap.remove();
            
            int wt = current.distance;
            int node = current.node;
            int parent = current.parent;

            if (vis[node] == 1) continue; // each node -> contains -> only 1 edge -> if node make -> edge -> come again -> no edge this time
            
            vis[node] = 1;  // Add it to the MST
            sum += wt;

          
            if (parent != -1) {  // except -> -1 parent -> all edge -> take
                
                mstEdges.add(new int[]{parent, node});
            }

            for (int i = 0; i < adj.get(node).size(); i++) {
                
                int adjNode = adj.get(node).get(i)[0];
                int edW = adj.get(node).get(i)[1];
                
                if (vis[adjNode] == 0) { // don't -> put -> node -> that -> already -> make edge
                    
                    minHeap.add(new tuple(edW, adjNode, node));
                }
            }
        }

        
        return sum;
    }
}

// TC -> O(E log V)
// SC -> O(V + E)