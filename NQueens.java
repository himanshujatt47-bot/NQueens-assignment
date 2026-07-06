import java.util.*;

public class NQueens {

    static List<List<String>> solutions = new ArrayList<>();

    public static void solve(int n) {
        char[][] board = new char[n][n];

        // Fill board with '#'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '#');
        }

        backtrack(board, 0, n);

        // Print all solutions
        System.out.println("Solutions:");
        for (List<String> sol : solutions) {
            for (String row : sol) {
                System.out.println(row);
            }
            System.out.println();
        }

        // Print total count
        System.out.println("Total Count = " + solutions.size());
    }

    static void backtrack(char[][] board, int row, int n) {
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (char[] r : board) {
                temp.add(new String(r));
            }
            solutions.add(temp);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrack(board, row + 1, n);
                board[row][col] = '#';
            }
        }
    }

    static boolean isSafe(char[][] board, int row, int col, int n) {

        // Check same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q')
                return false;
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of n: ");
        int n = sc.nextInt();

        solve(n);
    }
}