class Solution{
    //Function to count the frequency of all elements from 1 to N in the array.
    public static void frequencyCount(int arr[], int N, int P)
    {
      
       int hash[] = N>P ? new int[N] : new int[P];
       
       for(int i = 0 ; i <N ;i++){
           hash[arr[i]-1]++;
       }
       
     
      for(int i = 0 ; i <N;i++){
          arr[i] = hash[i];
      }
    }
}
