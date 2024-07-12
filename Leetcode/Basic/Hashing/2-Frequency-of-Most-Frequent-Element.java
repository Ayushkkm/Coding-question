class Solution {
    public int maxFrequency(int[] nums, int k) {
        
       long n = nums.length;

        Arrays.sort(nums);

        int l = 0 ; 
        int r = 0 ;

        long totalSum = 0; // use 
        int maxFreq = 0;

        while(r<n){ // expand
           
           totalSum += nums[r];

           while((long)nums[r] * (r - l +1) > totalSum + k){ // shrink -> multiplication -> goes out of -> int limit
             totalSum -= nums[l];
             l++;
           }

           maxFreq = Math.max(maxFreq , r - l + 1);
           r++;
        }

        return maxFreq;
    }
}