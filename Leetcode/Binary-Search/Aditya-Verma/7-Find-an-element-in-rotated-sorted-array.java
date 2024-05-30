
public class Q7_Find_an_element_in_rotated_sorted_array {
    public static int k_find_in_rotated_array(int arr[]){
        int start = 0 ;
        int end = arr.length-1;
        int N = arr.length;

        while(start<=end){
            if(arr[start]<arr[end]) { // if array become sorted -> after 1 iteration-> it become -> sorted
                return start;
            }
            int mid = start + (end-start)/2;
            int next = (mid+1) % N ;
            int prev = (mid-1+ N ) % N ;

            if(arr[mid]<=arr[prev] && arr[mid]<=arr[next]){
                return mid ;
            }
            else if(arr[start]<=arr[mid]){ // search in unsorted array
                start = mid+1;
            }
            else if (arr[mid]<=arr[end]){
                end = mid-1;
            }
        }

        return -1;
    }

    public static int binarySearch(int arr[],int start , int end ,int k){

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

    public static int find_element(int arr[] , int k){

        int a = k_find_in_rotated_array(arr);
        int idx1 = binarySearch(arr, 0 , a-1,k);
        int idx2 = binarySearch(arr , a , arr.length-1,k);

        if(idx1==-1){
            return idx2;
        }
        else{
            return idx1;
        }

    }

    public static void main(String[] args) {
        int arr[] = {11,12,15,18,2,5,6,8};

        int a = find_element(arr,12);
        int b = find_element(arr,6);
        System.out.println(a+" "+ b);
    }
}
