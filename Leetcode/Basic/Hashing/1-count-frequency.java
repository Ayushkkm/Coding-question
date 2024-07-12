class Solution{
    //Function to count the frequency of all elements from 1 to N in the array.
    public static void frequencyCount(int arr[], int N, int P)
    {
      
      
       int hash[] = N>P ? new int[N] : new int[P]; // which is greater -> N or P -> make the array 
       
       
       for(int i = 0 ; i <N ;i++){
           hash[arr[i]-1]++; // Element -> start from 1 to P -> so make from 0
       }
         
      for(int i = 0 ; i <N;i++){
          arr[i] = hash[i];
      }
    }
}

// More clear -> count only -> less or equal to N

class Solution{
    
    public static void frequencyCount(int arr[], int N, int P)
    {
        int hash[] = new int[N + 1];

        // Count the -> frequencies of elements -> less than -> or equal to N
        
        for (int i = 0; i < N; i++) {
            if (arr[i] <= N) {
                hash[arr[i]]++;
            }
        }
       
        for (int i = 0; i < N; i++) {
            arr[i] = hash[i + 1]; // Start from 1 
        }
        
    }
}
