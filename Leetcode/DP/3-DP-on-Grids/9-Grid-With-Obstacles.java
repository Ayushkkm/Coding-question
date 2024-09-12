
// Memoization

class Solution {
    
    public int recursion(int i, int j, int[][] obstacleGrid, int[][] dp) {
       
        if(i>=0 && j>=0 && obstacleGrid[i][j] == 1){
            return 0;
        }
        
        if (i == 0 && j == 0) {
            return 1;
        }

        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int up = recursion(i - 1, j, obstacleGrid, dp);
        int left = recursion(i, j - 1, obstacleGrid, dp);

        dp[i][j] = up + left;
        return dp[i][j];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return recursion(m - 1, n - 1, obstacleGrid, dp);
    }
}

// TC -> O(N*M)
// SC -> O(N*M) + O(N+M) -> Stack

// Tabulation

class Solution {
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int dp[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }
                else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } 
                else {
                    int up = 0;
                    int left = 0;

                    if (i > 0) {
                        up = dp[i - 1][j];
                    }

                    if (j > 0) {
                        left = dp[i][j - 1];
                    }

                    dp[i][j] = up + left;
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}

// TC -> O(N*M)
// SC -> O(N*M) 

// Space Optimization

class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
       
        int prev[] = new int[n];

        for (int i = 0; i < m; i++) {
            
            int curr[] = new int[n];

            for (int j = 0; j < n; j++) {

                if(obstacleGrid[i][j] == 1){
                    curr[j] = 0;
                }

                if (i == 0 && j == 0) {
                    curr[j] = 1;
                } 
                else {
                    
                    int up = 0;
                    int left = 0;

                    if (i > 0) {
                        up = prev[j]; 
                    }
                    if (j > 0) {
                        left = curr[j - 1]; 
                    }

                    curr[j] = up + left;
                }
            }

            prev = curr;
        }

        return prev[n - 1];
    }
}

// TC -> O(N*M)
// SC -> O(N) 

