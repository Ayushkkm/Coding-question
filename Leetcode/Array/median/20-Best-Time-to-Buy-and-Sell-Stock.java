class Solution {
    public int maxProfit(int[] prices) {
        
        int buy = prices[0];

        int maxProfit = 0;

        for(int i = 1 ; i < prices.length ; i++){
            
            if(buy > prices[i]){ // change buy
              buy = prices[i];
            }
            else{ // sell and -> check profit
               
               maxProfit = Math.max(maxProfit , prices[i] - buy);
            }
        }

        return maxProfit;
    }
}

// TC -> O(N)
// SC -> O(1)