class Solution {

    public int getchar(char ch){
        switch(ch){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default : return 0 ;
        }
    }
    public int romanToInt(String s) {
        int n =s.length();
        int sum = 0 ;

        for(int i = 0 ; i<n ; i++){
            char ch = s.charAt(i);

            if(i+1<n && getchar(ch)< getchar(s.charAt(i+1))){
                sum -= getchar(ch);
            }
            else{
                sum += getchar(ch);
            }
        }

        return sum;
    }
}