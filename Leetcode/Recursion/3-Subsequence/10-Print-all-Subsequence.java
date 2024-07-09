class Solution {

    public void print(int index , int n ,List<List<Integer>> list ,
     int nums[] , List<Integer> warp){

       if(index >= n){
         list.add(new ArrayList<>(warp)); // Create a new list -> and add it to the final list -> if list.add(warp) -> all warp are same in this list -> warp point -> to single -> list 
         return ;
       }

       // take
       warp.add(nums[index]);
       print(index+1, n , list , nums , warp);

       // not take

       warp.remove(warp.size()-1);
       print(index+1, n , list , nums , warp);

     }

    public List<List<Integer>> subsets(int[] nums) {
        
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> warp = new ArrayList<>();

        print(0 , n , list , nums, warp);

        return list;

    }
}
// TC -> O(2^N)
// SC -> O(N) -> recursive stack