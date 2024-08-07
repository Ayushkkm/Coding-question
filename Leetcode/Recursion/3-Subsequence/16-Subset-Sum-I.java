class Solution {
    
    void recursion(int i , int sum , ArrayList<Integer> arr, int n , 
    ArrayList<Integer> list){
        
        if(i==n){
            list.add(sum);
            return ;
        }
        
        // pick
        
        recursion(i+1 , sum + arr.get(i) , arr , n , list);
        
        // Not pick
        
        recursion(i+1 , sum , arr , n , list);
    }
    
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        
        ArrayList<Integer> list = new ArrayList<>();
        
        recursion(0 , 0 , arr , n , list);
        
        Collections.sort(list);
        
        return list;
        
    }
}

// TC -> O(2^n + 2^n*log(2^n))
// SC -> O(n)