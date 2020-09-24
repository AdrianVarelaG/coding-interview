package javabrains.fizzbuzz;

public class FizzBuzz {

    public static void main(String[] args) {

        for(int i = 1; i <= 100; i++) {
            boolean isFizz = i%3 == 0;
            boolean isBuzz = i%5 == 0;

            if(isFizz || isBuzz) {
                if(isFizz && isBuzz)  System.out.println("FizzBuzz");
                else if(isFizz) System.out.println("Fizz");
                else System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}