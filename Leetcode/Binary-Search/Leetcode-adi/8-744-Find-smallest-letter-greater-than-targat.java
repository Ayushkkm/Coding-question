class Solution {

    public static char next_alphabet(char arr[] , char k){
        int start= 0;
        int end = arr.length -1;

        char ans = arr[0];

        while(start<=end){
            int mid = start + (end-start)/2;

            if(arr[mid]==k){
                start = mid+1; // in case of repeat character
            }
            else if(arr[mid]>k){
                ans = arr[mid];
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }

        return ans;
    }

    
    public char nextGreatestLetter(char[] letters, char target) {
         char character = next_alphabet(letters,target);
         return character;
    }
}