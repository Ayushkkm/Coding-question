
class Solution
{
    void merge(int arr[], int l, int m, int r)
    {
         int mergeA[] = new int[r-l+1];
         int idx1= l;
         int idx2 = m+1 ;
         int x = 0;
         
         while(idx1<=m && idx2<=r){
             if(arr[idx1]>arr[idx2]){
                 mergeA[x++] = arr[idx2++];
             }
             else{
                 mergeA[x++] = arr[idx1++];
             }
         }
         
         while(idx1<=m){
             mergeA[x++] = arr[idx1++];
         }
         
         while(idx2<=r){
             mergeA[x++] = arr[idx2++];
         }
         
         for(int i = 0 , j = l ; i<mergeA.length ; i++ , j++){
             arr[j] = mergeA[i]; 
         }
    }

    void mergeSort(int arr[], int l, int r)
    {
        if(l>=r) return ;
        
        int m = l + (r-l)/2;
        
        mergeSort(arr,l,m);
        mergeSort(arr,m+1,r);
        merge(arr,l,m,r);
    }
}

// TC -> O(NlogN)
// SC -> O(N)
