
// Memoization

class Solution{
    
    public int memoization(int i , int arr[] , int dp[]){
        if(i==0){
            return 0 ; // from 0 -> to 0 > no energy
        }
        
        if(dp[i] != -1){
            return dp[i];
        }
        
        
        int left = memoization(i-1 , arr , dp) + Math.abs(arr[i]-arr[i-1]);
        
        int right = Integer.MAX_VALUE;
        
        if(i > 1){ // check -> for 1 
        
            right = memoization(i-2 , arr , dp) + Math.abs(arr[i] - arr[i-2]);
        }
        
        return dp[i] = Math.min(left , right);
    }

    public int minimumEnergy(int arr[],int N){
        
        int dp[] = new int[N];
        
        Arrays.fill(dp , -1);
        
        return memoization(N-1 , arr , dp);
        
        
    }
}

// TC -> O(N)
// SC -> O(N) + O(N)

// Tabulation

class Solution{

    public int minimumEnergy(int arr[],int N){
        
        int dp[] = new int[N];
        
        Arrays.fill(dp , -1);
        
        dp[0] = 0;

        for(int i = 1 ; i < N ; i++){

            int left = dp[i-1] + Math.abs(arr[i]-arr[i-1]);

            int right = Integer.MAX_VALUE;

            if(i>1){
                right = dp[i-2] + Math.abs(arr[i] - arr[i-2]);
            }

            dp[i] = Math.min(left , right);
        }

        return dp[N-1];
        
    }
}

// TC -> O(N)
// SC -> O(N) 

// Space Optimization

class Solution{

    public int minimumEnergy(int arr[],int N){
        
        int prev2 = 0;
        int prev1 = 0;


        for(int i = 1 ; i < N ; i++){

            int left = prev1 + Math.abs(arr[i]-arr[i-1]);

            int right = Integer.MAX_VALUE;

            if(i>1){
                right = prev2 + Math.abs(arr[i] - arr[i-2]);
            }

            int curr = Math.min(left , right);

            prev2 = prev1 ;
            prev1 = curr;
        }

        return prev1;
        
    }
}

// TC -> O(N)
// SC -> O(1)
