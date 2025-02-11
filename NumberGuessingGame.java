package Vedant;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 5;
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;

        System.out.println("===== Welcome to the Number Guessing Game! =====");

        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI have picked a number between " + LOWER_BOUND + " and " + UPPER_BOUND + ". Try to guess it!");

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println(" Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    totalScore += (MAX_ATTEMPTS - attempts + 1);
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                System.out.println("Attempts left: " + (MAX_ATTEMPTS - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println(" Sorry! You've used all attempts. The correct number was: " + targetNumber);
            }

            System.out.println("\nYour current score: " + totalScore);
            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = sc.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println(" Game Over! Your final score: " + totalScore);
        System.out.println("Thank you for playing! ");
        sc.close();
    }
}

