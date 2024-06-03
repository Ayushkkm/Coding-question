class Solution {

    public static void D2_Search(int arr[][],int ans[],int k ){

        int i = 0;
        int n = arr.length;
        int m = arr[0].length;
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

           if(ans[0] ==-1 ||ans[1] ==-1) return false;

           return true;

    }
}

// Method 2

// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         if(matrix.length==0) return false;

//         int n = matrix.length;
//         int m = matrix[0].length;
        
//         int lo = 0;
//         int hi = n*m-1;

//         while(lo<=hi){
//             int mid = lo + (hi-lo)/2;

//             if(matrix[mid/m][mid%m]==target) return true;

//             if(matrix[mid/m][mid%m]<target) lo = mid+1;

//             if(matrix[mid/m][mid%m]>target) hi = mid-1;
//         }

//         return false;

//     }
// }