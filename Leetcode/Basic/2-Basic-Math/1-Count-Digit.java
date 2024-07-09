class Solution{
    static int evenlyDivides(int N){
       
       int evenly = 0;
       
       int a = N;
       
       while(a>0){
           int rem = a%10;
           
           if(rem!=0 && N%rem==0){ // evenly divide
               evenly++;
           }
           
           a = a/10;
       }
       
       return evenly;
    }
}