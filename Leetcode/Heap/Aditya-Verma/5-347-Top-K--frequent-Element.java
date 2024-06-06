import java.util.*;

class pair implements Comparable<pair>{
    int key ;
    int val ;

    pair(int key , int val){
        this.key = key;
        this.val = val;
    }

    public int compareTo(pair other){
        return Integer.compare(this.key,other.key);
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i<nums.length ; i++){
           map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<pair> minHeap = new PriorityQueue<pair>();
        
        for(int i = 0 ; i < nums.length ; i++){
           
            if(map.containsKey(nums[i])) // if contain -> add
            minHeap.add(new pair(map.get(nums[i]),nums[i]));
            

            if(minHeap.size()>k){
                minHeap.remove();
            }

            map.remove(nums[i]); // // Remove the element from map to avoid reprocessing
        }

        int ans[] = new int[minHeap.size()];
        
        int i = 0;
        while(!minHeap.isEmpty()){
            ans[i++] = minHeap.peek().val;
            minHeap.remove();
        }

        return ans;

    }
}