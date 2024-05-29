class Solution {

    class Pair{
        char cha;
        int count;

         Pair(char ch , int count){
            this.cha = ch;
            this.count = count;
         }
    }

    public String frequencySort(String s) {

     // small(97-122) , capital(65-90) , digits(48-57)

     int hash[] = new int[125];

     // toCharArray -> convert to char array -> each element -> find

     for(char ch : s.toCharArray()){
        hash[ch]++;
     }  
    
     // Make frequncy check list for each character
     LinkedList<Pair> freq_lt = new LinkedList<Pair>();

     for(int i = 48 ; i< 125 ; i++){
        if(hash[i]>0){
            char ch = (char)i ;

            freq_lt.add(new Pair(ch,hash[i]));
        }
     }

    // sort in decending order -> for count

     Collections.sort(freq_lt , new Comparator<Pair>(){
        public int compare(Pair a , Pair b){
            return b.count - a.count;
        }
     });

     StringBuilder sb = new StringBuilder();

     for(Pair p : freq_lt){
        int j = p.count;

        while(j>0){ // add character wrt frequency
            sb.append(p.cha);
            j--;
        }
     }

     return sb.toString();
    
    }
}