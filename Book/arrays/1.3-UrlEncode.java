package arrays;

public class UrlEncode {
    public static void main(String[] args) {
        UrlEncode process = new UrlEncode();

        process.encodeURl("abc def g    ".toCharArray(), 9);
        process.encodeURl("Mr John Smith    ".toCharArray(), 13);
    }

    public char[] encodeURl(char[] input, Integer size) {

        System.out.println(String.copyValueOf(input) + " | " + input.length);
        encodeUrl(input, size, 0, 0);
        System.out.println(String.copyValueOf(input)  + " | " + input.length);
        return input;
    }

    protected void encodeUrl(char[] input, int size, int index, int offset) {

        int i = index;
        boolean space = false;
        while(i < size && !space ) {
            space = input[i] == ' ';
            i++;
        }
        if(space)
            encodeUrl(input, size, i, offset + 2);
        
        for(int j = i-1; j >= index; j--) {
            if(input[j] == ' '){
                input[j+offset]= '%';
                input[j+offset+1] = '2';
                input[j+offset+2] = '0';
            }else 
                input[j+offset] = input[j];
            
        }
    }
}