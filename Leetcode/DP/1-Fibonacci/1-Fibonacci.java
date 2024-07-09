class Solution {
    
    static long memoi(int n , long dp[] , long mod ){
        
        if(n<=1){
            return n;
        }
        
        if(dp[n] != -1){
            return dp[n];
        }
        
        dp[n] = (memoi(n-1 , dp , mod) + memoi(n-2 , dp , mod)) % mod;
        
        return dp[n];
    }
    // Memoisation
    
    static long topDown(int n) {
        
        long dp[] = new long[n+1];
        Arrays.fill(dp,-1);
    
        long mod = (long)Math.pow(10,9) + 7;
        
        return memoi(n , dp , mod);
    }
    
    // Tabulation
    
    static long bottomUp(int n) {
        
        long dp[] = new long[n+1];
        
        dp[0] = 0;
        dp[1] = 1;
        
        long mod = (long)Math.pow(10,9) + 7; // it -> increase -> complexity -> use mod = 1000000007
        
        for(int i = 2 ; i<=n ; i++){
            
            dp[i] = (dp[i-1]  + dp[i-2]) % mod ; 
        }
        
        return dp[n];
    }
}

// TC -> O(N)
// SC -> O(N)

//  Optimal solution

class Solution {
    
   
    static long Optimal(int n) {
        
        long prev2 = 0 ;
        long prev1 = 1;

        long mod = 1000000007;

        if(n<=1){
            return n; // if n = 0 -> prev2 -> has to return
        }

        for(int i = 2; i<=n ; i++){
            long curr = (prev1 + prev2) % mod;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;

    }
}