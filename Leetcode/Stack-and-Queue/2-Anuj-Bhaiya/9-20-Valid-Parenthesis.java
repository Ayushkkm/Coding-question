class Solution {
    
    public boolean isOpening(char c){

        return c == '(' || c == '{' || c == '['; 
    }

    public boolean isMatch(char c , char d){
        return (c == '}' && d == '{') ||
               (c == ']' && d == '[') || 
               (c == ')' && d == '(') ;
    }

    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack<>();

        for(int i = 0 ; i < s.length() ; i++){
            
            char c = s.charAt(i);
            if(isOpening(c)==true){ // if open -> push in stack
                st.push(c);
            }

            else{ // closed
               
               if(st.isEmpty()){ // no -> opening bracket
                  return false;
               }

               if(isMatch(c , st.peek())== false){ // not match
                  return false;
               }

               st.pop(); // matched open -> and closing bracket -> pop
            }
        }

        return st.isEmpty(); // check -> empty -> or not
    }
}

// TC -> O(N)
// SC -> O(N)