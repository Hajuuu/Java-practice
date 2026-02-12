import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
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
        int purifier = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == -1) {
                    purifier = i;
                }
            }
        }

        for (int i = 0; i < T; i++) {
            spreadDust();
            purifierOperation(purifier);
        }

        int answer = 0;
        for (int[] num : arr) {
            for (int n : num) {
                if (n < 0) {
                    continue;
                }
                answer += n;
            }
        }

        System.out.println(answer);
    }

    public static void spreadDust() {
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] temp = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                temp[i][j] = arr[i][j];
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] > 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int count = 0;
            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + dirX[i];
                int nextY = now[1] + dirY[i];
                if (nextX >= 0 && nextY >= 0 && nextX < R && nextY < C && arr[nextX][nextY] >= 0) {
                    temp[nextX][nextY] += arr[now[0]][now[1]] / 5;
                    count++;
                }
            }
            int size = arr[now[0]][now[1]];
            temp[now[0]][now[1]] -= (size / 5) * count;
        }

        arr = temp;
    }


    public static void purifierOperation(int x) {
        int nowX1 = x - 1;
        int nowX2 = x;
        int nowY1 = 0;
        int nowY2 = 0;
        Queue<Integer> dust = new ArrayDeque<>();
        for (int i = 0; i < 4; i++) {
            while (true) {
                boolean check = false;
                if (nowX1 + dirX[i] * -1 < 0 || nowX1 + dirX[i] * -1 >= R || nowY1 + dirY[i] < 0
                        || nowY1 + dirY[i] >= C || (nowX1 + dirX[i] * -1 == x - 1 && nowY1 + dirY[i] == 0)) {
                    break;
                }

                nowX1 += dirX[i] * -1;
                nowY1 += dirY[i];
                if (arr[nowX1][nowY1] > 0) {
                    dust.offer(arr[nowX1][nowY1]);
                    check = true;
                }
                if (dust.size() > 1) {
                    arr[nowX1][nowY1] = dust.poll();
                } else if (dust.size() == 1 && !check) {
                    arr[nowX1][nowY1] = dust.poll();
                } else {
                    arr[nowX1][nowY1] = 0;
                }


            }
        }

        dust = new ArrayDeque<>();

        for (int i = 0; i < 4; i++) {
            while (true) {
                boolean check = false;
                if (nowX2 + dirX[i] < 0 || nowX2 + dirX[i] >= R || nowY2 + dirY[i] < 0
                        || nowY2 + dirY[i] >= C || (nowX2 + dirX[i] == x && nowY2 + dirY[i] == 0)) {
                    break;
                }

                nowX2 += dirX[i];
                nowY2 += dirY[i];
                if (arr[nowX2][nowY2] > 0) {
                    dust.offer(arr[nowX2][nowY2]);
                    check = true;
                }
                if (dust.size() > 1) {
                    arr[nowX2][nowY2] = dust.poll();
                } else if (dust.size() == 1 && !check) {
                    arr[nowX2][nowY2] = dust.poll();
                } else {
                    arr[nowX2][nowY2] = 0;
                }


            }
        }
    }

}
