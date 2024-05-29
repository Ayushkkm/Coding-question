class Solution {
    public boolean rotateString(String s, String goal) {
        return (s.length()==goal.length() && (s+s).contains(goal));
    }
}

// By rotate string

// class Solution {
//     public boolean rotateString(String s, String goal) {

//         StringBuilder str = new StringBuilder(s);
//         int n = s.length();
        
//         for(int i = 0 ; i < n ; i++){ 
           
//            char last = str.charAt(n-1);

//            for(int j = n-1 ; j > 0 ; j--){

//             char prev = str.charAt(j-1);
//             str.setCharAt(j,prev);

//            }
//            str.setCharAt(0,last);

//            if(str.toString().equals(goal)) return true;

//         }
//         return false;
//     }

        
// }