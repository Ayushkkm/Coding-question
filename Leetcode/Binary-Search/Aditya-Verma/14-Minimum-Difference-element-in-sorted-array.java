
public class Q14_Minimum_Difference_Between_Two_Sorted_Array {
  
    // This code can also use to find floor and ceil values of k
    public static int Minimum_Diffrenece(int arr[] , int k){
        int start = 0;
        int end = arr.length -1;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(arr[mid]==k){
                return arr[mid]; // which give min value
            }
            else if(arr[mid]>k){
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }

        int minS = Math.abs(arr[start]-k); // arr[start] = ceil of k
        int minE = Math.abs(arr[end]-k); // arr[end] = floor of k

        return minS>minE ? arr[end] : arr[start];

    }

    public static void main(String[] args) {
     int arr[] = {1,3,8,10,15};
     int a = Minimum_Diffrenece(arr,12);
        System.out.println(a);
    }
}
