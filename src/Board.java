public class Board {

    public char[] squares = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    public void DisplayBoard() {
        System.out.println();
        System.out.println(" " + squares[1] + " | " + squares[2] + " | " + squares[3] + " ");
        System.out.println("---+---+---");
        System.out.println(" " + squares[4] + " | " + squares[5] + " | " + squares[6] + " ");
        System.out.println("---+---+---");
        System.out.println(" " + squares[7] + " | " + squares[8] + " | " + squares[9] + " ");
        System.out.println();
    }

    public Boolean WinCheck(char current) {
        if (squares[1] == current & squares[2] == current & squares[3] == current) { return true; }
        else if (squares[4] == current & squares[5] == current & squares[6] == current) { return true; }
        else if (squares[7] == current & squares[8] == current & squares[9] == current) { return true; }

        // Vertical win conditions
        else if (squares[1] == current & squares[4] == current & squares[7] == current) { return true; }
        else if (squares[2] == current & squares[5] == current & squares[8] == current) { return true; }
        else if (squares[3] == current & squares[6] == current & squares[9] == current) { return true; }

        // Diagonal win conditions
        else if (squares[1] == current & squares[5] == current & squares[9] == current) { return true; }
        else if (squares[3] == current & squares[5] == current & squares[7] == current) { return true; }

        // No win conditions
        else { return false; }
    }

    public void DisplayWinner(char current) {
        DisplayBoard();
        System.out.println("Player " + current + " wins!");
    }

    public void DisplayTie() {
        DisplayBoard();
        System.out.println("Cat. No one wins.");
    }
}
