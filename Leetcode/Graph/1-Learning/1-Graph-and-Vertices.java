class Solution {
    // GFG
    static long count(int n) {
        
    long val = n*(n-1)/2; // 2^nC2
    
    long ans = (long)Math.pow(2,val);
    
    return ans;
   

  }
}
