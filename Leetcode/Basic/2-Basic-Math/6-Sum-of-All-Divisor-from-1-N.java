class Solution {
    static long sumOfDivisors(int N) {
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            
            // Numbers divisible by i are i, 2i, 3i, ..., (N/i)i
            // There are (N/i) such numbers and each contributes i to the sum.
            
            sum += i * (N / i); // this is -> floor of(N/i) * i 
            
        }
        
        return sum;
    }
}

// TC -> O(N)
// SC -> O(1)

// This code is of O(N^2)

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