class Solution {

     public static int floor(int arr[] , int k){
        int start = 0 ;
        int end = arr.length - 1;
        int ans =0 ;

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
        return ans ;

    }
    

    public int searchInsert(int[] nums, int target) {
        
        int idx = floor(nums,target);
        return idx;
    }
}