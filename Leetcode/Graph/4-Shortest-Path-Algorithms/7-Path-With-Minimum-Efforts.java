class Solution {

    class tuple implements Comparable<tuple> {

        int diff;
        int row;
        int col;

        public tuple(int diff, int row, int col) {

            this.diff = diff;
            this.row = row;
            this.col = col;

        }

        public int compareTo(tuple other) {

            return Integer.compare(this.diff, other.diff);
        }
    }

    public int minimumEffortPath(int[][] heights) {

        PriorityQueue<tuple> minHeap = new PriorityQueue<>();

        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = (int) (1e9);
            }
        }

        dist[0][0] = 0;

        minHeap.add(new tuple(0, 0, 0));

        int dr[] = { -1, 0, 1, 0 };
        int dc[] = { 0, 1, 0, -1 };

        while (!minHeap.isEmpty()) {

            tuple t = minHeap.remove();

            int diff = t.diff;
            int row = t.row;
            int col = t.col;

            if (row == n - 1 && col == m - 1)
                return diff; // if we reached -> destination -> return

            for (int i = 0; i < 4; i++) {

                int newr = row + dr[i];
                int newc = col + dc[i];

                if (newr >= 0 && newc >= 0 && newr < n && newc < m) {

                    int newEffort = Math.max(diff, Math.abs(heights[row][col] - heights[newr][newc]));

                    if (newEffort < dist[newr][newc]) {

                        dist[newr][newc] = newEffort;

                        minHeap.add(new tuple(newEffort, newr, newc));
                    }
                }
            }
        }

        return 0;

    }
}

// TC -> ElogV -> N*M*4 * log(N*M)
// SC -> O(N*M)