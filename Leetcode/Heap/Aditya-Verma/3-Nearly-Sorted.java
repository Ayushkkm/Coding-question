class Solution
{
    //Function to return the sorted array.
    ArrayList <Integer> nearlySorted(int arr[], int num, int k)
    
    // GFG -> Nearly Sorted
    {
        ArrayList<Integer> ans = new ArrayList<>();
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int i = 0 ; i < arr.length ; i++){
            minHeap.add(arr[i]);
            
            if(minHeap.size()==k+1){  // i =0 -> to  i = 3 check -> 4 element -> k+1 -> then i =1 -> to i = 4
                ans.add(minHeap.peek());
                minHeap.remove();
            }
        }
           
        while(!minHeap.isEmpty()){  // Array finish -> remaining -> element in heap put
             ans.add(minHeap.peek());
                minHeap.remove();
        }
        
        return ans;
    }
}
