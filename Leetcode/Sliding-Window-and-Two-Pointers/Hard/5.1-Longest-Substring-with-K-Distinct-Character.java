
class Solution {
    public int longestkSubstr(String s, int k) {
        
        // GFG

        int n = s.length();
        
        int l = 0;
        int r = 0;
        
        int maxL = -1;
        
        Map<Character , Integer> map = new HashMap<>();
        
        while(r < n){
            
            map.put(s.charAt(r) , map.getOrDefault(s.charAt(r), 0) + 1);
            
            while(map.size()  > k){ // shrink
                
                map.put(s.charAt(l) , map.get(s.charAt(l)) -1);
                
                if(map.get(s.charAt(l)) == 0){
                    map.remove(s.charAt(l));
                    
                }
                
                l++;
            }
            
            if(map.size() == k){
                
                maxL = Math.max(maxL , r - l + 1);
            }
            
            r++;
        }
        
        return maxL;
    }
}

// TC -> O(N) + O(256)
// SC -> O(256)
