package arrays;


public class PalindromePermutation {

    public static void main(String[] args) {
        PalindromePermutation pp = new PalindromePermutation();
        
        String text = "Tact Coa";
        System.out.println(text + " |" + pp.isPalindrome(text));
    }

    public boolean isPalindrome(String phase) {

        char[] charPhase = phase.toLowerCase().toCharArray();
        int[] counter = new int[128];

        int size = countCharacters(counter, charPhase);
        int allowMissingChar = size % 2;

        for(int i = 0; i< 128 && allowMissingChar >= 0; i++) {
            allowMissingChar -= (counter[i]%2);
        }

        return allowMissingChar >= 0;
    }

    protected int countCharacters(int[] counter,  char[] phase) {
        int size = 0;

        for(int i = 0; i < phase.length; i++ ) {
            char c= phase[i];
            if(!specialCaharacter(c)) {
                counter[(int) c] ++;
                size ++;
            }
        }
        return size;
    }

    protected boolean specialCaharacter(char c) {
        boolean special = false;

        if(c == ' ' ) return true;

        return special;
    }
    
    
    
}