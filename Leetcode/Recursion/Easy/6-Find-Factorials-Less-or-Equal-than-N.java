class Solution {
    
    public static long factorial(long n){
        
        if(n==1){
            return 1;
        }
        
        return n * factorial(n-1);
    }
    
    static ArrayList<Long> factorialNumbers(long n) {
        
        // GFG  
        ArrayList<Long> list = new ArrayList<>();
        
        for(int i = 1 ; i <= n ; i++){
            
            long facto = factorial(i);
            
            if(facto <= n){
                list.add(facto);
            }
            
            else{
                break;
            }
            
        }
        
        return list;
    }
}
// TC -> O(N)
// SC -> O(N) -> recursive stack