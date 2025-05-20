class Solution {
    public boolean isAnagram(String s, String t) {
        int count[] = new int[26];

        for(char ch : s.toCharArray()){
            count[ch-97]++;  // 'a' -> int , direct write 97;
        }

        for(char ch : t.toCharArray()){
            count[ch-97]--;
        }

        for(int val : count){
            if(val!=0) return false;
        }

        return true;


    }
}

// above give 99% beat -> because of for(char ch : s.toCharArray()) -> convert whole string to -> char -> charAt(i) -> take more time 

// class Solution {
//     public boolean isAnagram(String s, String t) {
//         int hash[] = new int[26];
//         if(s.length() != t.length()) return false;
//         for(int i = 0; i < s.length(); i++){
        
//         hash[s.charAt(i) - 97]++;
//         hash[t.charAt(i) - 97]--;
//         }

//         for(int val : hash){
//             if(val!=0) return false;
//         }

//         return true;

//     }
// }

// Beat 55.5%

// class Solution {
//     public boolean isAnagram(String s, String t) {
//         if(s.length()!=t.length()) return false;

//         int hash1[] = new int[26];
//         int hash2[] = new int[26];

//         for(int i = 0 ; i < s.length() ; i++){
//             hash1[s.charAt(i)-'a']++;
//              hash2[t.charAt(i)-'a']++;

//         }

//         for(int i = 0 ; i <26 ; i++){
//             if(hash1[i]!=hash2[i]) return false;
//         }

//         return true;
//     }
// }

// Beat 54%
