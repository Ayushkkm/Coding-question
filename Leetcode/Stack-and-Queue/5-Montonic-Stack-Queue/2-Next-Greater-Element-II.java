class Solution {

    public int[] nextGreaterElements(int[] nums) {
        
        int n = nums.length;

        Stack<Integer> st = new Stack<>();

        int ans[] = new int[n];

        for(int i = 2*n ;  i >=0 ; i--){
            
            int idx = i % n;

            while(!st.isEmpty() && st.peek() <= nums[idx]){
                st.pop();
            }

            if(i < n){ // now need to -> store -> answer
               
               ans[i] = st.isEmpty() ? -1 : st.peek();
            }

            st.push(nums[idx]);
        }

        return ans;

    }
}

// TC -> O(2N) + O(2N)
// SC -> O(N) -> stack space