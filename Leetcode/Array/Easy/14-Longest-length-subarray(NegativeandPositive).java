
class Solution{
      
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int A[], int N, int K) {
        
        int maxL = 0 ;
        int sum = 0;
        
        Map<Integer,Integer> presum = new HashMap<Integer, Integer>();
        
        
        for(int i = 0 ; i< N; i++){
            
            //calculate the prefix sum till index i:
            sum += A[i];
            
            // if the sum = k, update the maxLen:
            if(sum==K){
                maxL = Math.max(maxL,i+1);
            }
            
            // calculate the sum of remaining part i.e. x-k:
            int rem = sum - K;
            
            //Calculate the length and update maxLen:
            if(presum.containsKey(rem)){  // k = 3 , arr = [0,3] -> not else if -> 0 we have to count at i = 1
                int len = i - presum.get(rem);
                
                maxL = Math.max(maxL,len);
            }
            
            //Finally, update the map checking the conditions: 
            if(!presum.containsKey(sum)){
                    presum.put(sum,i);
            }
            
        }
        
        return maxL;
    }
    
}

// TC -> O(N*log(N)) -> log(N) for -> map search
// SC -> O(N)

// This is the ultimate code for -> subarray sum with k (maxLen) -> include all -> 0's , +ve , -ve case
