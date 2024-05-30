
public class Q5_count_of_element_in_sorted_array {
    public static int first_Occurrance(int arr[],int k){
        int start = 0 ;
        int end = arr.length-1;
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

    public static int last_Occurrance(int arr[],int k){
        int start = 0 ;
        int end = arr.length-1;
        int ans = -1;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(arr[mid]==k){
                ans = mid;
                start = mid+1;
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

    public static void main(String[] args) {
        int arr[] = {2,4,10,10,10,18,20};

        int first = first_Occurrance(arr,10);
        int last = last_Occurrance(arr,10);
        System.out.println(last-first+1);
    }
}
;
