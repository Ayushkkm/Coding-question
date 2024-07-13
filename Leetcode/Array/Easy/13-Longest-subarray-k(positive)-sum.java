class Solution {
    public int subarraySum(int[] nums, int k) {
       
       // if nums -> contains -> +ve
       int n = nums.length;

       int l = 0;
       int r = 0;

       int sum = 0;
      
       int maxLen = 0;

       while(r<n){
        sum += nums[r];
        
        while( l<r && sum>k){
            sum -= nums[l];
            l++;
        }

        if(sum==k){
            maxLen = Math.max(maxLen , r - l +1);
        }

        r++;

       }

       return maxLen;

       
    }
}
