class Solution {

    public long findHour(int arr[], long k){
        
        long totalHour = 0;
        
        for(int i = 0; i < arr.length; i++){
            totalHour += Math.ceil((double)arr[i] / (double)k); // we need decimal -> to find ceil
        }
        
        return totalHour;
    }

    public int minEatingSpeed(int[] piles, int h) {
        
        int n = piles.length;
       
        long start = 1; // Starting from 1 -> because Koko needs > to eat at least -> one banana per hour
        long end = 0;

        for(int i = 0; i < n; i++){ // Find max -> in the array
            end = Math.max(end, piles[i]);
        }

        long ans = end;

        while(start <= end){
           
            long mid = start + (end - start) / 2;
            
            long hour = findHour(piles, mid); // this in long -> otherwise -> overflow condition

            if(hour <= h){
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return (int) ans;
    }
}

// TC -> O(N*log(max(Array))) 
// SC -> O(1) 