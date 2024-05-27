class Solution {
    public String reverseWords(String s) {
        // Trim -> remove leading and trailing space , split -> remove space in between 2, 3 
        //how many space it remove and split in array
        
        String[] words = s.trim().split("\\s+");
        
       
        StringBuilder reversed = new StringBuilder();
        
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) {
                reversed.append(" ");
            }
        }
        
        return reversed.toS11tring();
    }
}

// Method 2  

// class Solution {
//     public String reverseWords(String s) {
       
//         StringBuilder str = new StringBuilder(s);
//         str.reverse(); // make whole string reverse

//         s = str + "";
//         str = new StringBuilder("");

//         // now make each word reverse -> our answer

//        String ans = "";
//        int n = s.length();

//        int countleading = 0 ;
//        int counttrailing = 0 ;

//        for(int i = 0 ; i< n ; i++){
//            char ch = s.charAt(i);

//         if(ch==' ' && i==0){
//             while(s.charAt(i)==' '){
//                countleading++;
//                i++;
//             }
//             i--;
                                 
//         }
//         else if(ch==' ' && i==n-1){
//             while(s.charAt(i)==' '){
//                counttrailing++;
//                i--;
//             }
//             break;
//         }
//        }
    
//        for(int i = countleading ; i < n-counttrailing; i++){
//         char ch = s.charAt(i);

//         if(i!=0 && s.charAt(i) ==' ' && s.charAt(i-1)==' ') continue;

//         if(ch != ' '){
//             str.append(ch);
//         }
        
//         else {
//             str.reverse();
//             ans += str + "";
//             ans += " ";
//             str = new StringBuilder("");
//         }

//        }
//        str.reverse();
//        ans+= str + "";

//        return ans;

//     }
// }


// Method - 3 

// class Solution {
//     public String reverseWords(String s) {
        
//         String ans = "";
//         StringBuilder str = new StringBuilder("");
//         int count  = 0;
//         for(int i = s.length() -1 ; i>=0 ; i--){
//             char c = s.charAt(i);

                       
//            // for middle gap 
//             if(i!=0 && s.charAt(i) ==' ' && s.charAt(i-1)==' ') continue;
           
//            // for starting gaps 
//             if(i ==0 && s.charAt(0) == ' ') continue;
            
//             // for last gaps
//             if(c != ' '){
//                 count++;
               
//             }
           
//            if(count!=0){
//                if(c != ' '){
//                 str.append(c);
//             }
//             else{
//                 str.reverse();
//                 ans+= str;
//                 ans+= " ";
//                 str = new StringBuilder("");
//             }

//            }
            
//         }

//         str.reverse();

//         ans += str;

//         return ans;
//     }
// }