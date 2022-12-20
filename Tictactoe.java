import java.util.Scanner;

public class Tictactoe {

    static char[][] board = new char[3][3];
    static boolean xTurn = true;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        while (true) {
            printBoard();
            getInput();
            if (checkWin()) {
                break;
            }
            xTurn = !xTurn;
        }
        System.out.println("Game Over!");
    }

    static void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i != 2) {
                System.out.println("---|---|---");
            }
        }
    }

    static void getInput() {
        System.out.print("Enter row for player " + (xTurn ? "X" : "O") + ": ");
        int row = input.nextInt();
        System.out.print("Enter column for player " + (xTurn ? "X" : "O") + ": ");
        int col = input.nextInt();
        if (board[row][col] == ' ') {
            board[row][col] = xTurn ? 'X' : 'O';
        } else {
            System.out.println("That space is already occupied. Try again.");
            getInput();
        }
    }

    static boolean checkWin() {
        // check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                return true;
            }
        }
        // check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ') {
                return true;
            }
        }
        // check diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
            return true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
            return true;
        }
        return false;
    }
}
