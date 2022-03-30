package hu.progmatic;

public class Recursion {

    public static int factorial(int number) {
        if (number==1 || number == 0){
            return 1;
        }
        return number*factorial(number-1);
    }


}
