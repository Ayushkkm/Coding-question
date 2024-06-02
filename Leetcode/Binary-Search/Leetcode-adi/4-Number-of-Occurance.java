class Solution {
    // GFG
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

    
    int count(int[] arr, int n, int x) {
        
        int first = first_Occurrance(arr,x);
        
        if(first==-1) return 0 ; // x not found
        
        int last = last_Occurrance(arr,x);
        return last-first+1;
    }
}