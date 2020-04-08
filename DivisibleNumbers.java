import java.util.Scanner;

class DivisibleNums {
    public static void main(final String[] args) {
        System.out.println("Enter a number: ");
        final int num = getNum();
        System.out.println("" + num + " is divisble by: ");
        calculateNum(num);
    }

    private static int getNum() {

        final Scanner divisNum = new Scanner(System.in); // create scanner object
        final String sNumber = divisNum.nextLine(); // get the number input by the user
        final int dNumber = Integer.parseInt(sNumber); // convert user input to an int.
        return dNumber;
    }

    private static void calculateNum(final int n) { // calculate numbers divisble by the user entered numb.
        for (int i = 1; i < n; i++) { //loop over all potential divisible numbers
            if(n % i == 0) { // make sure there is no remainder.
                System.out.print(i + " ");
            }
        }
    }


}