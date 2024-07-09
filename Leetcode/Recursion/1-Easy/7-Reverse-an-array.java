class Solution {
  
   public void reverse(int i , int n , char[] s){
    if(i >= n/2){
        return ;
    }
     
    char a = s[i];
    s[i] = s[n-i-1];

    s[n-i-1] = a;

    reverse(i+1 , n , s);

   }

    public void reverseString(char[] s) {
        int n = s.length;

        reverse(0,n,s);
        
    }
}
// TC -> O(N/2)
// SC -> O(N/2) -> recursive stack