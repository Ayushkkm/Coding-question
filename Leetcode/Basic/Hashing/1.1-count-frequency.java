// https://www.geeksforgeeks.org/problems/frequency-of-elements--111353/1


class Solution {
    public ArrayList<ArrayList<Integer>> countFreq(int[] arr) {
        
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < arr.length ; i++){
            
             map.put(arr[i] , map.getOrDefault(arr[i] , 0)+1);
        }
        
        ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
        
        for(int key : map.keySet()){
            
            ArrayList<Integer> temp = new ArrayList<>();
            
            temp.add(key);
            temp.add(map.get(key));
            
            ar.add(temp);
        }
        
        return ar;
        
    }
}
