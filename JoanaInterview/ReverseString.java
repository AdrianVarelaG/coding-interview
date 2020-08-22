

public class ReverseString{

    public static void main(String[] args){
        System.out.println("input[Man bites dog]: " + reverseString("Man bites dog"));
    }

    public static String reverseString(String input){
        
        String[] inputArray = input.split(" ");
        StringBuilder sb = new StringBuilder();
        
        for(int i = inputArray.length -1; i >= 0  ; i--) {
            sb.append(inputArray[i]).append(" ");
        }
        return sb.toString();
        
    }
}