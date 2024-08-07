class Solution {
    
    public boolean check(int div , int arr[] , int threshold){
       
       int sum = 0;

       for(int i = 0 ; i < arr.length ; i++){
         
         sum += (arr[i] + div - 1) / div; // Correct ceiling division
       }

       if(sum <= threshold){

        return true;
        
       }

       return false;

    }

    public int smallestDivisor(int[] nums, int threshold) {
         
        int start = 1;

        int end = Integer.MIN_VALUE;

        for(int i = 0 ; i < nums.length ; i++){

            end = Math.max(end , nums[i]);
        } 

        int ans = -1;

        while(start <= end){

            int mid = start + (end-start)/2;

            if(check(mid , nums , threshold)==true){ // if true -> move left -> all big number -> give answer
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }

        return ans;
    }
}

// TC -> O(N*log(max(arr)))
// SC -> O(1)