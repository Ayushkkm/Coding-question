
class Solution {
    public int subarraySum(int[] nums, int k) {
       
        int sum = 0;
        int n = nums.length;
        int count = 0 ;
        
        Map<Integer,Integer> presum = new HashMap<Integer, Integer>(); // (sum,frequency) 
        
        presum.put(0,1); // if summ==k -> rem = 0 -> presum.get(sum) -> null pointer exception

        for(int i = 0 ; i< n ; i++){
            
            //calculate the prefix sum till index i:
            sum += nums[i];
                                 
            // calculate the sum of remaining part i.e. x-k:
            int rem = sum - k;
            
            //Calculate the length and update maxLen:
            if(presum.containsKey(rem)){
                 count += presum.get(rem);
            }
            
            presum.put(sum, presum.getOrDefault(sum,0)+1);
            
        }
        
        return count;
    }
    
}

// TC -> O(N*log(N)) -> log(N) for -> map search
// SC -> O(N)

// This is the ultimate code for -> subarray sum with k (count) -> include all -> 0's , +ve , -ve case
