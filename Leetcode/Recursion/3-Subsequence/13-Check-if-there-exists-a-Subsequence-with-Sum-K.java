
// Recursion

public class Solution {

    public static boolean subsequences(int i , int n , int sum , int k , int a[]){

        if(i==n){
            if(sum==k){
                return true;
            }
            return false;
        }
        
        //take

        if(subsequences(i+1 , n , sum + a[i] , k , a )==true){
            return true;
        }

        // not take

        if(subsequences(i+1 , n , sum , k , a)==true){
            return true;
        }

        return false;
    }
    
    public static boolean isSubsetPresent(int n, int k,int []a) {
        
        return subsequences(0 , n , 0 , k , a);
    }
}

// TC -> O(2^N)
// SC -> O(N)

// It give -> TLE

// DP Solution

public class Solution {

    public static boolean subsequences(int i, int n, int sum, int k, int[] a, Boolean[][] dp) {
        if (sum > k) {
            return false; // Early exit if sum exceeds k
        }

        if (i == n) {
            return sum == k;
        }

        if (dp[i][sum] != null) {
            return dp[i][sum];
        }

        // Take the current element
        boolean take = subsequences(i + 1, n, sum + a[i], k, a, dp);

        // Do not take the current element
        boolean nTake = subsequences(i + 1, n, sum, k, a, dp);

        dp[i][sum] = take || nTake;
        return dp[i][sum];
    }

    public static boolean isSubsetPresent(int n, int k, int[] a) {
        Boolean[][] dp = new Boolean[n + 1][k + 1];
        return subsequences(0, n, 0, k, a, dp);
    }
}

// TC -> O(N*K)
// SC -> O(N*K)
