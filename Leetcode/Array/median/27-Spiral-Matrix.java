class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int row = matrix.length;

        int col = matrix[0].length;

        int top = 0;
        int down = row - 1;
        
        int left = 0;
        int right = col -1;

        int dir = 0 ; // direction

        List<Integer> list = new ArrayList<>();

        while(top <= down && left <= right){

            if(dir==0){
                for(int i = left ; i <= right ; i++){
                    list.add(matrix[top][i]);
                }

                top++;
            }

            else if(dir==1){
                
                for(int i = top ; i<= down ; i++){
                    list.add( matrix[i][right] );
                }
                right--;
            }

            else if(dir==2){

                for(int i = right ; i >= left ; i--){ // large -> small -> i--
                    list.add( matrix[down][i] );
                }
                down--;
            }

            else if(dir==3){

                for(int i = down ; i >= top ; i--){ // large -> small -> i--
                    list.add( matrix[i][left] );
                }
                left++;
            }

            dir = (dir+1) % 4; // 0 -> 1 -> 2 -> 3 -> 0
        }

        return list;

    }
}

// TC -> O(N*M)
// SC -> O(N*M)