class Solution {

    public boolean palindrome(int i , int n , String s){
        if(i>=n/2){
            return true;
        }

        if(s.charAt(i)!= s.charAt(n-i-1)){
            return false;
        }

        if(palindrome(i+1 , n , s)==false){
            return false;
        }

        return true;
    }

    private boolean isLetterOrDigit(char c) {
        return (c >= 'a' && c <= 'z') ||
               (c >= 'A' && c <= 'Z') ||
               (c >= '0' && c <= '9');
    }

    public boolean isPalindrome(String s) {

        StringBuilder str = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (isLetterOrDigit(c)) {
                str.append(Character.toLowerCase(c));
            }
        }

        String a = str.toString();
        int n = a.length();


        return palindrome(0 , n , a);
    }
}
// TC -> O(N/2)
// SC -> O(N/2) -> recursive stack