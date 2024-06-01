
public class Q12_Find_Position_Of_Element_In_Infinite_Sorted_Array {

    public static int Find_Infinite_Sorted_Array(int arr[] ,int k){
        int start = 0;
        int end = 1;

        while(k>arr[end]){  // we get -> start and -> end
            start = end;
            end = 2*end;
        }

        while(start<=end){ // Apply normal BS
            
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
        int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

        int a = Find_Infinite_Sorted_Array(arr,7);
        System.out.println(a);

    }
}
