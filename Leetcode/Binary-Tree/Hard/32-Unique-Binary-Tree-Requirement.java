class Solution{
    
    public static boolean isPossible(int a, int b){

        // GFG
       
       if((a==2 || b==2 ) && (a!=b)) {
           return true;
       }
       
       return false;
    }
}
// TC -> O(1)
// SC -> O(1)
