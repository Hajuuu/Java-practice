import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static boolean[] visited;
    static boolean[] done;
    static List<Integer> cycle;
    static int count;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        done = new boolean[N + 1];
        count = 0;
        cycle = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            if (done[i]) {
                continue;
            }
            dfs(i);
        }

        sb.append(count + "\n");
        Collections.sort(cycle);
        for (int i : cycle) {
            sb.append(i + "\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int start) {
        if (done[start]) {
            return;
        }
        if (visited[start]) {
            done[start] = true;
            count++;
            cycle.add(start);
        }
        visited[start] = true;
        dfs(arr[start]);
        visited[start] = false;
        done[start] = true;
    }

}
