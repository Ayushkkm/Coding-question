
// Brute Force -> create all substring 

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int n = s.length();
        int l = 0 ; 
        int r = 0 ;

        int maxLen = 0;

        for(int i = 0 ; i< n ; i++){
          int hash[] = new int[256];

          for(int j = i ; j < n ; j++){

            if(hash[s.charAt(j) != 0]){ // repeating character
                break ;
            }

            int len = j - i + 1;
            maxLen = Math.max(maxLen,len);
            hash[s.charAt(j)]++;
          
          }
         
        }

        return maxLen;
    }
}
// TC -> O(N^2)
// SC -> O(256) -> O(1) -> hash array


// Optimal 

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int n = s.length();
        int l = 0 ; 
        int r = 0 ;

        int maxLen = 0;
        int hash[] = new int[256];
        Arrays.fill(hash,-1); // -1 -> not fill -> 0th index -> so not 0

        while(r<n){ // expand
             
           if(hash[s.charAt(r)] != -1){ // already visited
             
             if(hash[s.charAt(r)] >= l){ // check character idx -> inside window -> or not
               
               l = hash[s.charAt(r)] + 1 ; // shrink -> if inside window
             }
           }

           maxLen = Math.max(maxLen , r-l+1);
           hash[s.charAt(r)] = r; // put idx

           r++;
        }

        return maxLen;
    }
}
// TC -> O(N)
// SC -> O(256) -> O(1) -> hash array