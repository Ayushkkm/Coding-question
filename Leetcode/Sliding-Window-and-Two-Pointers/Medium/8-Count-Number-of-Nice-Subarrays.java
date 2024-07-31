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
            sum += nums[r] % 2; // use -> moulo 2 -> for 0 and 1

            while(sum > goal){
                sum -= nums[l] % 2; // use -> moulo 2 -> for 0 and 1
                l++;
            }

            if(sum <= goal){
                count = count + r-l+1 ; // add length
            }

            r++;
        }

        return count;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        
        return solve(nums , k) - solve(nums , k-1);
    }
}

// TC -> O(2*2N) -> two time -> call -> solve
// SC -> O(1)   