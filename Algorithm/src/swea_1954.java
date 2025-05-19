import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    static int[][] numbers;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            numbers = new int[N][N];
            turn(N);
            sb.append("#" + tc + "\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(numbers[i][j] + " ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    public static void turn(int N) {
        int nowX = 0;
        int nowY = 0;
        int count = 1;
        int dir = 0;
        numbers[nowX][nowY] = count++;
        while (count <= N * N) {
            int nextX = nowX + dx[dir];
            int nextY = nowY + dy[dir];
            if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
                dir = (dir + 1) % 4;
                continue;
            }
            if (numbers[nextX][nextY] == 0) {
                nowX = nextX;
                nowY = nextY;
                numbers[nextX][nextY] = count++;
                continue;
            }
            dir = (dir + 1) % 4;
        }
    }

}
