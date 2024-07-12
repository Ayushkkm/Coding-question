class Solution
{
  public void insertionSort(int arr[], int n)
  {
      for(int i = 1 ; i <n;i++){ // take unsorted part and arr[0] = sorted
          int current = arr[i];
          
          int j = i-1;
          
          while(j>=0&& current < arr[j]){ // check in sorted part
              arr[j+1] = arr[j];
              j--;
          }
          
          arr[j+1] = current;
               
      }
  }
}

// TC -> O(N^2)
// SC -> O(1)