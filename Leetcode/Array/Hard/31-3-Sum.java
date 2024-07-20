class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) { // nums[i] != nums[i-1] -> continue 
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum > 0) {
                    right--;
                } 
                else if (sum < 0) {
                    left++;
                } 
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(list);

                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) { // change value -> of left
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) { // change value -> of right
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}

// TC -> O(N^2) + (NlogN)
// SC -> O(1)


// Using Set 

// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
        
//        int n = nums.length ;

//        if(n < 3) {
//          return new ArrayList<>(); // double empty list
//        }

//        Arrays.sort(nums);

//        Set<List<Integer>> set = new HashSet<>();

//        // take 1 element i= 0 -> take 2 element -> from i =1 -> tottal 3 element need -> till n-3

//        for(int i = 0 ; i< n -2 ; i++){
         
//           int left = i+1 ;

//           int right = n-1;

//           while(left < right){

//             int sum = nums[i] + nums[left] + nums[right] ;

//             if(sum ==0){
//                 set.add(Arrays.asList(nums[i] , nums[left] , nums[right]));

//                 left++; // to check -> more answer
//                 right--;
//             }

//             else if(sum < 0){
//                 left++;
//             }
//             else if( sum > 0){
//                 right--;
//             }
//           }

//        }

//        return new ArrayList<>(set);

//     }
// }

// TC -> O(N^2)
// SC -> O(N^2) -> for set