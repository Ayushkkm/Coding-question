class Solution {
    
    public boolean possible( int day , int bloomDay[] , int m , int k){

        int count = 0 ;
        int bouquet = 0;

        for(int i = 0 ; i < bloomDay.length ; i++){

            if( bloomDay[i] <= day){ // flower -> bloom
              count++;
            }
            else{ // consequtive -> flower -> are -> not 
               
               bouquet += count/k;
               count = 0;

            }
        }

        bouquet += count/k; // in last -> all -> consequtive -> loop -> end -> add to bouquet

        if(bouquet >= m){
            return true;
        }

        return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {

        if(bloomDay.length < m*k){
            return -1;
        } 
        
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        
        int ans = -1;
        
        for(int i = 0 ; i < bloomDay.length ; i++){
          
           start = Math.min(start , bloomDay[i]);
           end = Math.max(end , bloomDay[i]);

        }

        while(start <= end){
            
            int mid = start + (end - start)/2;

            if(possible(mid , bloomDay , m , k)==true){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }

        return ans;

    }
}

// TC -> O(N*log(max-min))
// SC -> O(1)
