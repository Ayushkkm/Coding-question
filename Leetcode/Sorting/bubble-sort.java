class Solution
{
    //Function to sort the array using bubble sort algorithm.
	public static void bubbleSort(int arr[], int n)
    {
       for(int i = 0 ; i < arr.length-1 ;i++){ // n-1
           for(int j = 0 ; j< arr.length - i - 1 ;j++){ // leave last sorted index
               if(arr[j]>arr[j+1]){
                   int temp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1] = temp;
               }
           }
       }
    }
}

// TC -> O(N^2)
// SC -> O(1)