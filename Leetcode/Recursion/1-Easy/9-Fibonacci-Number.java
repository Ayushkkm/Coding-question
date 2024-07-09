class Solution {
    public int fib(int n) {
        if(n<=1){
            return n;
        }

        return fib(n-1) + fib(n-2);
    }
}
// TC -> O(2^N)
// SC -> O(N) -> recursive stack