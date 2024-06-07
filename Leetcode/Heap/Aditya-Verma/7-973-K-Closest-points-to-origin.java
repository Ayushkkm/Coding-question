import java.util.*;

class pair implements Comparable<pair>{
    int key;
    int x;
    int y;

    pair(int key , int x, int y){
        this.key = key;
        this.x = x;
        this.y = y;
    }

    public int compareTo(pair other){
        return Integer.compare(this.key, other.key);
    }
}


class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<pair> maxHeap = new PriorityQueue<pair>(Collections.reverseOrder());

        for(int i = 0 ; i<points.length ; i++){
            int key = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            maxHeap.add(new pair(key, points[i][0], points[i][1])); // key -> x^2 + y^2 -> coor -> x,y 

            if(maxHeap.size()>k){
                maxHeap.remove();
            }
        }

        int ans[][] = new int[maxHeap.size()][2];
        int i = 0 ;
       
        while(!maxHeap.isEmpty()){
           ans[i][0] = maxHeap.peek().x;
           ans[i][1] = maxHeap.peek().y;
           i++;
           maxHeap.remove();
        }

        return ans ;
    }
}
// Complexity: O(nlogk)


