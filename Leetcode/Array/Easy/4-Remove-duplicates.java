class Solution {
    public int removeDuplicates(int[] nums) {
        // using quick sort space making strategy by 2 pointer
        
        int l = 0 ;
        int r = l+1;
        int n = nums.length;

        while(r<n){
            if(l<n && r <n && nums[l]==nums[r]){
                r++;
            }
            if(l<n && r <n && nums[l]!=nums[r]){
                ++l;
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
                r++;
            }
        }
        return l+1; // l is index , so +1
    }
    
}