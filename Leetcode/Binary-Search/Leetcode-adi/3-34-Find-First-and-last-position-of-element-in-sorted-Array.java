class Solution {

    public static int first_Occurrance(int arr[],int k){
        int start = 0 ;
        int end = arr.length-1;
        int ans = -1;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(arr[mid]==k){
                ans = mid;
                end = mid-1;
            }
            else if(arr[mid]>k){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }

        return ans;
    }

    public static int last_Occurrance(int arr[],int k){
        int start = 0 ;
        int end = arr.length-1;
        int ans = -1;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(arr[mid]==k){
                ans = mid;
                start = mid+1;
            }
            else if(arr[mid]>k){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }

        return ans;
    }

   public int[] searchRange(int[] nums, int target) {
        
        int a = first_Occurrance(nums,target);
        int b = last_Occurrance(nums,target);

        return new int[]{a,b};
        
    }
}