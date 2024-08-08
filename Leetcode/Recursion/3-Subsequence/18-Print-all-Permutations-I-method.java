class Solution {
    
    public void recursion(int nums[] , List<Integer> list, boolean freq[] ,
    List<List<Integer>> ans ){

        if(list.size() == nums.length){
            ans.add(new ArrayList<>(list));
        }

        for(int i = 0 ; i < nums.length ; i++){
           
            if(freq[i] == false){ // only -> unmark -> add

                list.add(nums[i]);
                freq[i] = true;

                recursion(nums , list , freq , ans);
                
                list.remove(list.size() - 1); // remove ->  and -> unmark
                freq[i] = false;

            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        boolean freq[] = new boolean[nums.length];

        recursion(nums , list , freq , ans);

        return ans;

    }
}

// TC -> O(n! * n) -> n -> loop
// SC -> O(n) + O(n) -> recursion stack + freq