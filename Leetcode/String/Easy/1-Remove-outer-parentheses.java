class Solution {
    public String removeOuterParentheses(String s) {
        String ans = "";

        int count = 0;  
        
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);

            if(c=='('){
                count++;
                if(count!=1) ans += c + "";
            }
            else if(c==')'){
                count--;
                if(count!=0){
                    ans  += c + "";
                }
            }

        }

        return ans;
    }
}

// Correct ans with stack 

// class Solution {
//     public String removeOuterParentheses(String s) {
        
//         Stack<Character> st = new Stack<>();

//         String ans = "";
        
//         for(int i = 0 ; i< s.length(); i++){
//             char ch = s.charAt(i);

//             if(ch == '('){
//                 if(st.size()>0) ans += ch + "";
//                 st.push(ch);
//             }
//             else{
//                 st.pop();
//                 if(st.size()>0) ans += ch + "";

//             }
//         }

//         return ans;
//     }
