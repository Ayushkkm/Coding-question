
public class Q19_Allocate_Minimum_Number_Of_Pages {

    public static boolean isValid(int arr[] , int k , int mid){

        int student = 1;
        int sum = 0;

        for(int i = 0 ; i< arr.length ; i++){
            sum += arr[i];

            if(sum > mid){ // if page greater -> than limit -> go to next -> student
               
                student++;
                sum = arr[i];
            }

            if(student>k) return false; // student < k -> this condition -> check previously -> if(k>arr.length) return -1;
        }
        return true;
    }

    public static int Allocate_Pages(int arr[] , int k ){

        // start -> max element
        // end  -> sum of all element

        int start = Integer.MIN_VALUE;
        int end = 0;
        int ans = -1;

        if(k>arr.length) return -1; // student > books -> not solution

        for(int i = 0 ; i < arr.length ; i++){  // TC -> O(N)
            start = Math.max(start,arr[i]);
            end += arr[i];
        }

        while(start<= end){  // TC -> O(NlogN)  -> While loop + isValid

            int mid = start + (end-start)/2;

            if(isValid(arr,k,mid)){ // if mid -> valid -> mid -> to high can go -> for less page -> move left 
              
                ans = mid;  
                end = mid-1; // go -> left
            }

            else {  // if pages -> is not sufficient -> move right -> for more pages
                         
                start = mid+1;
            }
        }
        
      return ans;

    }
    public static void main(String[] args) {

        int arr[] = {10,20,30,40};

        int arr1[] = {10,5,20};

        int a = Allocate_Pages(arr,2);
        int b = Allocate_Pages(arr1,2);

        System.out.println(a + " " + b);  // TC -> O(NlogN)  -> While loop + isValid
    }
}
