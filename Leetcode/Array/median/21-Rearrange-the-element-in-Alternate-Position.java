
class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        int n = nums.length;

        int idx1 = 0; // even index -> for positive element

        int idx2 = 1; // odd index -> for negative element

        int ans[] = new int[n];
               
        for(int i = 0 ; i < n ; i++){

            if(nums[i] >=0){

                ans[idx1] = nums[i] ;

                idx1 = idx1 + 2; // increase by 2 -> 0 -> 2 -> 4 

            }
            else{
                ans[idx2] = nums[i] ;

                idx2 = idx2 + 2;
            }
        }

        return ans;

    }
}

// TC -> O(N)
// SC -> O(1)