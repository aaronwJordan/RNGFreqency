import org.omg.DynamicAny._DynUnionStub;

import java.util.Scanner;

/*
 * Aaron Jordan
 * Homework #2
 * 2/5/2014
 */

public class Homework2
{
    /*
     *  Entry point for program.
     *  Calls the necessary method(s) for program completion.
     */
    public static void main(String[] args)
    {
        final int MIN = 1;
        final int MAX = 54;
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("This program will generate numbers between (1-54) and print the frequency of each.");
        System.out.print("Enter a number for RNG between (1,000-10,000): ");
        int inputNumber = inputScanner.nextInt();
        RandomNumbers.setInputNumberN(inputNumber);

        // To verify the inputNumber by the user meets requirements.
        if (inputNumber >= 1000 && inputNumber <= 10000)
        {
            RandomNumbers.randomIntegers(MIN, MAX, RandomNumbers.getInputNumberN());
        }
    }
}
