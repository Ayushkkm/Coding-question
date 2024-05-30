
public class Q3_Order_Agnostic_Search {

    public static int agnosticSearch(int arr[],int k){

        if(arr.length==1) return arr[0];

        boolean flag = false;

        if(arr[0]>arr[1]) flag = true; // check ascending order or decending order

        if(flag==true){ // decending order
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

        else{   // ascending order
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

    }
    public static void main(String[] args) {
        int arr[] = {20,17,15,14,13,12,10,9,8,4};
        int arr1[] = {1,2,3,4,5,6,7,8};

        int a = agnosticSearch(arr,4);
        int b = agnosticSearch(arr1,3);
        System.out.println(a+" "+ b);
    }
}
