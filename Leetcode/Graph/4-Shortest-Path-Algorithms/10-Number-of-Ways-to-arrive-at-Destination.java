
class Solution {

    class pair implements Comparable<pair> {

        long dist; // Changed to long
        int node;

        public pair(long dist, int node) { 
            this.dist = dist;
            this.node = node;
        }

        public int compareTo(pair other) {
            return Long.compare(this.dist, other.dist); // Using Long.compare for comparison
        }
    }

    public int countPaths(int n, int[][] roads) {

        ArrayList<ArrayList<pair>> adj = new ArrayList<>(); // Creating an -> adjacency list

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int m = roads.length;

        for (int i = 0; i < m; i++) {
            adj.get(roads[i][0]).add(new pair(roads[i][2], roads[i][1]));
            adj.get(roads[i][1]).add(new pair(roads[i][2], roads[i][0]));
        }

        PriorityQueue<pair> minHeap = new PriorityQueue<>();

        long[] dist = new long[n]; // Changed to long
        int[] ways = new int[n];

        Arrays.fill(dist, Long.MAX_VALUE); // Changed to Long.MAX_VALUE
        Arrays.fill(ways, 0);

        dist[0] = 0;
        ways[0] = 1;

        minHeap.add(new pair(0, 0));

        // Define modulo value
        int mod = (int) (1e9 + 7);

        while (!minHeap.isEmpty()) {
            
            pair current = minHeap.poll();

            long dis = current.dist; // Using long for distance
            int node = current.node;

            for (pair it : adj.get(node)) {

                int adjNode = it.node;
                long edW = it.dist;

                // This ‘if’ condition signifies that this is the first time we’re coming with
                // this short distance,
                // so we push in minHeap and keep the no. of ways the same.
                if (dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;
                    minHeap.add(new pair(dis + edW, adjNode));
                    ways[adjNode] = ways[node];
                }

                else if (dis + edW == dist[adjNode]) {
                    // If we again encounter a node with the same short distance as before,
                    // we simply increment the no. of ways.
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        // we return -> the no. of ways -> to reach (n-1)th node.
        return ways[n - 1] % mod;
    }
}

// TC -> O(N + E * log(N))
// SC -> O(N + E)
