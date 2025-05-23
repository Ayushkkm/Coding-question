// link - https://www.geeksforgeeks.org/problems/count-number-of-substrings4528/1

class Solution {
    int countSubstr(String S, int K) {
        return atmost(S, K) - atmost(S, K - 1); // Exactly K  
    }

    int atmost(String s, int k) {
        int dist = 0;
        int ans = 0;
        int left = 0;

        int hash[] = new int[26];

        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;

            if (hash[s.charAt(i) - 'a'] == 1) dist++; // if 1 -> distinct -> if 2 not distint

            while (dist > k) {
                hash[s.charAt(left) - 'a']--; // left -> initial 0 -> character remove

                if (hash[s.charAt(left) - 'a'] == 0) dist--; // count -> left = 0 -> not in substring

                left++; // left increase -> remove current character -> from string
            }

            ans += i - left + 1;

            /* 
            If exactly K → then do: count++ → here atmost K 
            Here → i - left + 1 → signifies number of substrings ending at i and starting from any index in [left, i]
            Example: s = "abc", left = 0, i = 2 
            Substrings: s[0..2] = "abc", s[1..2] = "bc", s[2..2] = "c"
            So count += i - left + 1 → counts all substrings with at most K distinct characters.
            while(dist > k) helps maintain the invariant of at most K distinct characters in the window.
            */
        }

        return ans;
    }
}

// TC -> O(N)
// SC -> O(1)
