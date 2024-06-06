import java.util.*;
class pair implements Comparable<pair>{
       int key;
       int val;
       
       pair(int key,int val){
        this.key = key;
        this.val=val;
       }

       public int compareTo(pair other){
        return Integer.compare(this.key,other.key);
       }
    }
class Solution {
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();

        PriorityQueue<pair> maxHeap = new PriorityQueue<pair>(Collections.reverseOrder());

        for(int i = 0 ; i< arr.length ; i++){
            int abs = Math.abs(arr[i]-x);

            maxHeap.add(new pair(abs,arr[i]));

            if(maxHeap.size()>k){
                maxHeap.remove();
            }
        }

        while(!maxHeap.isEmpty()){
            list.add(maxHeap.peek().val);
            maxHeap.remove();
        }

        return list;
    }
}