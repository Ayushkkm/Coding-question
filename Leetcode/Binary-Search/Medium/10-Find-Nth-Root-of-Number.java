class Solution
{
    public int NthRoot(int n, int m)
    {
        int ans = -1;
        
        int start = 0;
        
        int end = m ;
        
        while(start <= end){
            
            int mid = start + (end-start)/2;
            
            int pow = (int)Math.pow(mid , n);
            
            if(pow == m){
                ans = mid;
                return ans;
            }
            
            else if(pow > m){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        
        return ans;
    }
}

// TC -> O(NlogN)
// SC -> O(1)
