
class Solution {

    class Tuple {
        int first;
        int second;
        int third;

        Tuple(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        // If the start or end is blocked, return -1 immediately
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }

        // Handle the edge case where the grid is 1x1 and the only cell is open (0)
        if (n == 1) {
            return 1; // The start and end are the same
        }

        Queue<Tuple> q = new LinkedList<>();
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = (int) (1e9);
            }
        }

        dist[0][0] = 1; // Start from the top-left corner
        q.add(new Tuple(1, 0, 0));

        while (!q.isEmpty()) {

            Tuple t = q.remove();

            int dis = t.first;
            int r = t.second;
            int c = t.third;

            // Nested loops for 8-directional movement
            for (int dRow = -1; dRow <= 1; dRow++) {
                for (int dCol = -1; dCol <= 1; dCol++) {

                    // Skip the iteration where both dRow and dCol are 0 (i.e., no movement)
                    if (dRow == 0 && dCol == 0) continue;

                    int nrow = r + dRow;
                    int ncol = c + dCol;

                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n 
                        && grid[nrow][ncol] == 0 && dis + 1 < dist[nrow][ncol]) {

                        dist[nrow][ncol] = 1 + dis; // Update the distance

                        if (nrow == n - 1 && ncol == n - 1) {
                            return dist[nrow][ncol];
                        }

                        q.add(new Tuple(dist[nrow][ncol], nrow, ncol));
                    }
                }
            }
        }

        return -1; // Return -1 if no path is found
    }
}

// TC -> O(N^2)
// SC -> O(N^2)