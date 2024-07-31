class Solution {
    
    public int solve(int nums[]  ,int goal){
       
       if(goal < 0){ // if goal -> -ve -> while(sum > goal) -> sum = +ve -> this run everytime -> l++ -> arrayOutofBond
        return 0;
       }

       int n = nums.length;

        int l = 0 ;
        int r = 0;

        int sum = 0;
        int count = 0;

        while(r<n){
            sum +=nums[r];

            while(sum > goal){
                sum -= nums[l];
                l++;
            }

            if(sum <= goal){
                count = count + r-l+1 ; // add length
            }

            r++;
        }

        return count;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        
        return solve(nums , goal) - solve(nums , goal-1);

    }
}

// TC -> O(2*2N) -> two time -> call -> solve
// SC -> O(1)
