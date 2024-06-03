class Solution 
{
    
    public static boolean isValid(int arr[] , int k , int mid){

        int student = 1;
        int sum = 0;

        for(int i = 0 ; i< arr.length ; i++){
            sum += arr[i];

            if(sum>mid){
                student++;
                sum = arr[i];
            }

            if(student>k) return false;
        }
        return true;
    }

    public static int Allocate_Pages(int arr[] , int k ){
         //  start -> max element
        // end  -> sum of all element

        int start = Integer.MIN_VALUE;
        int end = 0;
        int ans = -1;

        if(k>arr.length) return -1; //

        for(int i = 0 ; i < arr.length ; i++){  // TC -> O(N)
            start = Math.max(start,arr[i]);
            end += arr[i];
        }

        while(start<= end){  // TC -> O(NlogN)  -> While loop + isValid
            int mid = start + (end-start)/2;

            if(isValid(arr,k,mid)){
                ans = mid;
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
      return ans;

    }
   
    
    public static int findPages(int[]A,int N,int M)
    
    {
       int minPages = Allocate_Pages(A,M);
       
       return minPages;
    }
};