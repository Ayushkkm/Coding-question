class Solution {

    public void dfs(int i, int j , int image[][], int oldcolor, int color,
    int drow[], int dcol[] , int ans[][]){
        ans[i][j] = color;

        int n = image.length;
        int m = image[0].length;

        for(int k = 0 ; k<4 ; k++){
            int row = i + drow[k];
            int col = j + dcol[k];

            if(row>=0 && row< n  && col >=0 && col<m && image[row][col]==oldcolor 
            && ans[row][col]!= color ){ // it's -> check -> visited or not
                
                dfs(row,col,image,oldcolor , color , drow, dcol , ans);
            } 

        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldcolor = image[sr][sc];
        
        int n = image.length;
        int m = image[0].length;
             
        int ans[][] = image;

        int drow[] = {-1, 0 , 1, 0};
        int dcol[] = {0, 1 ,0 , -1};

       dfs(sr,sc ,image, oldcolor , color , drow , dcol , ans);

       return ans;


    }
}

// TC -> O(N*M)
// SC -> O(N*M) -> stack -> ans[][]
