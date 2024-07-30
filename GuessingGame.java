import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int rounds = 0;

        while (true) {
            int numberToGuess = rand.nextInt(100) + 1;
            int attempts = 0;
            boolean won = false;

            System.out.println("Round " + (++rounds));
            System.out.println("Guess a number between 1 and 100:");

            while (attempts < 10) {
                int guess = scanner.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("Correct! You won this round.");
                    won = true;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!won) {
                System.out.println("You lost this round. The number was " + numberToGuess);
            }

            score += won ? 1 : 0;
            System.out.println("Your score: " + score + " / " + rounds);

            System.out.println("Play again? (yes/no)");
            if (!scanner.next().equalsIgnoreCase("yes")) {
                break;
            }
        }

        scanner.close();
    }
}

