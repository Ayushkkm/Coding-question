class Solution {
    
    public void print(int i , int N){
        if(i>N){
            return ;
        }
        
        print(i+1,N);
        
        System.out.print(i + " ");
    }

    void printNos(int N) {
        
        print(1,N);
    }
}
// TC -> O(N)
// SC -> O(N) -> recursive stack
