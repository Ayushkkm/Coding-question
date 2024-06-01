
public class Q18_Search_in_row_wise_and_column_wise_sorted_array {

    public static void D2_Search(int arr[][],int ans[],int k ){

        int i = 0;
        int m = arr[0].length;
        int j = m-1;

        while(i>=0 && i< m && j>=0 && j<m){
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

    public static void main(String[] args) {
      int arr[][] = {{10,20,30,40},{15,25,35,45},{27,29,37,45},{32,33,39,50}};

      int ans[] = {-1,-1};

      D2_Search(arr,ans,29);

      System.out.println(ans[0]+" "+ans[1]);
    }
}
