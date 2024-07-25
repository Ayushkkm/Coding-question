class Solution {
    
   
    public int[] getFloorAndCeil(int x, int[] arr) {
        
        int n = arr.length;
        
        int[] ans = new int[2];
        Arrays.fill(ans, -1);
        
        int floor = Integer.MIN_VALUE;
        int ceil = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] <= x && arr[i] > floor) {
                floor = arr[i];
            }
            if (arr[i] >= x && arr[i] < ceil) {
                ceil = arr[i];
            }
        }
        
        if (floor != Integer.MIN_VALUE) {
            ans[0] = floor;
        }
        
        if (ceil != Integer.MAX_VALUE) {
            ans[1] = ceil;
        }
        
        return ans;
        
    }
}

// TC -> O(N)
// SC -> O(1)