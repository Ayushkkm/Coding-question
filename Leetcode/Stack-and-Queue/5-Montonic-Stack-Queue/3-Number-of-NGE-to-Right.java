class Solution {
   public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
        
        // Stack<Integer> st = new Stack<>();
        
        int result[] = new int[queries];
        
        
        for(int i = 0 ; i < queries ; i++){
            
            int idx = indices[i]; // traverse indices -> to find -> greater -> of each -> element
            
            int count = 0; 
            
            // st.clear(); // clear stack -> for -> each iteration
            
            
            for(int j = idx+1 ; j < N ;j++){ // traverse -> arr -> from -> next index 
            
               
            //   while(!st.isEmpty() && st.peek() < arr[j]){ // if -> less or equal -> remove
            //       st.pop();
            //   }
               
               if(arr[j] > arr[idx]){
                   count++;
               }
               
            //   st.push(arr[j]);
               
               
            }
            
            result[i] = count;
        }
        
        return result;
    }
}

// TC -> O(N*Q) -> N -> length of array -> Q -> number of queries
// SC -> O(1)