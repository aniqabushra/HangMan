import java.util.*;

public class Hangman {
    static Scanner console;

    public static void main(String[] args) {
        console = new Scanner(System.in);
        wellCome();

        do {
            String random = random_names();
            start_Man();
            ArrayList<Character> playerGuesses = new ArrayList<>();
            int wrongCount = 0;
            while (true) {
                changingHangMan(wrongCount);
                if(wrongCount>=6){
                    println("You Loose :(");
                    break;
                }
                if (!getGuessLetter(random, playerGuesses)) {
                    wrongCount++;
                }

                if (puttingGuessInDashes(random, playerGuesses)) {
                    println("You won :)");
                    break;
                }
            }

        } while (shouldRestart(console));
    }

    public static void wellCome() {
        System.out.println("H A N G M A N");
    }

    public static void print(String str) {
        System.out.print(str);
    }

    public static void println(String str) {
        System.out.println(str);
    }

    public static void start_Man() {
        print("|-----+\n");
        println("      |");
        println("      |");
        println("      |");
        println("      |");
        println("      |");
        print("<=======>\n");
    }

    public static String random_names() {
        String[] animals = {"cat", "dog", "pig", "duck", "frog", "fish","fool"};
        Random random = new Random();
        String random_animal = animals[random.nextInt(animals.length)];
        println("ran no " + random_animal);
        return random_animal;

    }

    public static boolean getGuessLetter(String rand_names, ArrayList<Character> playerGuesses) {
        String guess;
        println("Guess a letter Please: ");
        guess = console.nextLine().toLowerCase();
        if(playerGuesses.contains(guess.charAt(0))){
            println("You already guessed that letter.");
        }
        if(!playerGuesses.contains(guess.charAt(0))){
            playerGuesses.add(guess.charAt(0));
        }
        playerGuesses.add(guess.charAt(0));
        return rand_names.contains(guess);
    }

    public static boolean puttingGuessInDashes(String ran_letter, ArrayList<Character> playerGusses) {
        int correctCount = 0;
        for (int i = 0; i < ran_letter.length(); i++) {
            if (playerGusses.contains(ran_letter.charAt(i))) {
                print(Character.toString(ran_letter.charAt(i)));
                correctCount++;
            } else {
                print("-");
            }
        }
        println(" ");
        return (ran_letter.length() == correctCount);
    }

    private static boolean shouldRestart(Scanner console) {
        print("\nPlay Again? [y/n]: ");
        boolean restart = console.next().equals("y");
        println("");
        return restart;
    }

    public static void changingHangMan(int wrongCount) {
        if (wrongCount == 1) {
            print("|-----+\n");
            println(" O    |");
            println("      |");
            println("      |");
            println("      |");
            println("      |");
            print("<=======>\n");
        }
        if (wrongCount == 2) {
            print("|-----+\n");
            println(" O     |");
            println(" |     |");
            println("       |");
            println("       |");
            println("       |");
            print("<=======>\n");
        }
        if (wrongCount == 3) {
            print("|-----+\n");
            println(" O     |");
            println(" |     |");
            println("/      |");
            println("       |");
            println("       |");
            print("<========>\n");
        }
        if (wrongCount == 4) {
            print("|-----+\n");
            println(" O     |");
            println(" |     |");
            println("/ \\   |");
            println("       |");
            println("       |");
            print("<========>\n");
        }
        if (wrongCount == 5) {
            print("|-----+\n");
            println(" O     |");
            println("/|     |");
            println("/ \\   |");
            println("       |");
            println("       |");
            print("<========>\n");
        }
        if (wrongCount == 6) {
            print("|------+\n");
            println(" O     |");
            println("/|\\   |");
            println("/ \\   |");
            println("       |");
            println("       |");
            print("<========>\n");
        }
    }

}
