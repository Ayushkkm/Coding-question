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

    public int maxHistogram(int[] heights) {
        
        int ps[] = previousSmaller(heights);
        int ns[] = nextSmaller(heights);

        int maxArea = 0;

        for(int i = 0 ; i < heights.length ; i++){
             
             maxArea = Math.max(maxArea , (ns[i] - ps[i] - 1) * heights[i]);
        }

        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length ;

        int currRow[] = new int[m] ;

        for(int i = 0 ; i < m ; i++){
            if(matrix[0][i] == '1'){
                currRow[i] = 1;
            }
            else{
                currRow[i] = 0;
            }
        }

        int maxArea = maxHistogram(currRow);

        for(int i = 1 ; i < n ; i++){ // row0 -> already -> calculated -> go from 1

            for(int j = 0 ; j < m ; j++){

                if(matrix[i][j]== '1'){ // if 1 -> add to currRow
                    currRow[j] += 1;
                }

                else {  // make that index 0
                    currRow[j] = 0;
                }

            }

            int currAns = maxHistogram(currRow); // find new -> area

            maxArea = Math.max(maxArea , currAns);
        }

        return maxArea;
    }
}

// TC -> O(N*M)
// SC -> O(M)