class Solution {
    public String removeKdigits(String num, int k) {

        int n = num.length();

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && k > 0 && st.peek() > num.charAt(i)) { // if in stack -> large -> than remove
                st.pop();
                k--;
            }

            st.push(num.charAt(i)); // now -> push
        }

        while (!st.isEmpty() && k > 0) { // if k -> remain -> remove -> last k -> because -> they are -> large -> than
                                         // -> element after k -> in stack
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        sb.reverse();

        while (sb.length() > 1 && sb.charAt(0) == '0') { // Remove leading zeros
            sb.deleteCharAt(0);
        }

        return sb.toString().isEmpty() ? "0" : sb.toString(); // Return the -> resultant number -> as a string

    }
}

// TC -> O(n)
// SC -> O(n) -> for stack