import java.util.*;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Aaron Jordan
 * Homework #2
 * 2/5/2014
 */

public class RandomNumbers
{
    // Declaration of private member and get/set methods.
    private static int inputNumberN;

    // Accessor/Getter
    public static int getInputNumberN()
    {
        return inputNumberN;
    }

    // Mutator/Setter, also checks for minimum and maximum values from user input.
    public static void setInputNumberN(int userInput)
    {
        if ((userInput >= 1000) && (userInput <= 10000))
        {
            inputNumberN = userInput;
        }
        else
        {
            System.out.println("\nInvalid Entry: The number must be between 1,000-10,000.");
        }
    }

    /*
     * This method does a few things. First, I create a Hashmap for the purpose of holding all
     * random integers created. Next I create the actual random integers and store them in an array.
     * From there, I push all the integers into the Hashmap from the array and send them to
     * printRandomIntegers for additional processing and sorting.
     */
    public static void randomIntegers(final int MIN, final int MAX, int inputNumber)
    {
        Map<Integer, Integer> numOccurrence = new HashMap<Integer, Integer>();
        int[] arrayRandomIntegers = new int[inputNumber];
        int averageNumber = 0;

        for (int i = 0; i < inputNumber; i++)
        {
            arrayRandomIntegers[i] = generateRandomIntegers(MIN, MAX);
        }

        for (int i = 0; i < inputNumber; i++)
        {
            int number = arrayRandomIntegers[i];
            if (!numOccurrence.containsKey(number))
            {
                numOccurrence.put(number, 1);
            }
            else
            {
                numOccurrence.put(number, numOccurrence.get(number) + 1);
            }
        }
        printRandomIntegers(numOccurrence, averageNumber, arrayRandomIntegers, inputNumber);
    }

    /*
     *  This method finds the average number generated from all the integers created.
     */
    public static int findAverageNumber(int averageNumber, int[] arrayRandomIntegers, int inputNumber)
    {
        for (int i = 0; i < inputNumber; i++)
        {
            averageNumber += arrayRandomIntegers[i];
        }
        averageNumber = (averageNumber / arrayRandomIntegers.length);

        return averageNumber;
    }

    /*
     *  This method creates the random integers needed.
     */
    public static int generateRandomIntegers(final int MIN, final int MAX)
    {
        Random rand = new Random();
        int randomInteger = rand.nextInt((MAX - MIN) + 1) + MIN;

        return randomInteger;
    }

    /*
     *  This method does all necessary processing and sorting for the randomly generated integers.
     *  First, it takes in the already created Hashmap and converts that to a newly created TreeMap.
     *  The purpose of the TreeMap is for sorting. A traditional Hashmap will store keys and values (k, v)
     *  but will not sort them. A TreeMap can take those (k, v)'s and sort them with ease.
     *  The remaining loops find both the highest and lowest occurrences of numbers inside the TreeMap then
     *  prints them out to console.
     */
    public static void printRandomIntegers(Map numOccurrence, int averageNumber, int[] arrayRandomIntegers, int inputNumber)
    {
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>(numOccurrence);

        // Find the highest occurring number inside the TreeMap
        Entry<Integer, Integer> maxEntry = null;
        for (Entry<Integer, Integer> entry : treeMap.entrySet())
        {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue())
            {
                maxEntry = entry;
            }
        }

        // Find the lowest occurring number inside the TreeMap
        Entry<Integer, Integer> minEntry = null;
        for (Entry<Integer, Integer> entry : treeMap.entrySet())
        {
            if (minEntry == null || entry.getValue() < minEntry.getValue())
            {
                minEntry = entry;
            }
        }

        // Print all occurrences
        for (Entry<Integer, Integer> entry : treeMap.entrySet())
        {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        System.out.println("\nThe number with the highest frequency is " + maxEntry.getKey() + " with " + maxEntry.getValue() + " occurrences.");
        System.out.println("The number with the lowest frequency is " + minEntry.getKey() + " with " + minEntry.getValue() + " occurrences.");
        System.out.println("The average number generated inside the array is " + findAverageNumber(averageNumber, arrayRandomIntegers, inputNumber) + ".");
    }
}
