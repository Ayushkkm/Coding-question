class Solution {
	public static int[] help_classmate(int arr[], int n) 
	{ 
        // GFG
        
	   Stack<Integer> st = new Stack<>();

        int ans[] = new int[n];

        for(int i = arr.length -1 ; i >= 0 ; i--){

            while(!st.isEmpty() && st.peek() >= arr[i]){ // remove greater -> element
                   
                   st.pop();
            }

            if(st.isEmpty() == true){ // stack become -> empty -> no previous smallest element
                 ans[i] = -1;
            }

            else{ // we got our -> previous smallest element
              ans[i] = st.peek();
            }

            st.push(arr[i]); // push -> current element
        }

        return ans;

	} 
}

// TC -> O(N)
// SC -> O(N) -> stack space