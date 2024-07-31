class Solution {
    public String minWindow(String s, String t) {
        
        int n = s.length();
        
        int l = 0; 
        int r = 0;
    
        int minL = Integer.MAX_VALUE;
        int sindex = -1;
        int count = 0;

        Map<Character , Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < t.length() ; i++){
             map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        while(r < n){
            char ch = s.charAt(r);

            if (map.containsKey(ch) && map.get(ch) > 0) { // If character is part of 't' -> and count is greater than 0 -> increment the count
                count++;
            }

            map.put(ch, map.getOrDefault(ch, 0) - 1); // Decrement the frequency -> of the current character 

            while (count == t.length()) { // When all characters -> from 't' -> are included -> in the current window

                if (r - l + 1 < minL) {  // Update the minimum length -> and start index of the window
                    minL = r - l + 1;
                    sindex = l;
                }
                
                map.put(s.charAt(l), map.get(s.charAt(l)) + 1); // Move the left pointer -> to shrink the window -> +ve -> means -> don't seen yet

                if (map.get(s.charAt(l)) > 0) { // if become -> not seen -> decrease -> count 
                    count--;
                }

                l++;
            }
            r++;
        }

        return sindex == -1 ? "" : s.substring(sindex, sindex + minL); // return minimum -> substring

        
    }
}

// TC -> O(N)
// SC -> O(N)
