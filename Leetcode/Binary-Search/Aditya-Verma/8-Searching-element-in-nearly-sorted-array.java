
public class Q8_Search_in_nearly_sorted_array {

    public static int BS_Nearly_Search(int arr[], int k){
        int start = 0 ;
        int end = arr.length -1;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(arr[mid]==k){
                return mid;
            }
            else if(mid-1 >= start && arr[mid-1]==k){ // check mid-1 condition
                return mid-1;
            }
            else if(mid+1<=end && arr[mid+1]==k){ // check condition of mid+1
                return mid+1;
            }
            else if (arr[mid]>k) {
                end = mid -2;
            }
            else {
                start = mid+2;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {5,10,30,20,40};
        int a = BS_Nearly_Search(arr,20);
        System.out.println(a);
    }
}
