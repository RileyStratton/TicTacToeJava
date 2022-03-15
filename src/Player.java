import java.util.Scanner;

public class Player {

    public char current = 'X';

    public void TakeTurn(char[] squares) {

        System.out.println("Player " + current + "'s turn.");

        int choice;

        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Type a square number to claim: ");
            choice = Integer.parseInt(scanner.nextLine());

            if (choice < 1 | choice > 9) {
                System.out.println("Please enter a number between 1 and 9.");
            }

            else if (squares[choice] == 'X' | squares[choice] == 'O') {
                System.out.println("Please enter a number not taken by a player.");
            }

            else if (squares[choice] == Integer.toString(choice).charAt(0)) {
                squares[choice] = current;
                return;
            }
        }
    }

    public void SwitchPlayer() {
        if (current == 'X') { current = 'O'; }
        else if (current == 'O') { current = 'X'; }
    }
}
