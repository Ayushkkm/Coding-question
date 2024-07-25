class Solution {


    static int findFloor(long arr[], int n, long x) {
        
        int start = 0;
        
        int end = n -1;
        
        int floor = -1;
        
        while(start <= end){
            
            int mid = start + (end - start)/2 ;
            
            if(arr[mid] == x){
                
                floor = mid;
                
                return floor ;
            }
            
            else if(arr[mid] < x){
                
                floor = mid;
                
                start = mid+1;
            }
            else {
                end = mid -1;
            }
        }
        
        return floor;
        
    }
    
}

// TC -> O(logN)
// SC -> O(1)