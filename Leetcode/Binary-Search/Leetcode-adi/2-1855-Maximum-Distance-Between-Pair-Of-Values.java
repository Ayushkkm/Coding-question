class Solution {

    // Beat 13 % user
    public int find_index(int nums[] , int start , int k){
        
        int end = nums.length-1;

        while(start<=end){
           
           int mid = start + (end-start)/2;

           if(nums[mid]>=k){  // nums[mid]==k -> duplication -> move right
                start = mid+1;
           }
           else {  // k > nums[mid]
            end = mid-1;
           }

        }

        return end; // give ceil -> value -> greater than -> k -> more far from 0th index -> comparasion -> to other greater value
    }

    public int maxDistance(int[] nums1, int[] nums2) {
        
            int maxP = 0;

            for(int i = 0 ; i<nums1.length ; i++){

                int idx = find_index(nums2,i,nums1[i]); // idx work as j

                if(idx-i > maxP){
                    maxP = Math.max(maxP,idx-i);
                }
            }
            return maxP;
    }
}