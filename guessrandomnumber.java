import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int randomNumber = (int) (Math.random() * 100) + 1; // Random number between 1 and 100
        int guess = 0;
        boolean hasGuessedCorrectly = false;
        final boolean[] timeUp = {false};

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You have 1min seconds to guess the number between 1 and 100.");

        // Timer setup
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timeUp[0] = true;
                System.out.println("\nTime is up! You couldn't guess the number.");
                System.out.println("The correct number was: " + randomNumber);
                System.exit(0);
            }
        }, 30000);

        // Game loop
        while (!hasGuessedCorrectly && !timeUp[0]) {
            System.out.print("Enter your guess: ");
            try {
                guess = scanner.nextInt();
                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                } else if (guess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    hasGuessedCorrectly = true;
                    System.out.println("Bhadhai ho ap jit gaye " + randomNumber);
                }
            } catch (Exception e) {
                System.out.println("Enter number agin to win.");
                scanner.next(); // Clear invalid input
            }
        }

        // Stop the timer if guessed correctly
        timer.cancel();
        scanner.close();
    }
}
