import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // game title
        System.out.println("Code cracker game");

        // to scan the length
        System.out.println("Enter the length of code you want to crack: ");
        Scanner scanner = new Scanner(System.in);
        // if user types something, not number, to show the error
        while (!scanner.hasNextDouble()) {
            scanner.next();
            System.err.println("Invalid length. Only 2 ~ 6 are allowed.\nEnter again: ");
        }
        double length = scanner.nextDouble();
        // if user types number that is not between 2 and 6, to show the error
        while (length != 2 && length != 3 && length != 4 && length != 5 && length != 6) {
            System.err.println("Invalid length. Only 2 ~ 6 are allowed.\nEnter again: ");
            length = scanner.nextDouble();
        }
        System.out.println();

        // to scan the attempts
        System.out.println("Enter the attempts you want to crack: ");
        Scanner scanner2 = new Scanner(System.in);
        // if user types something, not number, to show the error
        while (!scanner2.hasNextInt()) {
            scanner2.next();
            System.err.println("It is not the natural number.\nEnter a natural number:");
        }
        double attempts = scanner2.nextDouble();
        // if user types smaller than 1, to show the error
        while (attempts < 1) {
            System.err.println("It is impossible to be < 1.\nEnter a natural number:");
            attempts = scanner2.nextDouble();
        }
        System.out.println();

        // to show the range and the number of attempts
        System.out.printf("The range is between %.0f", Math.pow(10, length - 1));
        System.out.printf(" and %.0f", Math.pow(10, length) - 1);
        System.out.println();
        System.out.printf("You have got %.0f attempts\n", attempts);
        System.out.println();

        // to creat the maximum and minimum value for random number
        int max = 10;
        int min = 1;
        for (int i = 1; i < length; i++) {
            max = max * 10;
            min = min * 10;
        }

        // to make random number
        Random random = new Random();
        int ran = random.nextInt(max - min) + min;

        // to set the number of attempts
        for (int i = 0; i < attempts; i++) {
            System.out.printf("Code length is %.0f. ", length);
            System.out.printf("You have %.0f chances. Enter your guess: \n", attempts - i);
            Scanner scanner3 = new Scanner(System.in);
            // if user does not type number, to show the error
            while (!scanner3.hasNextInt()) {
                scanner3.next();
                System.err.println("It is not the natural number.\nEnter a natural number: ");
            }
            double guess = scanner3.nextDouble();
            System.out.printf("Your guess: %.0f\n", guess);
            // if user types perfect answer, to finish the game
            if (guess == ran) {
                System.out.println("You cracked!");
                break;
            }
            // if user types the number that is not included in range, to show the error
            else if (guess < Math.pow(10, length - 1) || Math.pow(10, length) - 1 < guess) {
                System.err.printf("It is impossible to be < %.0f", Math.pow(10, length - 1));
                System.err.printf(" or be > %.0f.\n", Math.pow(10, length) - 1);
            }
            else {
                // to creat the char array of the guessed number and the random number
                String ranS = Integer.toString(ran);
                char[] ranArr = ranS.toCharArray();
                String guessS = Double.toString(guess);
                char[] guessArr = guessS.toCharArray();

                int j = 0;
                for (int k = 0; k < length; k++) { //to compare value at the same location
                    // to count how many are the same
                    if (ranArr[k] == guessArr[k]) {
                        j++;
                    }
                }

                int l = 0;
                for (int m = 0; m < length; m++) { //to compare value, do not mind the location
                    for (int n = 0; n < length; n++) {
                        if (ranArr[m] == guessArr[n]) {
                            l++; // to count how many are the same
                            break;
                        }
                    }
                }

                System.out.println("Correct characters found: " + l);
                System.out.println("Correct characters in correct position: " + j);
            }
        }
        // if user does not give the correct answer, to show the answer
        System.out.println("The answer was " + ran + "!!");
    }
}
