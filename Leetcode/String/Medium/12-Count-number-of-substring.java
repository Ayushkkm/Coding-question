// link - https://www.geeksforgeeks.org/problems/count-number-of-substrings4528/1

class Solution {

    int countSubstr(String s, int k) {
        return atmost(s, k) - atmost(s, k - 1);
    }

    int atmost(String s, int k) {
        int n = s.length();
        int distinct = 0;
        int ans = 0;
        int l = 0;
        int r = 0;
        int[] hash = new int[26];

        while (r < n) {
            char ch = s.charAt(r);
            hash[ch - 'a']++;
            if (hash[ch - 'a'] == 1) {
                distinct++; // if 1 -> distinct -> if 2 not distint
            }

            while (distinct > k) {
                char c = s.charAt(l);
                hash[c - 'a']--; // remove -> left character
                if (hash[c - 'a'] == 0) distinct--;  // frequency -> of l is 0 -> not in substring
                l++;  // l increase -> remove current character -> from string
            }  

            ans += r - l + 1;
            r++;
            
            /* 
            If if exactly K -> then do -> count++ -> here atmost k -> so count++ directly
            here -> r-l+1 -> signifies -> string end at r > can be -> start from (l , l+1 ,,, r-1)
            Example: s = "abc", l = 0, r = 2 
            Substrings: 
            s[0..2] = "abc"
            s[1..2] = "bc"
            s[2..2] = "c"
            while(r < n){
            count += r - l + 1 } → count total -> substring -> a,b,c,ab,bc,abc
            so while(r < n){ -> counting all Distinct -> substring -> and ->  while(dist>k){ -> help to keep -> ans contains -> substring -> 0 to k distinct character
            */
        }

        return ans;
    }
}

// TC -> O(N)
// SC -> O(1)
