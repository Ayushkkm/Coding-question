class Solution {
    public boolean canJump(int[] nums) {
        
        int maxIdx = 0; // max index -> we can reach

        for(int i = 0 ; i< nums.length ; i++){
            if(i>maxIdx){
                return false; // maxIdx is less -> we can't reach index i
            }

            maxIdx = Math.max(maxIdx,i+nums[i]); // ith index -> ans max jump -> reach index -> i+nums[i]

            if(maxIdx>=nums.length-1){
                return true; // already reach 
            }
        }

        return true;

    }

    // TC -> O(N)

}