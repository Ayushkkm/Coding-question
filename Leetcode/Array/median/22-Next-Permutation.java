class Solution {

    public void swap(int arr[] , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void reverse(int arr[] , int i , int j){

        while(i<=j){
            swap(arr , i++ , j--);
        }
    }

    public void nextPermutation(int[] nums) {
    
    int n = nums.length;

    int idx = -1;

    // Find index

    for(int i = n-2 ; i >=0 ; i--){
        
        if(nums[i] < nums[i+1]){
            idx = i;
            break;
        }
    }

    if(idx == -1){
        reverse(nums , 0 , n-1);
        return ;
    }

    // Find smallest element -> largest than -> arr[idx]

    for(int i = n-1; i >= idx ; i--){
        
        if(nums[i] > nums[idx]){
            swap(nums , i , idx);
            break;
        }
    }

    reverse(nums , idx+1 , n-1);
         
    }
}

// TC -> O(N)
// SC -> O(1)