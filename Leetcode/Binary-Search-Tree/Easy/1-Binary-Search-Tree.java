class Solution {
    static boolean isBSTTraversal(int arr[]) {
        
        int n = arr.length;
        
        for(int i = 1 ; i< n ; i++){
            if(arr[i]<=arr[i-1]){
                return false;
            }
        }
        
        return true;
    }
}

// TC -> O(N)
// SC -> O(1)