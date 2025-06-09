import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<List<Integer>> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        int[] index = new int[N + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        index[1] = -1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i : tree.get(cur)) {
                if (index[i] == 0) {
                    index[i] = cur;
                    queue.offer(i);
                }

            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(index[i] + "\n");
        }
        System.out.println(sb);
    }
}
