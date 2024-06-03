import java.util.Random;
import java.util.Scanner;



class Hm {
    // Array of words with lengths 3-4
    static String[] shortWords = {"cat", "dog", "sun", "moon", "fish", "tree", "bird", "book", "pen", "rose"};

    // Array of words with lengths 6-7
    static String[] mediumWords = {"elephant", "giraffe", "parrot", "octopus", "cucumber", "butterfly", "keyboard", "guitar", "vulture", "rainbow"};

    // Array of words with lengths 9-10
    static String[] longWords = {"watermelon", "helicopter", "university", "chocolate", "telescope", "restaurant", "basketball", "strawberry", "butterflies", "television"};

    static int guess;
    static int warning = 4;
    static String g_word;
    static Random ran = new Random();
    static int ind;
    static String avail = "abcdefghijklmnopqrstuvwxyz";
    static boolean playagain = true;
    static int score = 5;
    static int s_multiplier = 1;
    static int totalScore;

    static void start(){
        System.out.println("Welcome to Hangman Game. \n Round: "+ s_multiplier);
        System.out.println("You Have Three Levels Starting From Easy To Hard.");
        Scanner input = new Scanner(System.in);
        Hm player = null;
        int opt;
        do {
            System.out.println("Choose: \n1.easy \n2.normal \n3.hard \n4.exit");
            opt = input.nextInt();
            input.nextLine();
            switch (opt) {
                case 1: {
                    player = new Hm("easy");
                    player.game();
                    System.exit(0);
                }
                case 2: {
                    player = new Hm("medium");
                    player.game();
                    System.exit(0);
                }
                case 3: {
                    player = new Hm("hard");
                    player.game();
                    System.exit(0);
                }
                case 4:
                    System.out.println("Thank You For Playing.");
                    break;
                default:
                    System.out.println("Please Give A Valid Input.");

            }
        } while (opt != 4);
    }

    public Hm(String inp) {
        switch (inp) {
            case "easy" -> {
                ind = ran.nextInt(shortWords.length);
                g_word = shortWords[ind];
                guess = (int) Math.ceil(1.5 * g_word.length());

            }
            case "medium" -> {
                ind = ran.nextInt(mediumWords.length);
                g_word = mediumWords[ind];
                guess = (int) Math.ceil(1.5 * g_word.length());
            }
            case "hard" -> {
                ind = ran.nextInt(longWords.length);
                g_word = longWords[ind];
                guess = (int) Math.ceil(1.5 * g_word.length());
            }
        }

    }

    public void game() {
        while (playagain) {
        Scanner in = new Scanner(System.in);
        String op;
        int wordLength = g_word.length();
        String blank = new String(new char[wordLength]).replace('\0', '_');
        System.out.println("I'm Thinking of a " + g_word.length() + " letter word.");
        System.out.println("You have " + warning + " warnings left.");
        System.out.println("__________________________");
        System.out.println("You Have " + guess + " Guesses Left.");

        for (int i = 0; i < guess; i++) {

            System.out.println("Available Letters: " + avail);
            System.out.println("Please guess a letter: ");

            if (in.hasNextLine()) {
                op = in.nextLine().toLowerCase();

                if (avail.contains(op)) {
                    StringBuilder sb = new StringBuilder(avail);
                    int index = sb.indexOf(op);
                    sb.deleteCharAt(index);
                    avail = sb.toString();
                    if (g_word.contains(op)) {

                        StringBuilder sb1 = new StringBuilder(blank);
                        for (int j = 0; j < g_word.length(); j++) {
                            if (g_word.charAt(j) == op.charAt(0)) {
                                sb1.setCharAt(j, op.charAt(0));
                            }
                            blank = sb1.toString();

                        }
                        System.out.println("Good Guess: " + blank);
                        System.out.println("__________________________");
                        if (blank.equals(g_word)) {
                            System.out.println("Congratulations! You Won");
                            int roundScore = score * s_multiplier * (guess - i); // Calculate score
                            totalScore += roundScore;
                            System.out.println("Your score for this round: " + roundScore);
                            break;
                        }
                        else
                        {
                            System.out.println("You have " + (guess - i - 1) + " guesses left.");
                        }
                    } else {
                        System.out.println("Oops! That letter is not in my word: " + blank);
                        System.out.println("__________________________");
                        System.out.println("You Have " + (guess - i - 1) + " guesses Left.");
                    }
                } else {
                    if (warning > 0) {
                        System.out.println("Warning! You have already guessed this letter.");
                        warning--;
                        System.out.println("You have " + warning + " warnings left: \n" + blank);
                        System.out.println("__________________________");
                        System.out.println("You have " + (guess - i) + " guesses left.");

                    } else {
                        System.out.println("You have already guessed this letter.");
                        System.out.println("__________________________");
                        System.out.println("You have " + (guess - i - 1) + " guesses left.");
                    }
                }
            } else {
                if (warning > 0) {
                    System.out.println("Warning! Please Enter letters only!");
                    warning--;
                    System.out.println("You have " + warning + " warning left. After that, your guesses will be deducted :" + blank);
                    System.out.println("_________________");
                    System.out.println("You have " + (guess - i) + " guesses left.");
                } else {
                    System.out.println("Please Enter letters only: " + blank);
                    System.out.println("_________________");
                    System.out.println("You have " + (guess - i - 1) + " guesses left.");
                }
            }
            if (i == guess - 1) {
                System.out.println("Sorry, you ran out of guesses. The Correct word was: " + g_word);
                int roundScore = 0;
                totalScore += roundScore;
                System.out.println("Your score for this round: " + roundScore);
            }
        }
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgainChoice = in.next().toLowerCase();
            in.nextLine();

            if (!playAgainChoice.equals("yes")) {
                playagain = false;
                break;
            }
            s_multiplier++;

            avail = "abcdefghijklmnopqrstuvwxyz";
            warning = 4; // Reset the warning for a new game
            System.out.println("_________________");
            start();
        }
        System.out.println("Game over! Your total score: " + totalScore);
        System.out.println("Thank You For Playing.");
    }
}

public  class Hangman {
        public static void main(String[] args) {
            Hm.start();



        }

    }

