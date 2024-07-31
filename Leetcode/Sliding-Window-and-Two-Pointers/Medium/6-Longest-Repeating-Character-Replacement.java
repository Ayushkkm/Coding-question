class Solution {

    public int characterReplacement(String s, int k) {

        int n = s.length();

        int hash[] = new int[26];

        int l = 0;
        int r = 0;

        int maxFreq = 0;
        int maxL = 0;

        while (r < n) {

            char c = s.charAt(r);

            int freq = ++hash[c - 'A']; // hash[c - 'A']++ -> give incorrect -> solution

            maxFreq = Math.max(maxFreq, freq); // getting max -> Frequency

            while ((r - l + 1) - maxFreq > k) { // shrink

                hash[s.charAt(l) - 'A']--;

                maxFreq = 0;

                for (int i = 0; i < 26; i++) { // update -> new maxFreq
                    maxFreq = Math.max(maxFreq, hash[i]);
                }

                l++;
            }

            if ((r - l + 1) - maxFreq <= k) {
                maxL = Math.max(maxL, r - l + 1);
            }
            r++;
        }

        return maxL;

    }
}

// TC -> O(N + N)*26
// SC -> O(26)

// Optimal

class Solution {

    public int characterReplacement(String s, int k) {

        int n = s.length();

        int hash[] = new int[26];

        int l = 0;
        int r = 0;

        int maxFreq = 0;
        int maxL = 0;

        while (r < n) {

            char c = s.charAt(r);

            int freq = ++hash[c - 'A']; // hash[c - 'A']++ -> give incorrect -> solution

            maxFreq = Math.max(maxFreq, freq); // getting max -> Frequency

            if((r - l + 1) - maxFreq > k) { // shrink

                hash[s.charAt(l) - 'A']--;

                maxFreq = 0;

                for (int i = 0; i < 26; i++) { // update -> new maxFreq
                    maxFreq = Math.max(maxFreq, hash[i]);
                }

                l++;
            }

            if ((r - l + 1) - maxFreq <= k) {
                maxL = Math.max(maxL, r - l + 1);
            }
            r++;
        }

        return maxL;

    }
}

// TC -> O(N)*26
// SC -> O(26)

