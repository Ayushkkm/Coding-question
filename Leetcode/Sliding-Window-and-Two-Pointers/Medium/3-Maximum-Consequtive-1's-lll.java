
// Brute force -> Generate all subarray

class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int n = nums.length;

        int zeroCount = 0 ;
        int maxLen = 0;

        for(int i = 0 ; i<n ; i++){
             int zeroCount = 0 ;

             for(int j = i ; j < n ; j++){
                
                if(nums[j]==0){
                    zeroCount++;
                }

                if(zeroCount<=k){
                    int len = j - i + 1;

                    maxLen = Math.max(maxLen , len);
                }
                else{
                    break;
                }
             }
        }

        return maxLen;
    }
}

// TC -> O(N^2)
// SC -> O(1)


// Better -> l , r -> expand -> shrink -> 2 while loop

class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int n = nums.length;

        int l = 0 ; 
        int r = 0 ;

        int zeroCount = 0 ;
        int maxLen = 0;

        while(r<n){ // expand
        
         if(nums[r]==0){ // 0 found -> increase 0 count
            zeroCount++; 
         }

           while(zeroCount > k){ // 0 -> greater than k -> shrink
           
           if(nums[l]==0){ // current l -> is 0 -> decrease 0 -> count
              zeroCount--;
           }

           l++; // shrink
         }

         if(zeroCount <= k){
            maxLen = Math.max(maxLen , r - l + 1);
         }

         r++; // expand
         
        }

        return maxLen;
    }
}

// TC -> O(2N)
// SC -> O(1)


// Optimal -> use if 

class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int n = nums.length;

        int l = 0 ; 
        int r = 0 ;

        int zeroCount = 0 ;
        int maxLen = 0;

        while(r<n){ // expand
        
         if(nums[r]==0){ // 0 found -> increase 0 count
            zeroCount++; 
         }

           if(zeroCount > k){ // 0 -> greater than k -> shrink -> only 1 time
           
           if(nums[l]==0){ // current l -> is 0 -> decrease 0 -> count
              zeroCount--;
           }

           l++; // shrink
         }

         if(zeroCount <= k){
            maxLen = Math.max(maxLen , r - l + 1);
         }

         r++; // expand
         
        }

        return maxLen;
    }


}

// TC -> O(N)
// SC -> O(1)

