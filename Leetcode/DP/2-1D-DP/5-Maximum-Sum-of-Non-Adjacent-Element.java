
// Memoization

class Solution {

    public int memoization(int index , int nums[] , int dp[]){

        if(index == 0){
            return nums[0];
        }

        if(index < 0){
            return 0;
        }

        if(dp[index] != -1){
            return dp[index];
        }

        int pick = nums[index] + memoization(index -2 , nums , dp);

        int notPick = 0 + memoization(index-1 , nums , dp);

        return dp[index] = Math.max(pick , notPick);
    }

    public int rob(int[] nums) {
        
        int n = nums.length ;

        int dp[] = new int[n];

        Arrays.fill(dp , -1);

        return memoization(n-1 , nums , dp);

    }
}

// TC -> O(N)
// SC -> O(N) + O(N)

// Tabulation

class Solution {

    public int rob(int[] nums) {
        
        int n = nums.length ;

        int dp[] = new int[n];

        dp[0] = nums[0];

       
        for(int i = 1 ; i < n ; i++){

            int pick = nums[i] ;

             if(i>1){
                pick += dp[i-2];
            }

            int notPick = 0 + dp[i-1];

            dp[i] = Math.max(pick , notPick);
        }

        return dp[n-1];

    }
}

// TC -> O(N)
// SC -> O(N) 

// Space Optimization

class Solution {

    public int rob(int[] nums) {
        
        int n = nums.length ;

        int prev = nums[0];

        int prev2 = 0; 

       
        for(int i = 1 ; i < n ; i++){

            int pick = nums[i] ;

            if(i>1){
                pick += prev2;
            }

            int notPick = 0 + prev;

            int curr = Math.max(pick , notPick);

            prev2 = prev;
            prev = curr;
        }

        return prev;

    }
}

// TC -> O(N)
// SC -> O(1) 
