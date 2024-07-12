class Solution
{
    // Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high)
    {
        if (low < high) {
            int pidx = partition(arr, low, high);
            
            quickSort(arr, low, pidx - 1);
            quickSort(arr, pidx + 1, high);  // Corrected partition index range for the right part
        }
    }

    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        i++;
        int temp = arr[high];
        arr[high] = arr[i];
        arr[i] = temp;  // Correctly swap pivot with element at partition index
        
        return i;
    }
}

// TC -> O(N*log(N))
// SC -> O(1)