import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] S;
    static boolean[] isStartTeam;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        S = new int[N][N];
        isStartTeam = new boolean[N];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    public static void dfs(int start, int depth) {
        if (depth == N / 2) {
            countDiff();
            return;
        }

        for (int i = start; i < N; i++) {
            if (!isStartTeam[i]) {
                isStartTeam[i] = true;
                dfs(i, depth + 1);
                isStartTeam[i] = false;
            }
        }
    }

    public static void countDiff() {
        int startStat = 0;
        int linkStat = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isStartTeam[i] && isStartTeam[j]) {
                    startStat += S[i][j] + S[j][i];
                } else if (!isStartTeam[i] && !isStartTeam[j]) {
                    linkStat += S[i][j] + S[j][i];
                }
            }
        }

        int diff = Math.abs(startStat - linkStat);
        if (diff == 0) {
            System.out.println(0);
            System.exit(0);
        }

        answer = Math.min(answer, diff);
    }
}
