

public class ProductSum {

    public static void main(String[] args) {
        System.out.println("value[123456]: " + ProductSum.productLessSum(123456));
        System.out.println("value[1010]: " + ProductSum.productLessSum(1010));
        System.out.println("value[9]: " + ProductSum.productLessSum(9));
    }

    public static int productLessSum(int input){

        int sum = 0;
        int product = 1;
        int rest = input;
        while(rest > 0){
            int value = rest %10;
            rest /= 10;
            sum += value;
            product *= value;
            
        }
        return product - sum;
    }

}