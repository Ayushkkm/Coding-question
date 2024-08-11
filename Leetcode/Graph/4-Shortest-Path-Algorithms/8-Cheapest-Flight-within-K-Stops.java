class Solution {

    class pair {
        int first;
        int second;

        public pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    class tuple {

        int stop;
        int node;
        int dist;

        tuple(int first, int second, int third) {
            this.stop = first;
            this.node = second;
            this.dist = third;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        // Creating adjacency list
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int m = flights.length;

        for (int i = 0; i < m; i++) {
            adj.get(flights[i][0]).add(new pair(flights[i][1], flights[i][2]));
        }

        Queue<tuple> q = new LinkedList<>();

        int[] dist = new int[n];

        for (int i = 0; i < n; i++) {
            dist[i] = (int) (1e9);
        }

        q.add(new tuple(0, src, 0));

        dist[src] = 0;

        while (!q.isEmpty()) {

            tuple t = q.peek();
            q.remove();

            int stops = t.stop;
            int node = t.node;
            int cost = t.dist;

            if (stops > k) continue;

            for (pair p : adj.get(node)) {
                int adjNode = p.first;
                int edW = p.second;

                if (cost + edW < dist[adjNode] && stops <= k) {
                    dist[adjNode] = cost + edW;
                    q.add(new tuple(stops + 1, adjNode, cost + edW));
                }
            }
        }

        if (dist[dst] == (int) (1e9)) return -1;

        return dist[dst];
    }
    
}

// TC -> O(E * log(V))
// SC -> O(V + E)
