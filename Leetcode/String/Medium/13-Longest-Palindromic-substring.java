// IMP -> if you need to do substring -> and i and j given -> for substring -> pass(s,i,j) -> and in while(i,j) -> do you work -> don't do s.substring(i,j)

class Solution {

    public boolean isPalindrome(String s , int i , int j){
        while(i<j){  // if string s = "a" -> i = 0 , j = 0 , -> while(i<j) -> not go -> direct -> return true
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);

            if(ch1 != ch2) return false;
            i++;
            j--;
        }

        return true ;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxL = 0 ;
        int start = 0;
        int end = 0 ;

        for(int i = 0 ; i < n ; i++){ // find all substring -> check which is large -> store its indexes
            for(int j = i ; j<n ; j++){
                if(isPalindrome(s,i,j)){
                    if((j-i+1)> maxL){ // check max length
                        maxL= j-i+1;
                        start = i ;
                        end = j ;
                    }
                }
            }
        }

        return s.substring(start,end+1);
    }
}


// Give TLE -> I use -> s.substring(i,j) and StringBuilder-> which consume more time -> 
// if you need to do substring -> and i and j given -> for substring -> pass(s,i,j) -> and in while(i,j) -> do you work -> don't do s.substring(i,j)

// class Solution {

//     public String longestPalindrome(String s) {
//         StringBuilder str = new StringBuilder();

//         int n = s.length();
//         int maxL = 0;
//         String ans = "";

//         for(int i =0 ; i< n ; i++){
//             for(int j = i+1 ; j<=n ; j++){
//                 String a = s.substring(i,j) + "";
//                 str.append(a) ;
//                 String b = str.reverse() + "";

//                 if(a.equals(b)) {
//                     if(a.length() > maxL){
//                         maxL = a.length();
//                         ans = a + "";
//                     }
//                 }

//                 str = new StringBuilder("");
               
//             }
//         }

//         return ans;
//     }
// }
