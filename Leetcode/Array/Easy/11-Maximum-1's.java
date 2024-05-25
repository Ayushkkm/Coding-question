class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int curr = 0 ;

        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i]!=1) {
              curr = 0;
        }else{
            curr++;
            max = Math.max(max,curr);
        } 

        }
        return max;
    }
}