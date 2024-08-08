class Solution {

    public void swap(int a , int b , int arr[]){
        
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void recursion( int index, int arr[] , List<List<Integer>> ans){
         
         if(index == arr.length){

            List<Integer> list = new ArrayList<>(); // to add -> in ans
            
            for(int i = 0 ; i < arr.length ; i++){
                list.add(arr[i]);
            }

            ans.add(new ArrayList<>(list));

         }

         for(int i = index ; i < arr.length ; i++){
             
            swap(index , i , arr); // swap -> i and index

            recursion( index +1 , arr , ans);

            swap(index , i , arr); // reswap -> to come -> to original -> position
         }

    }

    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();

        recursion(0 , nums , ans);

        return ans;

    }
}

// TC -> O(n! * n) -> n -> loop
// SC -> O(n) -> recursion stack
