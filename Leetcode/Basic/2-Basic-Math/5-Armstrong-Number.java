class solution{

    public boolean armStrong(Long N){
        long temp = N;
        long sum = 0;
        int count = 0;
        while(temp!=0){
            temp = temp/10;
            count++;
        }
        
        temp = N;
        
        while(temp!=0){
            long rem = temp%10;
            sum += (lONG)Math.pow(rem,count);
            temp = temp/10;
        }
        
        return sum == N;
    
    }
}
// TC -> O(N)
// SC -> O(1)