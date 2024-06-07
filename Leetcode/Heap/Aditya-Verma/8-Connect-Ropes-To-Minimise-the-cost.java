class Solution
{
    //Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n) 
    {
        // GFG
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        long cost=0;
        
        for(int i = 0 ; i<n ; i++){
            minHeap.add(arr[i]);
        }
        
        while(minHeap.size()>=2){
            long first = minHeap.peek();
            minHeap.remove();
            
            long second = minHeap.peek();
            minHeap.remove();
            
            cost = cost + first+second;
            
            minHeap.add(first+second); // add length first and second
            
        }
        
        return cost;
    } 
}