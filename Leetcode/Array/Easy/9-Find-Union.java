class Solution
{
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        ArrayList<Integer> arr = new ArrayList<>();
        
        int i = 0 ; 
        int j =0;
        
        while(i<n && j <m){
           if(arr1[i]<arr2[j]){
               if(arr.size()==0 || arr.get(arr.size()-1)!= arr1[i]){
                   arr.add(arr1[i]);
               }
               i++;
           }
           else{
               if(arr.size()==0 || arr.get(arr.size()-1)!= arr2[j]){
                   arr.add(arr2[j]);
               }
               j++;
           }
        }
        
        while(i<n){
            if(arr.size()==0 || arr.get(arr.size()-1)!= arr1[i]){
                   arr.add(arr1[i]);
               }
               i++;
        }
        
        while(j<m){
            if(arr.size()==0 || arr.get(arr.size()-1)!= arr2[j]){
                   arr.add(arr2[j]);
                   }
               j++;
        }
        
        return arr;
        
        
    }
}