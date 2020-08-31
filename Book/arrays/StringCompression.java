package arrays;

public class StringCompression {

    public static void main(String[] args) {

        StringCompression compresor = new StringCompression();
        System.out.println("aabcccccaa|" + compresor.compress("aabcccccaa"));

    }

    public String compress(String text) {
        char c = ' ';
        int count = 0;
        String compressText= "";

        for(int i = 0; i < text.length(); i++) {
            if(c != text.charAt(i)) {
                if(count > 0) {
                    compressText = compressText + c + count;
                }
                c = text.charAt(i);
                count = 1;
            } else 
                count ++;
        }
        if(count > 0) {
            compressText = compressText + c + count;
        }
        return compressText.length() < text.length() ? compressText : text;
    }
    
    
}