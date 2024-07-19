class Solution {

    public void rotate(int[][] matrix) {
        
        // Square Matrix

        int n = matrix.length;
        int m = matrix[0].length; // for -> general matrix

        // Transpose

        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < m ; j++){
               
               int temp = matrix[i][j]; // swap

               matrix[i][j] = matrix[j][i];
               matrix[j][i] = temp;
            }
        }

        // Reverse

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j <m/2 ; j++){

                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][m-j-1];

                matrix[i][m-j-1] = temp;
            }
        }

    }
}

// TC -> O(N*M/2) + O(N*M/2)
// SC -> O(1)