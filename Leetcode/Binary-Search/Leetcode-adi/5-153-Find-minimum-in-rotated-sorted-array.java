class Solution {

    // Both solution beat 100 % 

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

    public int findMin(int[] nums) {
        int k = k_find_in_rotated_array(nums);

        // For Anti clock wise -> length - min 
        // For clock wise -> number of times array is rotated -> min index

        return  nums[k]; 
    }
}


// class Solution {
//     public int findMin(int[] nums) {
//         int l = 0;
//         int r = nums.length -1;
//         int result = nums[0];
       
//        // Blind but my code , next time improve it.

//         while(l<=r){
//             if(nums[l]>nums[r]){
//             result = Math.min(result,nums[r]);
//             int mid = (l+r)/2;

//             result = Math.min(result,nums[mid]);
//             if(nums[l]<nums[mid]){ // it means l-mid is sorted, for min we need to check other
//                 l = mid+1;
//             }
//             else{ // it means mid - r is sorted
//                 r = mid-1;
//             }
//         }
//         else{
//              result = Math.min(result,nums[l]);
//             int mid = (l+r)/2;
            
//             // Hame mid tho lena hoga, sorted or rotated sorted , otherwise time exceed come
//             // r = mid-1;

//             // Ek bar sorted array me aa gya tho , l is min . While loop end
//             r = l-1;

           
//         }
//         }
//         return result;
//     }
// }