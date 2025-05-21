class Solution {
    public int subarraySum(int[] nums, int k) {
       
       // if nums -> contains -> +ve
       int n = nums.length;

       int count = 0 ;
       int l = 0;
       int r = 0;

       int sum = 0;
      
       int maxLen = 0;

       while(r<n){
        sum += nums[r];
        
        while( l<r && sum>k){ // l < r -> important -> test fail -> if l == r -> and shrink
            sum -= nums[l];
            l++;
        }

        if(sum==k){
            count++;
            maxLen = Math.max(maxLen , r - l +1);
        }

        r++;

       }

       return count;

    }
}

// TC -> O(2n)
// SC -> O(1)