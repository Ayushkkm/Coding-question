class Solution {

    public int solve(int i , int dp[]){
     
      if(i<=2){
         return i;
      }

      if(dp[i]!= -1){
        return dp[i];
      }

      dp[i] = solve(i-1 , dp) + solve(i-2 , dp);

      return dp[i];
      
    }

    public int climbStairs(int n) {
        
        int dp[] = new int[n+1];

        Arrays.fill(dp,-1);

        return solve(n , dp);

    }
}
// TC -> O(N)
// SC -> O(N) + O(N)

// Better

class Solution {

    
    public int climbStairs(int n) {
        
        int dp[] = new int[n+1];

        Arrays.fill(dp,-1);

        dp[0] = 1;
        dp[1] = 1;
        

        for(int i = 2 ; i<=n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];

    }
}

// TC -> O(N)
// SC -> O(N)

// Optimal

class Solution {

    
    public int climbStairs(int n) {
        
        
        int prev2 = 1;
        int prev1 = 1;
        

        for(int i = 2 ; i<=n ; i++){
            int curr = prev1 + prev2;

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;

    }
}

// TC -> O(N)
// SC -> O(1)



