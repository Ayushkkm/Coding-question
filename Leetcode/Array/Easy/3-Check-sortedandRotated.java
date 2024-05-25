class Solution {

    public boolean checkarr(int arr[] , int num[]){
        for(int i = 0 ; i<arr.length ; i++){
            if(arr[i]!=num[i]) return false;
        }

        return true;
    }

    public void sort(int arr[]){
        Arrays.sort(arr);
    }  

    public void reverse(int arr[], int l , int r){
        while(l<r){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    public void rotate(int arr[] , int k){
        k = k % arr.length;
        
        reverse(arr,0 , arr.length - k -1);
        reverse(arr, arr.length-k , arr.length -1);
        reverse(arr,0,arr.length-1);

    } 

    public boolean check(int[] nums) {

      int n = nums.length;  
      int arr[] = new int[n] ;

      // for sort array
      for(int i = 0 ; i < n ; i++){
       arr[i] = nums[i];
      }

      sort(arr);

      // for k = 0 
      if(checkarr(arr,nums)) return true ;

      int count = 1; // k=0 already check
      
      while(count<n){
        rotate(nums,1); // nums rotate by 1 always.

        if(checkarr(arr,nums)) return true ;
        count++;

      }

      return false;


    }
}