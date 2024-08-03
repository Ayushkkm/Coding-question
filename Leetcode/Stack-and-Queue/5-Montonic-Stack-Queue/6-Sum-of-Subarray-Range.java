class Solution {

    public int[] findNSE(int[] arr) {

        int n = arr.length;

        Stack<Integer> st = new Stack<>();

        int[] nse = new int[n];

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return nse;
    }

    public int[] findPSE(int[] arr) {

        int n = arr.length;

        Stack<Integer> st = new Stack<>();

        int[] pse = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);

        }

        return pse;
    }

    public int[] findNGE(int[] arr) {

        int n = arr.length;

        Stack<Integer> st = new Stack<>();

        int[] nge = new int[n];

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return nge;
    }

    public int[] findPGE(int[] arr) {

        int n = arr.length;

        Stack<Integer> st = new Stack<>();

        int[] pge = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }

            pge[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }

        return pge;
    }

    public long subarrayMin(int[] nums) {
        int n = nums.length;
        long total = 0;

        int[] nse = findNSE(nums);
        int[] pse = findPSE(nums);

        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            total += left * right * nums[i];
        }
        return total;
    }

    public long subarrayMax(int[] nums) {
        int n = nums.length;
        long total = 0;

        int[] nge = findNGE(nums);
        int[] pge = findPGE(nums);

        for (int i = 0; i < n; i++) {
            long left = i - pge[i];
            long right = nge[i] - i;
            total += left * right * nums[i];
        }
        return total;
    }

    public long subArrayRanges(int[] nums) {
        return subarrayMax(nums) - subarrayMin(nums);
    }
}

// TC -> O(10N)
// SC -> O(2N)

// This is my code -> not able to find what is wrong

// class Solution {

// // Sum of subarray minimum

// public int[] nextSmallerElementIndex(int[] arr, int n) {

// int[] ans = new int[n];

// Stack<Integer> st = new Stack<>();

// for (int i = n - 1; i >= 0; i--) {

// while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
// st.pop();
// }

// if(st.isEmpty()){ // if -> not -> then n -> to consider -> subarray -> till
// end
// ans[i] = n;
// }

// else{
// ans[i] = st.peek();
// }

// st.push(i);
// }

// return ans;
// }

// public int[] prevSmallerEqualElementIndex(int[] arr, int n) {

// int[] ans = new int[n];

// Stack<Integer> st = new Stack<>();

// for (int i = 0; i < n; i++) {

// while (!st.isEmpty() && arr[st.peek()] > arr[i]) { // only -> greater ->
// remove -> not equal
// st.pop();
// }

// ans[i] = st.isEmpty() ? -1 : st.peek(); // if -> not -> then -1 -> to
// consider -> subarray -> till end

// st.push(i);
// }

// return ans;
// }

// public int sumSubarrayMins(int[] arr) {

// int n = arr.length;

// int MOD = (int) 1e9 + 7;

// int[] prev = prevSmallerEqualElementIndex(arr, n); // if -1 -> come -> i -
// (-1) -> make i+1 -> element -> take full -> subarray from -> start
// int[] next = nextSmallerElementIndex(arr, n);

// long sum = 0;

// for (int i = 0; i < arr.length; i++) {
// long left = i - prev[i];
// long right = next[i] - i;

// sum = sum + (left * right * arr[i]);
// }

// return (int) sum;
// }

// // sum of array maximum

// public int[] nextGreaterElementIndex(int[] arr, int n) {

// int[] ans = new int[n];

// Stack<Integer> st = new Stack<>();

// for (int i = n - 1; i >= 0; i--) {

// while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
// st.pop();
// }

// if(st.isEmpty()){ // if -> not -> then n -> to consider -> subarray -> till
// end
// ans[i] = n;
// }

// else{
// ans[i] = st.peek();
// }

// st.push(i);
// }

// return ans;
// }

// public int[] prevGreaterEqualElementIndex(int[] arr, int n) {

// int[] ans = new int[n];

// Stack<Integer> st = new Stack<>();

// for (int i = 0; i < n; i++) {

// while (!st.isEmpty() && arr[st.peek()] < arr[i]) { // only -> lesser ->
// remove -> not equal
// st.pop();
// }

// ans[i] = st.isEmpty() ? -1 : st.peek(); // if -> not -> then -1 -> to
// consider -> subarray -> till end

// st.push(i);
// }

// return ans;
// }

// public int sumSubarrayMaxs(int[] arr) {

// int n = arr.length;

// int MOD = (int) 1e9 + 7;

// int[] prev = prevGreaterEqualElementIndex(arr, n); // if -1 -> come -> i -
// (-1) -> make i+1 -> element -> take full -> subarray from -> start
// int[] next = nextGreaterElementIndex(arr, n);

// long sum = 0;

// for (int i = 0; i < arr.length; i++) {
// long left = i - prev[i];
// long right = next[i] - i;

// sum = sum + (left * right * arr[i]) ;
// }

// return (int) sum;
// }

// public long subArrayRanges(int[] nums) {

// return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);

// }
// }
