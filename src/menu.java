import java.util.Scanner;

public class menu {
    public static void main (String []args)
    {
        /**
         * This is the main function of the program. Here we'll only handle asking the user input, we'll keep looping
         * until they enter an acceptable range. When the user inputs an acceptable input then we pass the input values
         * to the palindromeRange() to handle the rest.
         **/

        boolean validInput;                         // Track the validity of the user input for the do-while loop
        do {
            Scanner sc = new Scanner (System.in);   // Initiate scanner object to take user input
            System.out.println("Input Range: ");    // Ask for the user's input
            String inputLine = sc.nextLine();       // Get the whole line input from the user

            int nums[] = parseInput(inputLine);     // Get the values from the user input and save them into an array
            validInput = inputValidity(nums);       // Check that the input values has no errors

            if (validInput)                         // We continue only if the input is valid
                palindromeRange(nums[0], nums[1]);  // Check what numbers are palindromes in the given range

        } while (!validInput);                      // Keep looping until user enters a valid input/range

    }
    private static void palindromeRange(int range1, int range2)
    {
        /**
         * Given two numbers, that serve as range1 to range2, we'll check if every number in the range is a palindrome.
         * If the number is a palindrome then we convert the number into it's binary number, and if it's binary number
         * is a palindrome as well, then we print the value of the number and its binary conversion.
         **/

        System.out.println("Palindromes:");
        System.out.println("Base 10\t\t\tBinary");
        // Now we use the two values in the array to use as range, we'll traverse from num[0] to num[1]
        for (int num = range1; num <= range2; num++)
        {
            if (isDecimalPalindrome(num))   // If the current num is a palindrome
            {
                // Get the binary equivalent of the current num as a string
                String binaryNum = decimalToBinary(num);
                if (isBinaryNumPalindrome(binaryNum))
                    System.out.println(num + "\t\t\t\t" + binaryNum);
            }
        }
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

    private static String decimalToBinary(int num)
    {
        /**
         * Function converts number into it's binary number as a string, we are assuming the num is base 10
         * */

        String binary = "";                                             // Initiate empty binary string
        while (num > 0)                                                 // While the number is greater than 0
        {
            int digit = num % 2;                                        // Get the binary number for the digit
            binary += Integer.toString(digit);                          // Append the digit as a string to our binary
            num = num / 2;                                              // Update the num
        }
        return binary;                                                  // Return the final binary number as a string
    }
    private static boolean isBinaryNumPalindrome(String binaryStr)
    {
        /**
         * Function checks if the given binary number, given as a string, is a palindrome.
         * Returns true if we can read the string from right to left and left to right and every digit/char matches
         * If at any point they don't match then we return true
         * */

        int opIndex = 0;                                                // Keep track of the opposite index
        for (int i = binaryStr.length() - 1; i >= 0; i--)               // Loop from the end to start of the string
        {
            char c1 = binaryStr.charAt(i);                              // Get the digit from the index i
            char c2 = binaryStr.charAt(opIndex);                        // Get the index from the opposite index
            if (c1 != c2)                                               // If both chars/digits are not the same
                return false;                                           // We return false
            if (opIndex == i)                                           // We reached half point, checking beyond would
                return true;                                            // be redundant so we return true
            opIndex++;
        }
        return true;                                                    // Return true as we never got an error
    }
}
