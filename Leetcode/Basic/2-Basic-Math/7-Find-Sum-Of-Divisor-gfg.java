class Solution {
     
    public static int sumi(int n){
        int sum = 0;
        
        for(int i = 1; i <=n; i++){
            if(n % i == 0){
                sum += i;
            }
        }
        
        return sum;
        
    }
    
    static int sumOfDivisors(int N) {
        
        int sum = 0;
        
        for(int i = 1 ; i <= N ; i++){
            
            if(N%i == 0){
                sum += sumi(i);
            }
        }
        
        return sum;
        
    }
}