import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.println("Rock, Paper, Scissors");
            System.out.println("1. Rock");
            System.out.println("2. Paper");
            System.out.println("3. Scissors");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            if (option == 4) {
                System.out.println("Exiting...");
                break;
            }

            if (option < 1 || option > 4) {
                System.out.println("Invalid option. Please choose again.");
                continue;
            }

            int computerChoice = random.nextInt(3) + 1;
            String userChoice = getChoice(option);
            String computerChoiceString = getChoice(computerChoice);

            System.out.println("You chose: " + userChoice);
            System.out.println("Computer chose: " + computerChoiceString);

            String result = determineWinner(userChoice, computerChoiceString);
            System.out.println(result);
        }
    }

    private static String getChoice(int option) {
        switch (option) {
            case 1:
                return "Rock";
            case 2:
                return "Paper";
            case 3:
                return "Scissors";
            default:
                return "";
        }
    }

    private static String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "It's a tie!";
        }

        switch (userChoice) {
            case "Rock":
                return computerChoice.equals("Scissors") ? "Rock smashes scissors! You win!" : "Paper covers rock! You lose!";
            case "Paper":
                return computerChoice.equals("Rock") ? "Paper covers rock! You win!" : "Scissors cuts paper! You lose!";
            case "Scissors":
                return computerChoice.equals("Paper") ? "Scissors cuts paper! You win!" : "Rock smashes scissors! You lose!";
            default:
                return "";
        }
    }
}
