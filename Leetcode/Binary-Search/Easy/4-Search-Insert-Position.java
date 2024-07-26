class Solution {

     public static int floor(int arr[] , int k){
        int start = 0 ;
        int end = arr.length - 1;
        int ans =-1 ; // if -> all are greater than -> target -> no floor ->return -> ans(-1)+1 = 0 index 

        while(start<=end){

            int mid = start + (end-start)/2;

            if(arr[mid]==k){
                return mid;
            }
            else if(arr[mid]<k){  // k > arr[mid] -> chance of -> getting floor value -> now -> move to greater side
                ans = mid;
                start = mid+1;

            }
            else{
                end = mid-1;
            }
        }
        return ans+1 ; // ans -> give floor -> suitable idx for target -> ans+1

    }
    

    public int searchInsert(int[] nums, int target) {
        
        int idx = floor(nums,target);
        return idx;
    }
}

// TC -> O(logN)
// SC -> O(1)
