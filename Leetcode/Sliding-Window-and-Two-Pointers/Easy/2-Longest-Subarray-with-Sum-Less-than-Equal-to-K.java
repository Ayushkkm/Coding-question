
// Brute force - > Generate all subarray

public class Solution {

    public int longestSubarrayWithSumLEQK(int[] arr, int k) {

        int maxlen = Integer.MIN_VALUE;

        for(int i = 0 ; i < arr.length ; i++){
             
             int sum = 0 ;
            
             for(int j = i ; j < arr.length ; j++){

                sum = sum + arr[j];

                if(sum<=k){
                    maxLen = Math.max(maxLen , j - i +1); // j - i + 1 -> length
                }
                else{
                    break;
                }
             }


        }

        return maxLen ;
    
    }
}

// TC -> O(N^2)
// SC -> O(1)

// Better solution -> l , r , while(expand) , while(shrink)

public class Solution {

    public int longestSubarrayWithSumLEQK(int[] arr, int k) {

        int l = 0 ;
        int r = 0 ;

        int sum = 0;
        int maxLen = 0;

        while(r<n){

            sum = sum + arr[r];
  
           // if sum is greater than k -> shrink the window from the left
            while(sum>k){
                sum = sum - arr[l];
                l++;
            }

            if(sum<=k){
                maxLen = Math.max(maxLen , r-l+1);
            }

            r++;
        }

        return maxLen;

    }
}

// TC -> O(N) + O(N)
// SC -> O(1);

// Find subarray also

public class Solution {

    public int[] longestSubarrayWithSumLEQK(int[] arr, int k) {

        int l = 0 ;
        int r = 0 ;

        int sum = 0;
        int maxLen = 0;

        int start = -1;
        int end = -1 ;

        while(r<n){

            sum = sum + arr[r];
  
           // if sum is greater than k -> shrink the window from the left
            while(sum>k){
                sum = sum - arr[l];
                l++;
            }

            if(sum<=k){
                maxLen = Math.max(maxLen , r-l+1);
                sum = l;
                end = r;
            }

            r++;
        }

        if(start ==-1){ // subarray not found
          return new int[0];
        }

        int ans[] = new int[end-start+1];

        for(int i = start ; i< end; i++){
              ans[i-start] = arr[i];
        }

        return ans;

    }
}

// Optimal

public class Solution {

    public int longestSubarrayWithSumLEQK(int[] arr, int k) {

        int l = 0 ;
        int r = 0 ;

        int sum = 0;
        int maxLen = 0;

        while(r<n){

            sum = sum + arr[r];
  
           // Only -> if change -> only 1 time shrink -> keep length -> near maxLen
            if(sum>k){ 
                sum = sum - arr[l];
                l++;
            }

            if(sum<=k){
                maxLen = Math.max(maxLen , r-l+1);
            }

            r++;
        }

        return maxLen;

    }
}

