class Solution {
    
    public void subsequence(int index , int arr[] , int target , int n ,
    List<List<Integer>> ans , List<Integer> list){

        if(index == n){

            if(target == 0){
                ans.add(new ArrayList<>(list));
            }
            return ;
        }

        // Take

        if(target >= arr[index]){ // target -> not get negative
         
         list.add(arr[index]);

         subsequence(index , arr , target - arr[index] , n , ans , list); // remain -> on same index
          
          list.remove(list.size() - 1) ; // remove -> for not take
        }

        // not take

        subsequence(index+1 , arr , target , n , ans , list);

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        int n = candidates.length;

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        subsequence(0 , candidates , target , n , ans , list);

        return ans;

    }
}

// TC -> O(2^N)
// SC -> O(N) 