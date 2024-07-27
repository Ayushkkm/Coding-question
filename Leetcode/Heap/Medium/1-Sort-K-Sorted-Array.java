class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
              
       PriorityQueue<Integer> minHeap = new PriorityQueue<>();
       
       for(int i = 0 ; i < K ; i++){
           for(int j = 0 ; j < K ; j++){
               
               minHeap.add(arr[i][j]);
           }
       }
       
       ArrayList<Integer> list = new ArrayList<>();
       
       while(!minHeap.isEmpty()){
           
           list.add(minHeap.remove());
       }
       
       return list;
        
        
    }
}

// TC -> O(k^2*Log(k))
// SC -> O(K^2)