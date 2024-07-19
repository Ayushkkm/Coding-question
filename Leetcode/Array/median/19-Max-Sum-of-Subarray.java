class Solution {

    public static long pairWithMaxSum(long arr[], long N) {
         
        // GFG

        long sum = 0;
        
        long maxSum = Long.MIN_VALUE ;
        
        // Sum of greatest -> element -> with -> its adjacent -> answer
        
        for(int i = 1 ; i < arr.length ; i++){
            
            sum = arr[i-1] + arr[i];
            
            maxSum = Math.max(maxSum , sum);
            
        }
        
        return maxSum;
        
      
    }
}