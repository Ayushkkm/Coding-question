class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> arr = new ArrayList<>();

        int n = nums1.length;
        int m = nums2.length;

        int i = 0 ; 
        int j = 0;

        while (i < n && j < m) { // don't use if{} if{} , use if{} else if{} -> if(correct) -> i++ -> now second if -> use new i -> break loop
          if (nums1[i] < nums2[j]) {

            i++;
          } else if (nums1[i] > nums2[j]) {

            j++;
          } else {

            arr.add(nums1[i]);
         
              i++;
              j++;
         }
}
       
       int arr1[] = new int[arr.size()];

       for(int k = 0 ;  k< arr.size(); k++){
        arr1[k] = arr.get(k);
       }

       return arr1;

    }
}


