import java.util.*;
class pair implements Comparable<pair>{
    int key;
    int val;

    pair(int key, int val){
        this.key = key;
        this.val = val;
    }

    public int compareTo(pair other){
        if(this.key==other.key){
            return Integer.compare(other.val,this.val);
        }
        else{
            return Integer.compare(this.key,other.key);
        }
    }
}

class Solution {
    public int[] frequencySort(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num , map.getOrDefault(num,0)+1);
        }

        PriorityQueue<pair> minHeap = new PriorityQueue<pair>();

        for(int i = 0 ; i < nums.length ; i++){
            if(map.containsKey(nums[i])){
                minHeap.add(new pair(map.get(nums[i]),nums[i]));
            }

            map.remove(nums[i]);
        }

        int ans[] = new int[nums.length];
        int i = 0;

        while(!minHeap.isEmpty()){
            int freq = minHeap.peek().key;

            for(int j = 0 ; j<freq ;j++){
                ans[i++] = minHeap.peek().val;
            }

            minHeap.remove();
        }

        return ans;
        
    }
}