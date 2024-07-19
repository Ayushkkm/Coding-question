
class Solution {
    public void setZeroes(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;

        int col = 1 ; // for column 0 -> if anyone is 0 -> make col = 0

        for(int i = 0 ; i < n ; i++){ // for -> mark 0 -> in row0 and col0
           
            for(int j = 0 ; j < m ; j++){

                if(matrix[i][j]==0){
                    matrix[i][0] = 0;

                    if(j!=0){
                        matrix[0][j] = 0;
                    }
                    else{
                        col = 0;
                    }
                }
            }
        }

        for(int i = 1 ; i < n ; i++){
            for(int j = 1 ; j< m ; j++){

                if(matrix[i][j] != 0){

                    if(matrix[i][0] == 0 || matrix[0][j] ==0){
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        if(matrix[0][0]==0){ // put this first -> of col -> if -> col use first -> it make -> matrix[0][0] = 0 -> which make whole row0 = 0

          for(int j = 0 ; j< m ; j++){
            matrix[0][j] = 0;
          }

        }


        if(col == 0){ // for col0 -> make all zero
            for(int i = 0 ; i< n ; i++){
                matrix[i][0] = 0;
            }
        }

        
    }
}

// TC -> O(2*N*M)
// SC -> O(1)

// More easy code

class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int row = 0;
        int col =0;

        for(int i =0; i<n ;i++){
            if(matrix[i][0]==0){
                row =1;
            }
        }
        
        for(int i =0; i<m ;i++){
            if(matrix[0][i]==0){
                col =1;
            }
        }

        for(int i =1;i<n;i++){
            for(int j =1;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = n-1;i>=1;i--){
            for(int j = m-1;j>=1;j--){
                if(matrix[i][0]==0 || matrix[0][j] ==0){
                    matrix[i][j]=0;
                }
            }
        }

        if(row == 1){
            for(int i = 0; i<n;i++){
                matrix[i][0] = 0;
            }
        }

        if(col == 1){
            for(int i = 0; i<m;i++){
                matrix[0][i] = 0;
            }
        }

        
    }
}

// TC -> O(2*N*M)
// SC -> O(1)
