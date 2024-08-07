class Solution {

    public boolean check(int capacity , int arr[] , int days){
        
        int sum = 0;
        int day = 1;

        for(int i = 0 ; i < arr.length ; i++){
            
            if(sum + arr[i] <= capacity){ // we have -> capacity
                sum += arr[i];
            }

            else{ // we don't have -> capacity
                  
                  sum = arr[i];
                  day++;
            }

            // int sum = arr[0]; // this give wrong -> answer
            // int day = 1;

            // for (int i = 1; i < arr.length; i++) {
            //  if (sum <= capacity) { // This is the faulty condition
            // sum += arr[i];
            // } else {
            // sum = arr[i];
            // day++;
            //  }

        }

        if(day <= days){
            return true;
        }

        return false;

    }

    public int shipWithinDays(int[] weights, int days) {

        int n = weights.length;

        int start = Integer.MIN_VALUE; // start -> max -> value -> each -> item -> take 1 day -> to fill
        int end = 0; // sum -> of all -> weights -> then -> need -> 1 day

        for (int i = 0; i < n; i++) {
            start = Math.max(start, weights[i]);

            end += weights[i];
        }

        int ans = 0;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (check(mid, weights, days) == true) { // curr capacity -> or more -> is valid -> need -> minimum capicity

                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
}

// TC -> O(N*log(sum(weights)))
// SC -> O(1)