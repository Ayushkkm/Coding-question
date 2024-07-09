class Solution {
    public int reverse(int x) {
        int max = Integer.MAX_VALUE;
        int rev  = 0;

        boolean f = false;
        if(x<0){
            f = true;
            x = x*(-1);
        }

        while(x!=0){
          int rem = x%10;

          if(rev > (max - rem)/10){
            return 0 ;
          }
          rev = rev* 10+ rem ;
          x = x/10;

        }

        if(f==true){
            rev = rev*(-1);
        }
        return rev;
    }
}

