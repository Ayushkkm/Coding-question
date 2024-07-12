
// Recursion

class Solution{
    
    public int subsequences(int i , int n , int sum , int k , int arr[] ,
    int mod ){
        
        if(i==n){
            if(sum==k) {
                return 1;
            }
            
            return 0;
        }
        
        int take = subsequences(i+1 , n , sum + arr[i] , k , arr , mod) % mod ;
        
        int nTake = subsequences(i+1 , n , sum , k , arr , mod) % mod ;
        
        return take + nTake;
        
    }

	public int perfectSum(int arr[] , int n, int sum){
	    
	    return subsequences(0 ,  n , 0 , sum , arr , 1000000007);
	    
	} 
}

// TC -> O(2^N)
// SC -> O(N)

// It give -> TLE

// DP Solution

class Solution {
    
    public int subsequences(int i , int sum , int n , int k , int arr[] , int mod, int dp[][]) {
        
        if (i == n) {
            if (sum == k) {
                return 1;
            }
            return 0;
        }
        
        if (dp[i][sum] != -1) {
            return dp[i][sum];
        }
        
       // Take the current element
        int take = 0;
        if (sum + arr[i] <= k) { // because -> sum + arr[i] -> exceed dp -> limit
            
            take = subsequences(i + 1, sum + arr[i], n, k, arr, mod, dp) % mod;
        }
        
        // Do not take the current element
        int nTake = subsequences(i + 1, sum, n, k, arr, mod, dp) % mod;
        
        return dp[i][sum] = (take + nTake) % mod;
    }

    public int perfectSum(int arr[], int n, int sum) {
        
        int mod = 1000000007;
        
        // Initialize dp array
        int dp[][] = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return subsequences(0, 0, n, sum, arr, mod, dp);
    }
}

// TC -> O(N*sum)
// SC -> O(N*sum)


