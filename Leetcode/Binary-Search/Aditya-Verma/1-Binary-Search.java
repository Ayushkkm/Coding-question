public class Q1_Binary_Search {

    public static int binarySearch(int arr[],int k){
        int start = 0 ;
        int end = arr.length-1; 

        while(start<=end){
            int mid = start + (end-start)/2;

            if(arr[mid]==k){
                return mid ;
            }
            else if(arr[mid]>k){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};

        int a = binarySearch(arr,3);
        System.out.println(a);
    }
}
