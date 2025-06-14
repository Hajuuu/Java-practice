import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            Deque<int[]> queue = new ArrayDeque<>();
            List<Integer> important = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                int importance = Integer.parseInt(st.nextToken());
                queue.offer(new int[]{i, importance});
                important.add(importance);
            }
            int count = 0;
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                boolean check = false;
                for (int i : important) {
                    if (cur[1] < i) {
                        check = true;
                        break;
                    }
                }
                if (check) {
                    queue.offer(cur);
                    continue;
                }
                important.remove(Integer.valueOf(cur[1]));
                count++;
                if (cur[0] == M) {
                    break;
                }
            }
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }

}
