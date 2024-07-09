class Solution
{
    
    // With Recursion
    public void print(int i , int N){
        if(i>N){
            return ;
        }
        
        System.out.print(i + " ");
        
        print(i+1,N);
    }
    
    // With Backtracking
    
    public void printB(int i){
        if(i<1){
            return ;
        }
        
        printB(i-1);
        
        System.out.print(i + " ");
    }
    
    
  public void printNos(int N)
    {
        print(1,N);
        
        printB(N);
    }
}

// TC -> O(N)
// SC -> O(N) -> recursive stack

