class Solution {
    
    public int[] previousSmaller(int arr[]){
        
        int n = arr.length ;
        
        Stack<Integer> st = new Stack<>();

        int ans[] = new int[n];

        for(int i = 0 ;  i < n ; i++){

            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                ans[i] = -1;
            }
            else{
                ans[i] = st.peek();
            }

            st.push(i);
        }

        return ans;
    }

    public int[] nextSmaller(int arr[]){
        
        int n = arr.length ;
        
        Stack<Integer> st = new Stack<>();

        int ans[] = new int[n];

        for(int i = n-1 ;  i >=0 ; i--){

            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                ans[i] = n ; // instead -> of -1 -> push n
            }
            else{
                ans[i] = st.peek();
            }

            st.push(i);
        }

        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        
        int ps[] = previousSmaller(heights);
        int ns[] = nextSmaller(heights);

        int maxArea = 0;

        for(int i = 0 ; i < heights.length ; i++){
             
             maxArea = Math.max(maxArea , (ns[i] - ps[i] - 1) * heights[i]);
        }

        return maxArea;
    }
}

// TC -> O(3N) -> O(N)
// SC -> O(N) -> stack space
