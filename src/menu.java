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

            int nums [] = parseInput(inputLine);    // Get the values from the user input
            validInput = inputValidity(nums);       // Check that the input values have no errors
            if (validInput)                         // We continue only if the input is valid
            {

            }
        } while (!validInput);

    }
    private static int [] parseInput(String input){

        String inputs [] = input.split(" ", 2); // Get the first two "words" from the input line
        int nums[] = new int[input.length()-1];     // Create int array to save the numbers in the inputs array
        for (int i = 0; i < nums.length; i++)       // Loop through the arrays
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
}
