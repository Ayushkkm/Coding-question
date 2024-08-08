class Solution {

    public void recursion(int ind , int nums[] , List<Integer> list , 
    List<List<Integer>> ans ){

        ans.add(new ArrayList<>(list)); // To find -> all subset -> not go -> i == n

        for(int i = ind ; i < nums.length ; i++){

            if(i != ind && nums[i-1] == nums[i]){ // avoid -> duplicates
                continue; 
            }

            list.add(nums[i]);

            recursion(i+1 , nums , list , ans);

            list.remove(list.size()-1);
        }
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        recursion(0 , nums , new ArrayList<>() , ans);

        return ans;


    }
}

// TC -> O(2^n * n) -> n -> for ans.add(list)
// SC -> O(n) -> recursion stack