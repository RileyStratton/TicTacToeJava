import java.util.Random;
import java.util.Scanner;

public class Player {

    public char current = 'X';
    public boolean ai;
    public char aiTurn = ' ';

    int intChoice;
    String stringChoice;

    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();

    public void PlayWithAI() {


        while (true) {
            System.out.println("Would you like to play against an AI? (true or false)");
            stringChoice = scanner.nextLine();
            if (stringChoice.equals("false") || stringChoice.equals("true")) {
                ai = Boolean.parseBoolean(stringChoice);
                break;
            }
        }

        if (!ai) {
            return;
        }

        while (true) {
            System.out.println("Should the AI be first or second? (1 or 2)");
            intChoice = Integer.parseInt(scanner.nextLine());
            if (intChoice == 1) {
                aiTurn = 'X';
                break;
            }
            else if (intChoice == 2) {
                aiTurn = 'O';
                break;
            }
        }

        System.out.println("AI will be player " + aiTurn);
    }

    public void TakeTurn(char[] squares) {

        System.out.println("Player " + current + "'s turn.");

        while (true) {

            if (ai && current == aiTurn) {
                intChoice = AIChoice();
            }

            else{
                System.out.println("Type a square number to claim: ");
                intChoice = Integer.parseInt(scanner.nextLine());
            }

            if (intChoice < 1 | intChoice > 9) {
                System.out.println("Please enter a number between 1 and 9.");
            }

            else if (squares[intChoice] == 'X' | squares[intChoice] == 'O') {
                System.out.println("Please enter a number not taken by a player.");
            }

            else if (squares[intChoice] == Integer.toString(intChoice).charAt(0)) {
                squares[intChoice] = current;
                return;
            }
        }
    }

    public int AIChoice() {
        return rand.nextInt(1,9);
    }

    public void SwitchPlayer() {
        if (current == 'X') { current = 'O'; }
        else if (current == 'O') { current = 'X'; }
    }
}
