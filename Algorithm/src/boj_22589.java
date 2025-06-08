import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static int time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        time = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                if (input.charAt(j) == 'W') {
                    map[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }
        System.out.println(time);
    }

    public static void bfs(int startX, int startY) {
        Deque<int[]> queue = new ArrayDeque<>();
        int[][] distance = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                distance[i][j] = -1;
            }
        }
        distance[startX][startY] = 0;
        queue.offer(new int[]{startX, startY});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            time = Math.max(time, distance[cur[0]][cur[1]]);
            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + dx[i];
                int nextY = cur[1] + dy[i];
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
                    continue;
                }
                if (distance[nextX][nextY] == -1 && map[nextX][nextY] == 0) {
                    distance[nextX][nextY] = distance[cur[0]][cur[1]] + 1;
                    queue.offer(new int[]{nextX, nextY});
                }

            }
        }
    }
}
