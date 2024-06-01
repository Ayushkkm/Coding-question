
public class Q13_Index_Of_First_1_in_Binary_Sorted_Infinite_Array {

    public static int first_Occurrance(int arr[],int start , int end ,int k){

        int ans = -1;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(arr[mid]==k){
                ans = mid;
                end = mid-1;
            }
            else if(arr[mid]>k){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }

        return ans;
    }
    public static int Find_Infinite_Sorted_Array(int arr[]){
        int start = 0;
        int end = 1;
        int k = 1; // given in question

        while(k>arr[end]){  // we get -> start and -> end
            start = end;
            end = 2*end;
        }

        return first_Occurrance(arr,start,end,k);

    }

    public static void main(String[] args) {
        int arr[] = {0,0,0,0,0,0,0,1,1,1,1,1,1};

        int a = Find_Infinite_Sorted_Array(arr);
        System.out.println(a);

    }
}
