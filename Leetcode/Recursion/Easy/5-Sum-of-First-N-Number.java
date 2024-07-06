class Solution {
    
    public long sum(long n){
        if(n==1){
            return 1;
        }
        
        return n*n*n + sum(n-1);
    }
    
    long sumOfSeries(long n) {
       
       // GFG
       return sum(n); // give sum of -> series -> till n
    }
}
// TC -> O(N)
// SC -> O(N) -> recursive stack