class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        int n = nums.length ;

        if(n == 1){
            return nums[0];
        }

        int start = 0;
        int end = n-1;

        while(start <= end){

            int mid = start + (end-start)/2;

            if(mid-1 >=0 && mid+1<n && nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                return nums[mid];  // condition -> mid -> not equal to prev -> and next
            }

            // Check distortion -> and move left -> or right

            if(mid % 2 == 0 && mid+1<n && nums[mid]== nums[mid+1] || 
               mid % 2 != 0 && mid-1>=0 && nums[mid] == nums[mid-1]){ // move right
                 start = mid+1;
            }
            else{ // move left
                end = mid - 1;
            }
        }

        return nums[start];
    }
}

// TC -> O(logN)
// SC -> O(1)