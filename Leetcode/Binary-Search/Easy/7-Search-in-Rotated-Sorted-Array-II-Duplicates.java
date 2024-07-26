class Solution {
    public boolean search(int[] nums, int target) {
        
        int n = nums.length;

        int start = 0;
        int end = n-1;

        while(start <= end){

            int mid = start + (end-start)/2;

            if(nums[mid] == target){
                return true;
            }

            if(nums[mid] == nums[start] && nums[mid] == nums[end]){ // reduce -> search space
                start++;
                end--;

                continue;
            }

            // left sorted 

            if(nums[start] <= nums[mid]){

                if(nums[start] <= target && target <= nums[mid]){ // left part has -> target
                     
                     end = mid -1;
                }
                else{ // target -> is not -> in left part
                    start = mid+1;
                }
            }

            else{ // right part -> is sorted
                
                if(nums[mid] <= target && target <= nums[end]){ // right part -> has target
                  start = mid+1;
                }

                else{
                    end = mid-1;
                }
            }
        }

        return false;
    }
}

// TC -> O(logN) -> in worst case -> O(N) -> if all elements are same
// SC -> O(1) -> constant space