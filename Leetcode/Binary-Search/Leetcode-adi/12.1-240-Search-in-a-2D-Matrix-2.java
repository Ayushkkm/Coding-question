class Solution {
    public static void D2_Search(int arr[][],int ans[],int k ){

        int i = 0;
        int m = arr[0].length;
        int n = arr.length;
        int j = m-1;

        while(i>=0 && i< n && j>=0 && j<m){
            if(arr[i][j]==k){
                ans[0] = i;
                ans[1] = j;
                return;
            }
            else if(arr[i][j]>k){
                j--;
            }
            else{ // k> arr[i][j]
                i++;
            }

        }
    }

    
    public boolean searchMatrix(int[][] matrix, int target) {

      int ans[] = {-1,-1};

      D2_Search(matrix,ans,target);

      if(ans[0]==-1 || ans[1] == -1) return false;

      return true ;

        
    }
}