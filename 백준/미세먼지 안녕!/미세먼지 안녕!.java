import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static int R, C, T;
    static int[] dirX = {0, 1, 0, -1};
    static int[] dirY = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[R][C];
        int bottom = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == -1) {
                    bottom = i;
                }
            }
        }

        for (int i = 0; i < T; i++) {
            spreadDust();
            purifierOperation(bottom);
        }

        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == -1) {
                    continue;
                }
                answer += arr[i][j];
            }
        }
        System.out.println(answer);
    }

    public static void spreadDust() {
        int[][] temp = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == -1) {
                    temp[i][j] = -1;
                    continue;
                }

                if (arr[i][j] == 0) {
                    continue;
                }

                int count = 0;
                for (int d = 0; d < 4; d++) {
                    int nextX = i + dirX[d];
                    int nextY = j + dirY[d];
                    if (nextX >= 0 && nextX < R && nextY >= 0 && nextY < C && arr[nextX][nextY] >= 0) {
                        temp[nextX][nextY] += arr[i][j] / 5;
                        count++;
                    }
                }

                temp[i][j] += arr[i][j] - (arr[i][j] / 5) * count;
            }
        }

        arr = temp;
    }


    public static void purifierOperation(int bottom) {
        int top = bottom - 1;
        for (int i = top - 1; i > 0; i--) {
            arr[i][0] = arr[i - 1][0];
        }

        for (int i = 0; i < C - 1; i++) {
            arr[0][i] = arr[0][i + 1];
        }

        for (int i = 0; i < top; i++) {
            arr[i][C - 1] = arr[i + 1][C - 1];
        }

        for (int i = C - 1; i > 1; i--) {
            arr[top][i] = arr[top][i - 1];
        }
        arr[top][1] = 0;

        for (int i = bottom + 1; i < R - 1; i++) {
            arr[i][0] = arr[i + 1][0];
        }

        for (int i = 0; i < C - 1; i++) {
            arr[R - 1][i] = arr[R - 1][i + 1];
        }

        for (int i = R - 1; i > bottom; i--) {
            arr[i][C - 1] = arr[i - 1][C - 1];
        }

        for (int i = C - 1; i > 1; i--) {
            arr[bottom][i] = arr[bottom][i - 1];
        }

        arr[bottom][1] = 0;
    }

}
