class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        int n = arr.length;

        int start = 0;
        int end = n-1;

        while(start <= end){

            int mid = start + (end - start)/2 ;

            int missing = arr[mid] - (mid+1);

            if(missing < k){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }

        return end + 1 + k;
    }
}

// TC -> O(log(N))
// SC -> O(1)
