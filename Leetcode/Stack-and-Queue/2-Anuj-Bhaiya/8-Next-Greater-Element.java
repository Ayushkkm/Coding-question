class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        Stack<Long> st = new Stack<>();

        long ans[] = new long[n];

        for(int i = arr.length -1 ; i >= 0 ; i--){

            while(!st.isEmpty() && st.peek() <= arr[i]){ // remove smallest -> element
                   
                   st.pop();
            }

            if(st.isEmpty() == true){ // stack become -> empty -> no previous greater element
                 ans[i] = -1;
            }

            else{ // we got our -> previous greater element
              ans[i] = st.peek();
            }

            st.push(arr[i]); // push -> current element
        }

        return ans;
    } 
}

// TC -> O(N)
// SC -> O(N)