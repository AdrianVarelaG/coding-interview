package arrays;

public class OneAway {
    
    public static void main(String[] args) {
        OneAway oa = new OneAway();

        System.out.println("pale, ple   ->" + oa.oneAway("pale", "ple"));
        System.out.println("pales, pale ->" + oa.oneAway("pales", "pale"));
        System.out.println("paale, pale ->" + oa.oneAway("paale", "pale"));
        System.out.println("pale, bale  ->" + oa.oneAway("pale", "bale"));
        System.out.println("pale, bake  ->" + oa.oneAway("pale", "bake"));
    }

    public boolean oneAway(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int count = 0;

        if(word1.length() == word2.length()) { //sustitude
            for(int i = 0; i < word1.length(); i++) {
                if(w1[i] != w2[i]) 
                    count ++;
            }
        }else if(word1.length() - word2.length() == 1 ) { // insert
            for(int i = 0; i < word2.length() && count < 2; i++) {
                if(w1[i+count] != w2[i]) {
                    count ++;
                }
            }
            if(count ==0) count ++;
        }else if(word1.length() - word2.length() == -1) { // remove
            for(int i = 0; i < word1.length() && count < 2;i++) {
                if(w2[i+count] != w1[i])
                    count ++;
            }
            if(count ==0) count ++;
        }

        return count == 1;
    }
}