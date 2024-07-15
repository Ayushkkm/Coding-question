class Solution {
    public int majorityElement(int[] nums) {

        int major = nums[0];
        int count = 1 ;

        for(int i = 1 ; i < nums.length ; i++){
            if(major == nums[i]){ // 
                count++;
            }
            else{ // decrease
              count--;
            }

            if(count==0){ // now new -> element - in majority
               major = nums[i];
               count++;
            }

        }

        return major;

    }
}

// TC -> O(N)
// SC -> O(1)

// By using Map -> 29% beat

// class Solution {
//     public int majorityElement(int[] nums) {
     
//       int n = nums.length;

//       Map<Integer , Integer> map = new HashMap<>(); // <element , frequency>

//       for(int i = 0 ; i < n ; i++){
         
//          map.put(nums[i] , map.getOrDefault(nums[i], 0) + 1);
//       }

//       int num = -1;

//       for(int i = 0 ; i <n ; i++){
//          if(map.get(nums[i]) > n/2){
//             num = nums[i];
//          }
//       }

//       return num;

//     }
// }