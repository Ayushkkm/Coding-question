void selectionSort(int arr[], int n)
	{
	    for(int i = 0 ; i<arr.length-1;i++){ // 0 to n-2
	        int small = i;
	        
	        for(int j = i+1 ; j<n;j++){ // check index after small
	            if(arr[small]>arr[j]){
	                small = j;
	            }
	        }
	        
	        int temp  = arr[i];
	        arr[i] = arr[small];
	        arr[small] = temp;
	    }
	}

// TC -> O(N^2)
// SC -> O(1)

