import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[][] map;
    static String[][] rotationMap;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            rotationMap = new String[N][3];
            sb.append("#" + tc + "\n");
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            turn(N);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    sb.append(rotationMap[i][j] + " ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    /**
     * 1. 90도 회전
     * i : 2 -> 0, j : 0 map[0][0]
     * i : 2 -> 0, j : 1 map[1][0]
     * i : 2 -> 0, j : 2 map[2][0]
     * <p>
     * 2. 180도 회전
     * i : 2, j : 2 -> 0 map[0][1]
     * i : 1, j : 2 -> 0 map[1][1]
     * i : 0, j : 2 -> 0 map[2][1]
     * <p>
     * 3. 270도 회전
     * i : 0 -> 2, j : 2 map[0][2]
     * i : 0 -> 2, j : 1 map[1][2]
     * i : 0 -> 2, j : 0 map[2][2]
     */
    public static void turn(int N) {
        String num = "";
        int col = 0;
        for (int i = 0; i < N; i++) {
            for (int j = N - 1; j >= 0; j--) {
                num += map[j][i];
            }
            rotationMap[i][col] = num;
            num = "";
        }
        col++;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                num += map[i][j];
            }
            rotationMap[N - i - 1][col] = num;
            num = "";
        }
        col++;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                num += map[j][i];
            }
            rotationMap[N - i - 1][col] = num;
            num = "";
        }
    }

}
