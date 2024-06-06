class Solution {
    int[] kLargest(int[] arr, int n, int k) {
       
       PriorityQueue<Integer> minHeap = new PriorityQueue<>();
       
       int ans[] = new int[k];
       
       for(int i = 0 ; i<n ; i++){
           minHeap.add(arr[i]);
           
           if(minHeap.size()>k){
               minHeap.remove();
           }
       }
       
       for(int i = 0 ; i<k ; i++){
           ans[i] = minHeap.peek();
           minHeap.remove();
       }
       
      Arrays.sort(ans); // for sort 
      
      for(int i = 0 ; i<k/2 ;i++){ // for decending
          int temp = ans[i];
          ans[i] = ans[k-i-1];
          ans[k-i-1] = temp;
      }
      
      //import java.util.*;
     // Arrays.sort(array, Collections.reverseOrder()); it doesn't work here

        
        return ans;
    }
}