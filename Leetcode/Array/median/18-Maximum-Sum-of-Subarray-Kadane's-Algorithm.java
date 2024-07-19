class Solution {
    public int maxSubArray(int[] nums) {
        
        int n = nums.length;

        int sum = 0;

        int maxSum = Integer.MIN_VALUE;

        for(int i = 0 ; i < n ; i++){

            sum += nums[i];

            maxSum = Math.max(maxSum , sum);

            if(sum<0){
                sum = 0 ;
            }
        }


        return maxSum;
    }
}

// TC -> O(N)
// SC -> O(1)

// Print Subarray

class Solution {
    public int maxSubArray(int[] nums) {
        
        int n = nums.length;

        int sum = 0;

        int maxSum = Integer.MIN_VALUE;

        int start = 0;
        int ansStart = 0;
        int ansEnd = 0;


        for(int i = 0 ; i < n ; i++){
            
            if(sum==0){
                start = i;
            }

            sum += nums[i];

            if(sum > maxSum){
                
                ansStart = start;
                ansEnd = end;
                maxSum = sum;
            }
            

            if(sum<0){
                sum = 0 ;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = ansStart ; i<= ansEnd ; i++){
            list.add(nums[i]);
        }

        return list;
        
    }
}

// TC -> O(N)
// SC -> O(1)
