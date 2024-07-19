class Solution {
    
    static ArrayList<Integer> leaders(int n, int arr[]) {
        
        // GFG

        ArrayList<Integer> list = new ArrayList<>();
        
        
        list.add(arr[n-1]); // rightmost -> leader
        
        int max = arr[n-1];
        
        
        for(int i = n -2 ; i >=0 ; i--){
            
            if(arr[i] >= max){
                max = arr[i];
                
                list.add(arr[i]);
            }
            
        }
        
        // We are going -> right to left -> need to store left to right -> left most is maximum -> in list -> goes decending order
        
         Collections.sort(list , Collections.reverseOrder());
         
         return list;
    }
}

// TC -> O(N)
// SC -> O(N)