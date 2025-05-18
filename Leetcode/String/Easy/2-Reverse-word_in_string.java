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
        return reversed.toString();
    }
}

// Expression	Meaning
// \\s	-> Any whitespace character (space, tab, newline)
// +	-> One or more occurrences
// \\s+	-> One or more whitespace characters
// .split("\\s+") -> Split string by one or more whitespace characters

// Method 2 (easy)  

// class Solution {
//     public String reverseWords(String s) {
//         int n = s.length();
//         StringBuilder str = new StringBuilder();
//         String ans = "";
        
//         for(int i = n-1 ; i>=0 ; i--){
//             char c = s.charAt(i);
            
//             if(c == ' ' && str.length() == 0){ // to remove unnecessary spaces -> leading -> trailing -> middle
//               continue;
//             }

//             if(c != ' '){
//                 str.append(c);
//             }
//             else{
//                 str.reverse();
//                 if(ans.length() == 0){ // first -> without space
//                     ans += str + "";
//                 }
//                 else{
//                     ans += " " + str; // make space betwwen words
//                 }
//                 str = new StringBuilder(); // empty str -> now if a unnecessary spaces -> occur -> we continue it
//             }
//         }

//         if(str.length() != 0){
//             str.reverse();
//             if(ans.length() == 0){ // first -> without space -> "aYhandf"
//                 ans += str + "";
//             }
//             else{
//                 ans += " " + str; // make space betwwen words
//             }
//         }
//         return ans;
//     }
// }