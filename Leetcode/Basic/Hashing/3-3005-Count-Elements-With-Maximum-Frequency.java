
class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n = nums.length; 
        int max = nums[0];

        for(int i = 1 ; i < n; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }

        int hash[] = new int[max+1];

        for(int i = 0; i< n ; i++){
            hash[nums[i]]++;
        }

        max = hash[0];
        int count = 0;

        for(int i = 0 ; i < hash.length ; i++){
             if(hash[i] > max){
                max = hash[i];
             }
        }

        for(int i = 0; i < hash.length ; i++){
            if(max == hash[i]){
                count += max;
            }
        }

        return count;
    }
}