import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Game {
    static volatile int tries = 10;
    static int warning = 1;
    static ArrayList<Integer> nums = new ArrayList<>();
    static Random ran = new Random();
    static int ran_num;

    static boolean playagain = true;
    Scanner inp = new Scanner(System.in);
    static int score = 5;
    static int s_multiplier = 1;
    static int totalScore;

    public void start() {
        while (playagain) {
            ran_num = ran.nextInt(0, 1001);
            System.out.println("Welcome to the number guessing game. \nRound: "+s_multiplier);
            System.out.println("I'm thinking of a number between 0-1000.");
            System.out.println("You have " + tries + " guesses left.");
            System.out.println("You have " + warning + " warning left.");
            System.out.println("_________________");

            for (int i = 0; i < tries; i++) {
                System.out.print("Guessed Numbers: ");
                String guessedNumbers = String.join(", ", nums.stream().map(Object::toString).toArray(String[]::new));
                System.out.println(guessedNumbers);
                System.out.println("Please guess a number: ");

                if (inp.hasNextInt()) {
                    int guess = inp.nextInt();
                    inp.nextLine();

                    if (nums.contains(guess)) {
                        if (warning > 0) {
                            System.out.println("Warning! You have already guessed this number.");
                            warning--;
                            System.out.println("You have " + warning + " warning left.");
                            System.out.println("_________________");
                            System.out.println("You have " + (tries - i) + " guesses left.");
                            continue; // Skip the rest of the loop and start a new turn
                        } else {
                            System.out.println("You have already guessed this number.");
                            System.out.println("_________________");
                            System.out.println("You have " + (tries - i-1) + " guesses left.");
                        }
                    } else {
                        nums.add(guess);
                        if (guess == ran_num) {
                            System.out.println("Hurrayy!! You have guessed the correct number.");
                            int roundScore = score * s_multiplier * (tries - i); // Calculate score
                            totalScore += roundScore;
                            System.out.println("Your score for this round: " + roundScore);
                            break;
                        } else if (guess < ran_num) {
                            System.out.println("Your guess is smaller. Try a higher number.");
                        } else {
                            System.out.println("Your guess is greater. Try a lower number.");
                        }
                        System.out.println("_________________");
                        System.out.println("You have " + (tries - i-1) + " guesses left.");
                    }
                } else {
                    if (warning > 0) {
                        System.out.println("Warning! Please Enter Integers only!");
                        warning--;
                        System.out.println("You have " + warning + " warning left. Next time, your guesses will be deducted.");
                        System.out.println("_________________");
                        System.out.println("You have " + (tries - i) + " guesses left.");
                    } else {
                        System.out.println("Please Enter Integers only.");
                        System.out.println("_________________");
                        System.out.println("You have " + (tries - i-1) + " guesses left.");
                    }

                    inp.next();
                }

                if (i == tries - 1) {
                    System.out.println("Sorry, you ran out of guesses. The Correct Number was: " + ran_num);
                    // Add a score of 0 when the user can't guess within the tries
                    int roundScore = 0;
                    totalScore += roundScore;
                    System.out.println("Your score for this round: " + roundScore);
                }
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgainChoice = inp.next().toLowerCase();
            inp.nextLine();

            if (!playAgainChoice.equals("yes")) {
                playagain = false;
            }
            s_multiplier++;

            nums.clear();
            warning = 1; // Reset the warning for a new game
            System.out.println("_________________");
        }
        System.out.println("Game over! Your total score: " + totalScore);
        System.out.println("Thank you for playing!");
    }
}

public class Num_Guess_Game {
    public static void main(String[] args) {
        Game newgame = new Game();
        newgame.start();
    }
}
