class Solution {

    static class Pair implements Comparable<Pair> {
        int distance;
        int node;

        public Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }

        public int compareTo(Pair other) {
            if (this.distance == other.distance) {
                return Integer.compare(this.node, other.node);
            } else {
                return Integer.compare(this.distance, other.distance);
            }
        }
    }

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        
        TreeSet<Pair> set = new TreeSet<>();
        
        int[] dis = new int[V];
        
        Arrays.fill(dis, Integer.MAX_VALUE);
        
        dis[S] = 0;
        set.add(new Pair(0, S));

        while (!set.isEmpty()) {
            
            Pair it = set.pollFirst(); // TreeSet -> use pollFirst -> retrive -> and remove simultanously -> remove only remove
            int currdist = it.distance;
            int node = it.node;

            for (ArrayList<Integer> a : adj.get(node)) {
               
                int adjnode = a.get(0);
                int weight = a.get(1);

                if (weight + currdist < dis[adjnode]) {
                    
                    set.remove(new Pair(dis[adjnode], adjnode)); // Remove the -> existing pair if it exists
                    
                    dis[adjnode] = weight + currdist;
                    set.add(new Pair(dis[adjnode], adjnode));
                }
            }
        }

        return dis;
    }
}

// TC -> O(VlogV + ElogV) -> O(ElogV)
// SC -> O(V) -> for storing distance of each node