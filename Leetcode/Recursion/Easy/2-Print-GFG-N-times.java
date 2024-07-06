class Solution {
    
    public void print(int i){
        if(i<1){
            return;
        }
        
        print(i-1); // Backtrack
        
        System.out.print("GFG ");
           
        
    }

    void printGfg(int N) {
        // GFG
        print(N);
    }
}
// TC -> O(N)
// SC -> O(N) -> recursive stack