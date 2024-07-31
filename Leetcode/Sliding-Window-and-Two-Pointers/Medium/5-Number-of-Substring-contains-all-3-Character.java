class Solution {
    public int numberOfSubstrings(String s) {
        
        int lastSeen[] = new int[3];

        Arrays.fill(lastSeen , -1); // -1 -> not seen 

        int count = 0 ;

        for(int i = 0 ; i < s.length() ; i++){
            
            char c = s.charAt(i);

            lastSeen[c - 'a'] = i;

            if(lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1){ // all 3 character -> contains
                
               count += Math.min(lastSeen[0] , Math.min(lastSeen[1] , lastSeen[2]))  +1;
            }
        }

        return count;
    }
}

// TC -> O(N)
// SC -> O(1)
