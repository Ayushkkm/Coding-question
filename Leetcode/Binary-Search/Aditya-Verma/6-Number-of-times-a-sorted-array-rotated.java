
public class Q6_Number_of_times_a_sorted_array_is_rotated {
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

    public static void main(String[] args) {
        int arr[] = {11,12,15,18,2,5,6,8};

        int a = k_find_in_rotated_array(arr);
        System.out.println(a);
    }
}
