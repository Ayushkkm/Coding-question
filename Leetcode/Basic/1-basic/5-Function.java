class Solution {
    
    public static void pass(int a , int b , int ans[]){
        
        ans[0] = a+1;
        ans[1] = b+2;
    }
    
    static int[] passedBy(int a, int b) {
        // GFG
        int ans[] = new int[2];
        
        pass(a,b,ans);
        
        return ans;
        
    }
}
