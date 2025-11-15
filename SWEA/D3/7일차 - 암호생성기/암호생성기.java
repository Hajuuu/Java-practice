import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static boolean[] done;
    static List<Integer> cycle;
    static int count;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < 8; i++) {
                queue.offer(Integer.parseInt(st.nextToken()));
            }
            int cnt = 0;
            while (true) {
                int now = queue.poll();
                now -= (cnt % 5) + 1;
                cnt++;
                if (now <= 0) {
                    queue.offer(0);
                    break;
                }
                queue.offer(now);

            }
            sb.append("#" + tc);
            while (!queue.isEmpty()) {
                sb.append(" " + queue.poll());
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }


}
