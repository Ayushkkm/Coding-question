class Solution {
    public boolean rotateString(String s, String goal) {
        return (s.length()==goal.length() && (s+s).contains(goal));
    }
}

// By rotate string

// class Solution {
//     public boolean rotateString(String s, String goal) {
    
//     StringBuilder str1 = new StringBuilder(s);

//     if (str1.toString().equals(goal)) return true;

//     int n = str1.length();

//     for (int i = 0; i < n; i++) {
//         str1.append(str1.charAt(0)); // add first element -> last
//         str1.deleteCharAt(0);       // delete first element
        
//         if (str1.toString().equals(goal)) {
//             return true;
//         }
//     }

//     return false;
// }
// }
