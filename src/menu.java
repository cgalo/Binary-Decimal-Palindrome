import java.util.Scanner;

public class menu {
    public static void main (String []args)
    {
        boolean validInput;                         // Bool to track the validity of the user input for the do-while loop
        do {
            // First we ask the user for input
            Scanner sc = new Scanner (System.in);   // Initiate scanner object to take user input
            System.out.println("Input Range: ");
            String inputLine = sc.nextLine();       // Get the whole line input from the user

            int numRange[] = parseInput(inputLine); // Get the values from the user input and save them into an array
            validInput = inputValidity(numRange);   // Check that the input values have no errors
            if (validInput)                         // We continue only if the input is valid
            {
                // Now we use the two values in the array to use as range, we'll traverse from num[0] to num[1]
                for (int num = numRange[0]; num <= numRange[1]; num++)
                {
                    if (isDecimalPalindrome(num))   // If the current num is a palindrome
                    {
                        // Now we need to convert the decimal into a binary number and check if that is a palindrome

                    }
                }

            }
        } while (!validInput);

    }
    private static int [] parseInput(String input){

        String inputs [] = input.split(" ", 2);     // Get the first two "words" from the input line
        int nums[] = new int[2];                    // Create int array to save the numbers in the inputs array
        for (int i = 0; i < 2; i++)                 // Loop through the arrays
            nums[i] = Integer.parseInt(inputs[i]);  // Insert the current inputs element as an int into nums

        return nums;                                // Return the converted input as a int array
    }
    private static boolean inputValidity(int nums[])
    {
        /**
         * Function check the validity of the values entered by the user
         * Returns false if there is an invalid range, as well as an error message
         * Return true if the range is valid
         * */

        boolean validInput = true;                  // By default we set the validity as true

        if (nums[0] > nums[1])                      // First we check if the first num is larger than the second
        {
            System.out.println("Error! First number is larger than second number. Try Again.");
            validInput = false;                     // Set the validity as false
        }

        if (nums[0] < 0 || nums[1] < 0)             // If either value is less than 0
        {
            System.out.println("Error: Invalid value entered. All values must be greater than zero. Try Again.");
            validInput = false;                     // Set the validity as false
        }

        return validInput;
    }

    private static boolean isDecimalPalindrome(int num)
    {
        /**
         * Function checks that the given number is a palindrome
         * Returns true if it is, false if it's not
         * */

        // Base case, as the num will be higher than 1 and anything that doesn't have two digits is a palindrome
         if (num <= 9)
             return true;

         StackInterface<Integer> digits = new Stack<Integer>();         // Create a stack to save the digits in order
         int [] revDigits = new int[Integer.toString(num).length()];    // Create array to store digits in reverse
         int revIndex = 0;

        while (num > 0)
        {
            int digit = num % 10;                                       // Get the current digit
            digits.push(digit);                                         // Insert the digit into the stack
            revDigits[revIndex] = digit;                                // Insert the digit into the array
            num = num / 10;                                             // Update the number value
            revIndex++;                                                 // Update digIndex
        }

        for (Integer revDig : revDigits)                                // Start looping through the array
        {
            int digit = digits.pop();                                   // Get digit from stack
            if (revDig != digit)                                        // If the digits are not the same
                return false;                                           // Return false
        }
        return true;                                                    // Return true as the number is a palindrome

    }
}
