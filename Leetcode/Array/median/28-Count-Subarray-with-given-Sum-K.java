
class Solution {
    public int subarraySum(int[] nums, int k) {
       
        int sum = 0;
        int n = nums.length;
        int count = 0 ;
        
        Map<Integer,Integer> presum = new HashMap<Integer, Integer>();
        
        presum.put(0,1); // if summ==k , presum.get(sum) -> null pointer exception

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

// TC -> O(N)
// SC -> O(N)
    

// class Solution {
//     public int subarraySum(int[] nums, int k) {
       
//        int n = nums.length;

//        int count = 0 ;
//        int l = 0;
//        int r = 0;

//        int sum = 0;
      
//        int maxLen = 0;

//        while(r<n){
//         sum += nums[r];
        
//         while( l<r && sum>k){
//             sum -= nums[l];
//             l++;
//         }

//         if(sum==k){
//             count++;
//             maxLen = Math.max(maxLen , r - l +1);
//         }

//         r++;

//        }

//        return count;

       
//     }
// }

//  TC -> O(n)
//  SC -> O(1)