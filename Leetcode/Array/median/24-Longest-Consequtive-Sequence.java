class Solution {

    public int giveLength(Map<Integer , Boolean> map , int value){

        int ans = 0;

        while(map.containsKey(value)){ // give -> length -> of consecutive -> have starting point value
           
           ans++;

           value++;
        }

        return ans;

    }

    public int longestConsecutive(int[] nums) {
        
        Map<Integer , Boolean> map = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++){ // put -> in map -> mark true -> true represent -> starting point
          
         map.put(nums[i] , true);

        }

        // if any -> has previous element -> in map -> mark false -> it is not starting point 

        for(int i = 0 ; i < nums.length ; i++){
            
            if(map.containsKey(nums[i] - 1)){ // 1 previous -> element present -> in map of curr element -> mark curr element false -> to get longest sequence
              
              map.put(nums[i], false);
            }
        }

        int maxL = 0;

        for(int i = 0 ; i< nums.length ; i++){

            if(map.get(nums[i]) == true){ // our starting point
      
              maxL = Math.max(maxL , giveLength(map , nums[i]));
            }
        }

        return maxL ;
    }
}

// TC -> O(N)
// SC -> O(N)