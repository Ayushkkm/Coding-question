class Solution {
    public int jump(int[] nums) {
        
     int n = nums.length;
     int l = 0;
     int r = 0;
     int jumps = 0;

     while(r<n-1){
        int farPoint =0 ;

        for(int i = l ; i<=r ; i++){
            farPoint = Math.max(farPoint,i+nums[i]);
        }

        l = r+1;
        r = farPoint;
        jumps++;

     }

     return jumps;
     

    }
    // TC -> O(N) -> r-> got increase -> for loop cover element -> between l and r
}