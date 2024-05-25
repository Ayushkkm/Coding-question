class Solution {
    public int subarraySum(int[] nums, int k) {
       int count = 0 ;
       int l = 0;
       int r = 0;
       int sum = nums[0];
       int n = nums.length;
      
       int maxL = 0;

       while(r<n){

       while(l<r && sum>k){
        sum -= nums[l];
        l++;
       }

       if(sum==k){
        count++;
        maxL = Math.max(maxL , r-l+1);
       }

        r++;
        if(r<n) sum += nums[r];

       }

       return count ;

    }
}