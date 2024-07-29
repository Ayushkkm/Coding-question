class Solution
{
     long floorSqrt(long x)
	 {
	
	    long start = 0 ;
	    long end = x; // or x/2 -> if(x==1) -> return x
	    
	    long ans = -1;
	    
	    while(start <= end){
	        
	        long mid = start + (end-start)/2;
	        
	        if(mid*mid == x){
	            return mid;
	        }
	        
	        else if(mid*mid < x){ // x is greater -> store -> floor
	            ans = mid ;
	            start = mid+1;
	        }
	        
	        else{
	            end = mid-1;
	        }
	    }
	    
	    return ans;
	 }
}

// TC -> O(logN)
// SC -> O(1)


class Solution
{
     long floorSqrt(long x)
	 {
	    long val = 0;
	    
		for(int i =1 ; i*i<=x ;i++){
		    val = i;
		}
		
		return val;
	 }
}

// TC -> O(N)
// SC -> O(1)