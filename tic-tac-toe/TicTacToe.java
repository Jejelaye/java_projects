import java.util.Scanner;

public class TicTacToe {
    // create a tic-tac-toe board and fill it dashes.
    static char[][] board = { {'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'} };

    public static void main(String[] args) {

        //Create a Scanner and ask the players for their names
        Scanner in = new Scanner(System.in);
        System.out.println("Let's play Tic Tac Toe!");
        System.out.print("Player 1, what is your name? ");
        String p1 = in.nextLine();
        System.out.print("Player 2, what is your name? ");
        String p2 = in.nextLine();

        int row = 5;
        int col = 5;

        printBoard(board);

        boolean isPlayer1 = true;

        while (true) {
            char symbol = isPlayer1 ? 'x' : 'o';

            if (isPlayer1) {
                System.out.println(p1 + ", it's your turn to play!");
            } else {
                System.out.println(p2 + ", it's your turn to play!");
            }

            System.out.println("Note: Only input numbers [row -> 1-3; col -> 1-3]");
            System.out.println("Enter the row you write in");
            row = in.nextInt();
            System.out.println("Enter the col you write in");
            col = in.nextInt();

            char valueAtPosition;

            if (row < 4 && row >= 1 && col < 4 && col >= 1) {
                row -= 1;
                col -= 1;
                if (board[row][col] == '-') {
                    board[row][col] = symbol;
                    valueAtPosition = board[row][col];
                    System.out.println("valueAtPosition " + valueAtPosition);
                    printBoard(board);
                    isPlayer1 = !isPlayer1;
                } else {
                    System.out.println("That position is occupied! Enter another position.");
                }
            } else {
                System.out.println("Your position is out of the board!");
            }

            //Check to see if either player has won or if the board is full
            if(playerHasWon(board) == 'x') {
                System.out.println(p1 + " has won!");
                break;
            } else if(playerHasWon(board) == 'o') {
                System.out.println(p2 + " has won!");
                break;
            } else if (checkIfBoardIsFull(board)) {
                System.out.println("This game is a draw");
                break;
            }
        }



//        printBoard(board);
    }

   public static void printBoard(char[][] board) {
       for(int i = 0; i < board.length; i++) {
           for(int j = 0; j < board[i].length; j++) {
               System.out.print(board[i][j]);
           }
           System.out.println();
       }
   }

   // playerHasWon() was gotten from https://junilearning.com/blog/coding-projects/java-beginner-tic-tac-toe-tutorial/
    public static char playerHasWon(char[][] board) {

        //EXTENSION: Check each row
        for(int i = 0; i < board.length; i++) {

            //EXTENSION: The boolean inARow is true if a player has won by putting n of their chars in row i and false otherwise
            boolean inARow = true;
            //EXTENSION: The char value is one of the chars in row i; we can use this to check if every other char in row i is equal to value
            char value = board[i][0];

            //EXTENSION: First we have to check if the value is not -, because if it is, that means that there is an empty spot in the row so we can automatically say that inARow is false
            if(value == '-') {
                inARow = false;

                //EXTENSION: Otherwise, we can use a nested for loop to check each position in the row starting at index 1 (since index 0 is our value and we don't need to check if board[i][0] equals value) and check if that position equals value
            } else {
                for(int j = 1; j < board[i].length; j++) {
                    //EXTENSION: If board[i][j] doesn't equal value, then we know that inARow is false; we can also break out of the nested for loop because we don't need to look at the rest of this row
                    if(board[i][j] != value) {
                        inARow = false;
                        break;
                    }
                }
            }

            //EXTENSION: If inARow is true, then we know that each position in row i had a char equal to value which was not a -. In other words, a player has won so we can return value (the char of the winner)
            if(inARow) {
                return value;
            }

        }

        //EXTENSION: We can use the same construction to check each column
        for(int j = 0; j < board[0].length; j++) {

            boolean inACol = true;
            char value = board[0][j];

            if(value == '-') {
                inACol = false;

            } else {
                for(int i = 1; i < board.length; i++) {
                    if(board[i][j] != value) {
                        inACol = false;
                        break;
                    }
                }
            }

            if(inACol) {
                return value;
            }

        }

        //EXTENSION: We can use a similar construction to check the diagonals

        //EXTENSION: Check the diagonal going from upper left to bottom right: [0][0], [1][1], [2][2]...

        boolean inADiag1 = true;
        char value1 = board[0][0];

        if(value1 == '-') {
            inADiag1 = false;

        } else {
            for(int i = 1; i < board.length; i++) {
                if(board[i][i] != value1) {
                    inADiag1 = false;
                    break;
                }
            }
        }

        if(inADiag1) {
            return value1;
        }

        //EXTENSION: Check the diagonal going from upper right to bottom left: [0][n-1], [1][n-2], [2][n-3]...

        boolean inADiag2 = true;
        char value2 = board[0][board.length-1];

        if(value2 == '-') {
            inADiag2 = false;

        } else {
            for(int i = 1; i < board.length; i++) {
                if(board[i][board.length-1-i] != value2) {
                    inADiag2 = false;
                    break;
                }
            }
        }

        if(inADiag2) {
            return value2;
        }

        //Otherwise nobody has not won yet
        return ' ';

    }

    public static boolean checkIfBoardIsFull(char[][] board) {
        boolean isFull = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '-') {
                    isFull = false;
                }
            }
        }
        return isFull;
    }
}


