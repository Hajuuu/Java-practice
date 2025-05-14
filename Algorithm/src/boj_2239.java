import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int[][] board;
    static List<int[]> blanks;
    static boolean check = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[9][9];
        blanks = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = line.charAt(j) - '0';
                if (board[i][j] == 0) {
                    blanks.add(new int[]{i, j});
                }
            }
        }

        backtracking(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void backtracking(int idx) {
        if (idx == blanks.size()) {
            check = true;
            return;
        }

        int[] p = blanks.get(idx);
        for (int i = 1; i <= 9; i++) {
            if (isValid(p[0], p[1], i)) {
                board[p[0]][p[1]] = i;
                backtracking(idx + 1);
                if (check) {
                    return;
                }
                board[p[0]][p[1]] = 0;

            }
        }
    }

    public static boolean isValid(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num || board[row][i] == num) {
                return false;
            }
        }

        int x = (row / 3) * 3;
        int y = (col / 3) * 3;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
