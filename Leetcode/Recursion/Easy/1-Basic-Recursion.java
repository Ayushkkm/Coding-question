class Solution
{
    public void print(int i , int N){
        if(i>N){
            return ;
        }
        
        System.out.print(i + " ");
        
        print(i+1,N);
    }
    
  public void printNos(int N)
    {
        // GFG
        print(1,N);
    }
}
// TC -> O(N)
// SC -> O(N) -> recursive stack