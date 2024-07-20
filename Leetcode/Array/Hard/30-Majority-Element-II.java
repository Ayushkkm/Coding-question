class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int n = nums.length ;
        
        List<Integer> list = new ArrayList<>();

        if(n<2){
             list.add(nums[0]) ;
             return list;
        }

        int first = 0;
        int second = 0; 

        int countF = 0;
        int countS = 0;

        for(int i = 0 ; i < n ; i++){
          
          if(countF == 0 & nums[i] != second){ // count = 0 -> and not equal to second -> our first majority -> find
             
             first = nums[i];
             countF++;
          } 

          else if(countS == 0 && nums[i] != first){ // count = 0 -> and not equal to first -> our second majority -> find
             
             second = nums[i];
             countS++;
          }

          else if(first == nums[i]){ // increase count
            
            countF++;
          }

          else if(second == nums[i]){ // increase count
           
             countS++;
          }

          else{  // nums[i] -> not equal to -> both -> negative both
            
            countF--;
            countS--;
          }
        
        }

        // first and second -> contain -> First and Second Majority -> of array

        int count1 = 0;
        int count2 = 0;

        for(int i = 0 ; i < n ; i++){
            if(first == nums[i]){
                count1++;
            }
            else if(second == nums[i]){
                count2++;
            }
        }
        
        if(count1 > n/3){
            list.add(first);
        }

        if(count2 > n/3){
            list.add(second);
        }

        return list;


    }
}

// TC -> O(N)
// SC -> O(1)
