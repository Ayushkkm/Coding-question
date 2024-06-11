class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int ans[] = new int[n];

        Arrays.fill(ans,1);

        for(int i = 1; i<n ; i++){ // loop -> left -> right
            if(ratings[i-1] < ratings[i]){
                ans[i] = ans[i-1] +1;
            }
        }

        int sum = 0;
        sum += ans[n-1];

        for(int i = n-2 ; i>=0 ; i--){
            if(ratings[i+1] < ratings[i]){
                ans[i] = Math.max(ans[i], ans[i+1] +1);
            }

            sum += ans[i];
        }

       return sum ;
    }
}

// TC -> 2N -> N
// SC -> N