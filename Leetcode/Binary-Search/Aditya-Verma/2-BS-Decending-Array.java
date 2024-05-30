
public class Q2_BS_decending_array {

    public static int BS_decending(int arr[],int k){
        int start = 0 ;
        int end = arr.length-1;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(arr[mid]==k){
                return mid ;
            }
            else if(arr[mid]>k){
                start= mid+1;
            }
            else{
                end = mid-1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {20,17,15,14,13,12,10,9,8,4};

        int a = BS_decending(arr,4);
        System.out.println(a);
    }
}
