class Solution {
    int print2largest(int arr[], int n) {
       
       int fmax = arr[0];
       int smax = -1;
       
       for(int i = 0 ; i < n ; i++){
           if(arr[i]>fmax){
               smax = fmax;
               fmax = arr[i];
           }
           
           if(arr[i]>smax && arr[i]!=fmax){
               smax = arr[i];
           }
       }
       
       return smax;
    }
}

// TC -> O(n)
// SC -> O(1)