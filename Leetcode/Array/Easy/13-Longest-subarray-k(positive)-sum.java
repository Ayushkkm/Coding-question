class Solution{
       
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int A[], int N, int K) {
      
      
      int sum = A[0];
      int r = 0 ;
      int l = 0;
      int maxL = 1;
      
      while(r<N){
          
          while(l<r && sum>K){
              sum -= A[l];
              l++;
          }
          
          if(sum==K){
              maxL = Math.max(maxL,r-l+1);
          }
          
           r++;
           if(r<N) sum += A[r];
          
          
      }
      
      return maxL;
}
  
}
