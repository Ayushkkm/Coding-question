class Solution {
    public static int totalFruits(int N, int[] fruits) {
        
        Map<Integer , Integer> map = new HashMap<>(); // help to get -> count of basket -> and fruits in it -> which help in shrink 
        
        int l = 0;
        int r = 0;
        
        int maxFruits = 0;
        
        while(r < N){
            
            int fruit = fruits[r];
            
            map.put(fruit , map.getOrDefault(fruit , 0) + 1);
            
            while(map.size() > 2){ // more than 2 -> different fruits come -> shrink
                
                int outFruit = fruits[l];
                
                map.put(outFruit , map.get(outFruit) - 1);
                
                if(map.get(outFruit) == 0){ // remove that fruit from -> basket
                    map.remove(outFruit); 
                }
                
                l++;
            }
            
            maxFruits = Math.max(maxFruits , r - l +1);
            
            r++;
            
        }
        
        return maxFruits ;
    }
}

// TC -> O(N)
// SC -> O(1)
