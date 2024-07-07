class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int n = cardPoints.length;
        int lsum = 0 ; 
        int rsum = 0 ; 
        int sum = 0; 
        int maxSum = 0 ; 

        for(int i = 0; i < k ; i++){
            lsum += cardPoints[i];
        }

        maxSum = lsum;

        int ridx = n-1;

        for(int i = k-1 ; i>=0 ; i--){
            lsum = lsum - cardPoints[i];

            rsum = rsum + cardPoints[ridx];
            ridx = ridx -1;

            maxSum = Math.max(maxSum , lsum + rsum);
        }

        return maxSum;
    }
}
// TC -> O(2K)
// SC -> O(1)