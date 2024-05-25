class Solution {
    public void moveZeroes(int[] nums) {
        // put all non-zero first , then zeroes

        int insert = 0 ;

        for(int i = 0 ;i <nums.length ; i++){
            if(nums[i]!=0){
                nums[insert++] = nums[i];
            }
        }

        while(insert<nums.length){
            nums[insert++] = 0;
        }
    }
}

// working code 
// with 2 pointer 
// class Solution {
//     public void moveZeroes(int[] nums) {
         
//         int n = nums.length; 
//         int l = 0 ; 
//         int r = l+1;;

//        while(r<n){
//         if(l<n && r< n && nums[l]==0 && nums[r]==0){
//             r++;
//         }
//         else if(l<n && r< n && nums[l]!=0 && nums[r]!=0){
//             l++;
//             r++;
//         }
//         else if(l<n && r< n && nums[r]!=0){
//             int temp = nums[l];
//             nums[l] = nums[r];
//             nums[r] = temp;
//             r++;
//             l++;
//         }
//         else if(l<n && r< n && nums[l]!=0 && nums[r]==0){
           
//             r++;
//             l++;
//         }
        
//        }
//     }
// }