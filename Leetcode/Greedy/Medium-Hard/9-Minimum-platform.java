class Solution
{
    static int findPlatform(int arr[], int dep[], int n)
    {
        // GFG      
    
      Arrays.sort(arr);
      Arrays.sort(dep);
      
      int count = 0 ;
      int max  = 0;
      int i = 0 ; // Two pointers
      int j = 0 ;
      
      while(i<n && j<n){
          if(arr[i]<=dep[j]){ // Train arrive 
              count++;
              max = Math.max(count,max);
              i++;
          }
          else {  // arr[i] > dep[i] -> Train depart
              count--;
              j++;
          }
      }
      
      return max;
        
    }
    
}

// TC -> O(N)
// SC -> O(1)