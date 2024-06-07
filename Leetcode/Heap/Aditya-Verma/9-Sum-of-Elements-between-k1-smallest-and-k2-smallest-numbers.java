class Solution { 
    
    public static long getValue(long arr[] , long k){
         // GFG
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0 ; i < arr.length ; i++){ // for loop -> only take int 
            maxHeap.add(arr[i]);
            
            if(maxHeap.size() > k){
                maxHeap.remove();
            }
        }
        
        return maxHeap.peek();
        
    }
    
    public static long sumBetweenTwoKth(long A[], long N, long K1, long K2)
    {
        long val1 = getValue(A, K1);
        long val2 = getValue(A, K2);
        
        long sum = 0 ;
        
        for(int i = 0 ; i < N ; i++){ // for loop -> only take int 
            if(A[i] > val1 && A[i] < val2){
                sum += A[i];
            }
        }
        
        return sum;
        
    }
    
}