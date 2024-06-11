class Solution {
    public boolean checkValidString(String s) {
        int min =0 ;
        int max = 0;

        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);

            if(ch=='('){
                min = min+1;
                max = max+1;
            }
            else if(ch==')'){
                min = min -1;
                max = max - 1;
            }
            else{ // *
             
              min = min -1;  // take range
              max = max +1;
            }

            if(min<0) min = 0; // *() -> 1st iteration make -> min = -1 -> no need -> make zero

            if(max<0) return false ; // ) or )*() -> in 1st iteration -> it make -> both -1 -> return false
        }

        return min == 0; // min always cancel out
    }
}

//TC -> O(N)