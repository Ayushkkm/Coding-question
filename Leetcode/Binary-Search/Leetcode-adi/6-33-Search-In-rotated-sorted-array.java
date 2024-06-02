class Solution {

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

    public static int binarySearch(int arr[],int start , int end ,int k){

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

    public int search(int[] nums, int target) {
        int a = k_find_in_rotated_array(nums);
        int idx1 = binarySearch(nums, 0 , a-1,target);
        int idx2 = binarySearch(nums , a , nums.length-1,target);

        if(idx1==-1){
            return idx2;
        }
        else{
            return idx1;
        }

    }

    }

// class Solution {
//     public int search(int[] nums, int target) {
//         int l = 0;
//         int r = nums.length -1;
        
//         // Complete it 

//         while(l<=r){
//             mid =(l+r)/2; // we need mid for both nums[l]>nums[r] , nums[l]<nums[r]

//             if(target==nums[mid]) return mid;

//             if(nums[l]>nums[r]){ // rotated array

//                  if(nums[l]<nums[mid]){ // l to mid is sorted
                   
//                  } // l to mid is sorted
//             }
//         }

//     }
// }