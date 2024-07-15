class Solution {
    public void sortColors(int[] nums) {
        
        int n = nums.length ;
        int arr[] = new int[n];

        for(int i = 0 ; i < n ; i++){
            arr[i] = nums[i];
        }
        
        
        int j = 0 ;
        for(int i = 0 ; i < n ; i++){
            if(arr[i]==0){
               nums[j++] = 0;
            }
        }

        for(int i = 0 ; i < n ; i++){
            if(arr[i]==1){
               nums[j++] = 1;
            }
        }

        for(int i = 0 ; i < n ; i++){
            if(arr[i]==2){
               nums[j++] = 2;
            }
        }

    }
}

// TC -> O(4N)
// SC -> O(N)


class Solution {
     public static void sortColors(int[] nums) {
      int col0 =0;
        int col1 =0;
        int col2 =0;

        for(int i =0; i< nums.length ; i++){
            if(nums[i]==0){ col0++ ;}
            else if(nums[i]==1) col1++ ;
            else col2++ ;
        }
        
        for(int i = 0 ; i<col0;i++ ){
            nums[i] =0 ;
        }
        for(int i = col0 ; i<col0 + col1;i++ ){
           nums[i] = 1;
        }
        for(int i = col0 + col1 ; i< nums.length ;i++ ){
           nums[i]=2;
        }
      
    }
    
}

// TC -> O(4N)
// SC -> O(1)