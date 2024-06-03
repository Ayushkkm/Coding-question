/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {


    public static int binarySearch(MountainArray arr,int start , int end , int k){

        while(start<=end){
            int mid = start + (end-start)/2;
            int val = arr.get(mid) ;
            if(val==k){
                return mid ;
            }
            else if(val>k){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }

        return -1;
    }

    public static int BS_decending(MountainArray arr,int start , int end ,int k){

        while(start<=end){
            int mid = start + (end-start)/2;
            int val = arr.get(mid) ;

            if(val==k){
                return mid ;
            }
            else if(val>k){
                start= mid+1;
            }
            else{
                end = mid-1;
            }
        }

        return -1;
    }
    public static int Max_Bitonic_Element(MountainArray arr){
        int start = 0 ;
        int end = arr.length() -1;
        int n = arr.length() -1;
 

        while(start <= end){
         int mid = start + (end-start)/2;
      
         int val = arr.get(mid) ; // MountainArray.get -> not get -> more than 100

         int valP = -1 ; 
         int valN = -1;
         if(mid>0) valP = arr.get(mid-1);
         if(mid<n) valN = arr.get(mid+1);

            if(mid>0 && mid<n){ // check -> mid is not at -> 0th index -> and n-1 index
                if(val>valP && val > valN){
                    return mid;
                }
                else if(valP>val){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            else if(mid==0){
                if(val>valN){ // This is case -> where -> start and end -> 0th index and 1st index
                    return 0;
                }
                else {
                    return 1;
                }
            }
            else{ // mid == n-1
                if(val>valP){ // // This is case -> where -> start and end -> n-2th index and n-1st index
                    return mid;
                }
                else{
                    return mid-1;
                }
            }
        }
        return -1;
    }

    public static int Search_on_bitonic(MountainArray arr, int k){
        int idx = Max_Bitonic_Element(arr);

        int idx1 = binarySearch(arr,0,idx-1,k);
        int idx2 = BS_decending(arr, idx , arr.length()-1,k);

        return idx1 == -1 ? idx2 : idx1;

    }

    
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int idx = Search_on_bitonic( mountainArr,target);

        return idx;
    }
}

// Method 2

// class Solution {

//     // Helper function to find the peak index in the mountain array
//     public static int findPeakIndex(MountainArray mountainArr) {
//         int start = 0;
//         int end = mountainArr.length() - 1;

//         while (start < end) {
//             int mid = start + (end - start) / 2;
//             if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
//                 start = mid + 1;
//             } else {
//                 end = mid;
//             }
//         }
//         return start;
//     }

//     // Helper function to perform binary search in the ascending part
//     public static int binarySearchAsc(MountainArray mountainArr, int start, int end, int target) {
//         while (start <= end) {
//             int mid = start + (end - start) / 2;
//             int midValue = mountainArr.get(mid);
//             if (midValue == target) {
//                 return mid;
//             } else if (midValue < target) {
//                 start = mid + 1;
//             } else {
//                 end = mid - 1;
//             }
//         }
//         return -1;
//     }

//     // Helper function to perform binary search in the descending part
//     public static int binarySearchDesc(MountainArray mountainArr, int start, int end, int target) {
//         while (start <= end) {
//             int mid = start + (end - start) / 2;
//             int midValue = mountainArr.get(mid);
//             if (midValue == target) {
//                 return mid;
//             } else if (midValue > target) {
//                 start = mid + 1;
//             } else {
//                 end = mid - 1;
//             }
//         }
//         return -1;
//     }

//     public int findInMountainArray(int target, MountainArray mountainArr) {
//         int peakIndex = findPeakIndex(mountainArr);

//         // Search in the ascending part
//         int idx1 = binarySearchAsc(mountainArr, 0, peakIndex, target);
//         if (idx1 != -1) {
//             return idx1;
//         }

//         // Search in the descending part
//         int idx2 = binarySearchDesc(mountainArr, peakIndex + 1, mountainArr.length() - 1, target);
//         return idx2;
//     }
// }