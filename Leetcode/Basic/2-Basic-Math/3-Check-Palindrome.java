class Solution {
    public boolean isPalindrome(int x) {
         // Faster solution convert to string 
         
        if(x<0) return false;

        int count  = 0;
        int temp = x;

        while(temp!=0){ 
            temp= temp/10;
            count++;
        }

         int tens = (int)Math.pow(10,count-1);
         temp = x;
         

        for(int i =0 ; i <=count/2 ; i++){
          int first= 0;
          int rem = x%10;

          if(tens!=0)
          first = temp/tens;

          if(first!=rem) return false;

          if(tens!=0)
          temp = temp%tens;

          x = x/10;
          tens= tens/10;

        }

        return true;
    }
}

// Method 2 

class Solution {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        
        int n = s.length();
        int i =0 ;
        while(i<= n/2){
            if(s.charAt(i)!=s.charAt(n-i-1)){
                return false;
            }

            i++;
        }

        return true;
    }
}
// TC -> O(N/2)
// SC -> O(N) -> string