class Solution {
   
    public int solve( int nums[] , int k){

        if(k < 0){
            return 0;
        }

        int n = nums.length;

        int l = 0;
        int r = 0;

        int count = 0;

        Map<Integer , Integer> map = new HashMap<>();

        while(r < n){
            
            map.put(nums[r] , map.getOrDefault(nums[r] , 0)+1);

            while(map.size() > k){

                map.put(nums[l] , map.get(nums[l]) - 1);

                if(map.get(nums[l])==0){
                    map.remove(nums[l]);
                }

                l++;
            }

            if(map.size()<=k){
                count = count + r-l+1;
            }

            r++;
        }

        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
         
         return solve(nums , k) - solve(nums , k-1);

    }
}

// TC -> O(2*2N) -> two time -> call -> solve
// SC -> O(N)