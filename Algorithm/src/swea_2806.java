import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    /**
     * board[i] = j;
     * i : row, j : col
     * 퀸을 놓을 수 있는 곳 : 대각선, 위, 아래로 없어야함
     * nQueen 함수에서 row 하나씩 증가시키면서 만약 row가 N이랑 같으면 count 증가
     */
    static int[] board;
    static int N;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            board = new int[N];
            count = 0;
            nQueen(0, 0);
            sb.append("#" + tc + " " + count + "\n");
        }
        System.out.println(sb);
    }

    public static void nQueen(int row, int col) {
        if (row == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (check(row, i)) {
                board[row] = i;
                nQueen(row + 1, i);
            }
        }
    }

    public static boolean check(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || (row - i) == Math.abs(board[i] - col)) {
                return false;
            }
        }
        return true;
    }

}
