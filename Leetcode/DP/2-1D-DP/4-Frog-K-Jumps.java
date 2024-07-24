
// Memoization

class Solution {
    
    public int Memoization(int index , int arr[] , int k , int dp[]){
        
        if(index == 0){
            return 0;
        }
        
        if(dp[index] != -1){
            return dp[index];
        }
        
        int minStep = Integer.MAX_VALUE;
        
        for(int i = 1 ; i <= k ; i++){
            
            if(index - i >= 0){
                
                int jump = Memoization(index - i , arr , k , dp) + Math.abs(arr[index] - arr[index - i]);
                
                minStep = Math.min(minStep , jump);
            }
        }
        
        return dp[index] = minStep;
    }
    
    public int minimizeCost(int arr[], int N, int K) {
       
       int dp[] = new int[N+1];
       
       Arrays.fill(dp , -1);
       
       return Memoization(N-1 , arr , K ,dp);
    }
}

// TC -> O(N*K)
// SC -> O(N) + O(N)


// Tabulation

class Solution {

    public int minimizeCost(int arr[], int N, int K) {
       
       int dp[] = new int[N+1];
       
       Arrays.fill(dp , Integer.MAX_VALUE);
       
       dp[0] = 0;
       
       for(int i = 1 ; i < N ; i++){
           
           for(int j = 1 ; j <= K ; j++){
               
               if(i - j >= 0){
                   
                   dp[i] = Math.min(dp[i] , dp[i-j] + Math.abs(arr[i] - arr[i-j]));
               }
           }
       }
       
       return dp[N-1];
    }
}

// TC -> O(N*K)
// SC -> O(N) 
