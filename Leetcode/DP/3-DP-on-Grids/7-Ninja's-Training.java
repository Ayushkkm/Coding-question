
// Memoization

class Solution {
    
    static int recursion(int day, int last, int[][] points, int[][] dp) {
        
        if (dp[day][last] != -1) return dp[day][last];

        
        if (day == 0) {
            int maxi = 0;
            for (int i = 0; i <= 2; i++) {
                if (i != last)
                    maxi = Math.max(maxi, points[0][i]);
            }
            return dp[day][last] = maxi; // Store and return the result
        }

        int maxi = 0;
       
        for (int i = 0; i <= 2; i++) {
            if (i != last) {
               
                int activity = points[day][i] + recursion(day - 1, i, points, dp);
                maxi = Math.max(maxi, activity); // Update the maximum points
            }
        }

        return dp[day][last] = maxi; 
    }


    public int maximumPoints(int arr[][], int N) {
        
        int dp[][] = new int[N][4];
        
        for (int[] row : dp){
            Arrays.fill(row, -1);
        }
        

        return recursion(N - 1, 3, arr, dp);
    }
}

// TC -> O(N*4*3)
// SC -> O(N*4) + O(N) -> Stack

// Tabulation

class Solution {
    public int maximumPoints(int arr[][], int N) {
        
        int[][] dp = new int[N][4];
        
        dp[0][0] = Math.max(arr[0][1], arr[0][2]); // Choosing activity 0 on day 0
        dp[0][1] = Math.max(arr[0][0], arr[0][2]); // Choosing activity 1 on day 0
        dp[0][2] = Math.max(arr[0][0], arr[0][1]); // Choosing activity 2 on day 0
        dp[0][3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2])); // No activity chosen before day 0

        for (int day = 1; day < N; day++) {
            for (int last = 0; last <= 3; last++) {
                dp[day][last] = 0; 

                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        
                        int activity = arr[day][task] + dp[day - 1][task];

                        dp[day][last] = Math.max(dp[day][last], activity); 
                    }
                }
            }
        }
        
        return dp[N - 1][3]; 
    }
}

// TC -> O(N*4*3)
// SC -> O(N*4)

// Space Optimization

class Solution {
    public int maximumPoints(int arr[][], int N) {
        
        int prev[] = new int[4];

        prev[0] = Math.max(arr[0][1], arr[0][2]);
        prev[1] = Math.max(arr[0][0], arr[0][2]);
        prev[2] = Math.max(arr[0][0], arr[0][1]);
        prev[3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2]));

        
        for (int day = 1; day < N; day++) {
            
            int temp[] = new int[4];
            
            for (int last = 0; last < 4; last++) {
                
                temp[last] = 0; 
                for (int task = 0; task <= 2; task++) {
                    
                    if (task != last) { 
                        
                        temp[last] = Math.max(temp[last], arr[day][task] + prev[task]);
                   
                    }
                }
            }
            
            prev = temp;
        }

        return prev[3];
    }
}

// TC -> O(N*4*3)
// SC -> O(4) + O(4) -> O(4)





