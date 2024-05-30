
public class Q10_Find_ceil_of_element_in_sorted_array {

    public static int ceil(int arr[] , int k){
        int start = 0;
        int end = arr.length-1;

        int ans = 0 ;

        while(start<=end){
            int mid= start + (end-start)/2;

            if(arr[mid]==k){
                return arr[mid];
            }
            else if(arr[mid]<k){
                start = mid+1;
            }
            else{  // arr[mid] > k -> chance of ceil -> take value -> move left
                ans = arr[mid];
                end = mid-1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,8,10,10,12,19};

        int a = ceil(arr,5);
        System.out.println(a);
    }
}
