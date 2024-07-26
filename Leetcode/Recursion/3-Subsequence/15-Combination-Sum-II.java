class Solution {

    public void recursion(int index , int arr[] , int target ,
    List<Integer> list , List<List<Integer>> ans){

        if(target == 0){

            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = index ; i < arr.length ; i++){

            if(i > index && arr[i-1] == arr[i]){ // i > index -> add -> first element (i == index)-> in every recursion
                 continue;
            } 
                
            if(arr[i] > target){ // target not -ve
                break;
            }

            list.add(arr[i]);
            
            recursion( i + 1 , arr , target - arr[i] , list , ans);
            
            list.remove(list.size()-1); // remove for -> other recursion -> of loop of index
            
        }
    }
   
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        Arrays.sort(candidates);

        recursion(0 , candidates , target , list , ans);

        return ans;

    }
}

// TC -> O(2^n)
// SC -> O(n)
