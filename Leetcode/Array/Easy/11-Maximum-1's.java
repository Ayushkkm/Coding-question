class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int max = 0;
        int count = 0;

        for(int i = 0 ; i < n ; i++){
            if(nums[i] == 1){
                count++;
                max = Math.max(max, count);
            }
            else{
                count = 0;
            }
        }
        return max;
    }
}

// Maximum Sum Array - 2 Solution

// class Solution {
//     public int maxSubArray(int[] nums) {
        
//         int n = nums.length;

//         int sum = 0;

//         int maxSum = Integer.MIN_VALUE;

//         for(int i = 0 ; i < n ; i++){

//             sum += nums[i];

//             maxSum = Math.max(maxSum , sum);

//             if(sum<0){
//                 sum = 0 ;
//             }
//         }


//         return maxSum;
//     }
// }

// class Solution {
//     public int maxSubArray(int[] nums) {
    
//     int currSum = 0;
//     int maxSum = nums[0];

//     for(int i = 0 ; i<nums.length ; i++){
//        if(currSum<0) currSum = 0;

//        currSum = currSum + nums[i];
//        maxSum = Math.max(maxSum,currSum);
//      }

//     return maxSum;

//   }
// }