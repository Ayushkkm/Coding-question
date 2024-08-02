class Solution {

    public int[] nextSmallerElementIndex(int[] arr, int n) {
        
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            
            if(st.isEmpty()){ // if -> not -> then n -> to consider -> subarray -> till end
                ans[i] = n;
            }

            else{
                ans[i] = st.peek();
            }

            st.push(i);
        }

        return ans;
    }

    public int[] prevSmallerEqualElementIndex(int[] arr, int n) {
       
        int[] ans = new int[n];
       
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < n; i++) {
           
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) { // only -> greater -> remove -> not equal
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek(); // if -> not -> then -1 -> to consider -> subarray -> till end

            st.push(i);
        }

        return ans;
    }

    public int sumSubarrayMins(int[] arr) {
        
        int n = arr.length;

        int MOD = (int) 1e9 + 7;

        int[] prev = prevSmallerEqualElementIndex(arr, n); // if -1 -> come -> i - (-1) -> make i+1 -> element -> take full -> subarray from -> start
        int[] next = nextSmallerElementIndex(arr, n);

        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            long left = i - prev[i];
            long right = next[i] - i; 

            sum = (sum + (left * right * arr[i]) % MOD) % MOD;
        }

        return (int) sum;
    }
}

// TC -> O(5N)
// SC -> O(4N) -> 2 stack -> 2 array