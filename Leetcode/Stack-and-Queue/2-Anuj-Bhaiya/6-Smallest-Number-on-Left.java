class Solution{
    static List<Integer> leftSmaller(int n, int a[])
    {
        // GFG

        Stack<Integer> st = new Stack<>();

        List<Integer> ans = new ArrayList<>();

        for(int i = 0 ; i < a.length ; i++){

            while(!st.isEmpty() && st.peek() >= a[i]){ // remove greater -> element
                   
                   st.pop();
            }

            if(st.isEmpty() == true){ // stack become -> empty -> no previous smallest element
                 ans.add(-1);
            }

            else{ // we got our -> previous smallest element
              ans.add(st.peek());
            }

            st.push(a[i]); // push -> current element
        }

        return ans;
    }
}

// TC -> O(N)
// SC -> O(N) -> stack space