class Solution {
    public int myAtoi(String s) {
        int ans = 0 ;
        int n = s.length();
        int i = 0;
        int sign =1 ;
 
        // Remove space
        while(i<n && s.charAt(i)==' '){
            i++;
        }
        
        // Sign check

        if(i<n && s.charAt(i)=='+'){
            sign = 1;
            i++;
        } 
        else if(i<n && s.charAt(i)=='-'){
            sign = -1;
            i++;
        } 
       
        // iterate and check value is digit
        while(i<n && 0<= s.charAt(i)-'0' && s.charAt(i) - '0'<=9){
            int digit = s.charAt(i) - '0';

        // check range 
        if(ans>Integer.MAX_VALUE/10 || (ans==Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE%10)){
               return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE ;
            }

            ans = ans*10 + digit;
            i++;
        }

        return ans*sign;
    
       
    }
}