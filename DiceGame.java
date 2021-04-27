import java.util.Scanner;
import java.util.Random;
/**
 * This program generates a random number and counts how many guesses.
 *
 * @author  Marlon Poddalgoda
 * @version 1.0
 * @since 2021-04-27
 */

public final class DiceGame {
    private DiceGame() {

        // Throw an exception if this ever *is* called
        throw new AssertionError("Instantiating utility class.");
    }
    /**
    * This method generates a random number for a guessing game.
    * @param args
    */
    public static void main(final String[] args) {

        // Create new Scanner-type variable
        Scanner maxInput = new Scanner(System.in);
        Scanner userInput = new Scanner(System.in);

        // Variables
        int maxValue = 0;
        int userGuess = 0;
        int numOfGuesses = 0;

        System.out.println("DiceGame is a game where you try and "
            + "guess the correct number!");
        System.out.println();

        // Asks user to enter one of several choices
        System.out.print("How high do you want the guessing "
                        + "range to be (0 to ?): ");

        while (true) {
            // check if input is an integer
            while (!maxInput.hasNextInt()) {
                System.out.println("That's not a number!");
                System.out.print("How high do you want the guessing "
                                + "range to be (0 to ?): ");
                maxInput.next(); // moves scanner until correct value
            }
            maxValue = maxInput.nextInt();

            // random number variable
            Random rand = new Random();
            //generate random values
            int answer = rand.nextInt(maxValue);

            // number of items input
            while (true) {
                // asks user to input guess
                System.out.print("Enter your guess (0 to " + maxValue + "): ");

                // counts number of guesses
                numOfGuesses += 1;

                // check if input is an integer
                while (!userInput.hasNextInt()) {
                    System.out.println("That's not a number!");
                    System.out.print("Enter your guess: ");
                    userInput.next(); // moves scanner until correct value
                }
                userGuess = userInput.nextInt();

                // process
                if (userGuess == answer) {
                    // user guesses correctly
                    System.out.println("");
                    System.out.println("Correct! It took you " + numOfGuesses
                                        + " guesses.");
                    break;
                } else {
                    System.out.println("Sorry, that's incorrect. Try again!");
                    continue;
                }
            }
            System.out.println("");
            System.out.println("Done.");
            break;
        }
    }
}
