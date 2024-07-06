class solution{

    public int constantWindow(int arr[] , int k){
        
        int sum = 0;

        for(int i = 0 ; i < k ; i++){
            sum += arr[i];
        }

        int maxSum = sum;

        for(int i = k ; i < arr.length ; i++){
            sum -= arr[i-k]; 
            sum += arr[i];

            maxSum = Math.max(maxSum , sum);
        }

        return maxSum;
        
    }
}

// Using Two pointer l and r

class public{

    public int constantWindow(int arr[] , int k){
        
        
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        // Initializing the sum of the first window of size k
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        maxSum = sum;

        // Initialize the two pointers
        int l = 0;
        int r = k;

        // Slide the window using the two pointers
        while (r < arr.length) {
            sum += arr[r] - arr[l];
            maxSum = Math.max(maxSum, sum);
            l++;
            r++;
        }

        return maxSum;
        
    }
}