
public class Q16_Find_Maximum_element_in_Bitonic_array {

    public static int Max_Bitonic_Element(int arr[]){
        int start = 0 ;
        int end = arr.length -1;
        int n = arr.length -1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(mid>0 && mid<n){ // check -> mid is not at -> 0th index -> and n-1 index
                if(arr[mid]>arr[mid-1] && arr[mid] > arr[mid+1]){
                    return mid;
                }
                else if(arr[mid-1]>arr[mid]){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            else if(mid==0){
                if(arr[mid]>arr[mid+1]){ // This is case -> where -> start and end -> 0th index and 1st index
                    return 0;
                }
                else {
                    return 1;
                }
            }
            else{ // mid == n-1
                if(arr[mid]>arr[mid-1]){ // // This is case -> where -> start and end -> n-2th index and n-1st index
                    return mid;
                }
                else{
                    return mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1,3,8,12,4,2};
        int a = Max_Bitonic_Element(arr);

        System.out.println(a);
    }
}
