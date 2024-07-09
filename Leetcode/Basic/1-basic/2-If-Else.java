class Solution {
    public static String compareNM(int n, int m) {
        // GFG
       if(n==m){
           return "equal";
       }
       else if(n>m){
           return "greater";
       }
       else{
           return "lesser";
       }
    }
}