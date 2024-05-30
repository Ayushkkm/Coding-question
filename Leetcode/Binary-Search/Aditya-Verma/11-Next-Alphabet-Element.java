
public class Q11_Next_Alphabet_element {

    public static char next_alphabet(char arr[] , char k){
        int start= 0;
        int end = arr.length -1;

        char ans = '#';

        while(start<end){
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

    public static void main(String[] args) {
        char letter[] = {'a','b','c','f','h','i'};

        char a = next_alphabet(letter,'f');
        System.out.println(a);

    }
}
