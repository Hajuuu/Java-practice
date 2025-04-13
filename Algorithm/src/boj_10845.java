import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String token = st.nextToken();
            if (token.equals("push")) {
                deque.offer(Integer.parseInt(st.nextToken()));
                continue;
            }
            if (token.equals("pop")) {
                sb.append((deque.isEmpty() ? -1 : deque.poll()) + "\n");
                continue;
            }
            if (token.equals("front")) {
                sb.append((deque.isEmpty() ? -1 : deque.getFirst()) + "\n");
                continue;
            }
            if (token.equals("back")) {
                sb.append((deque.isEmpty() ? -1 : deque.getLast()) + "\n");
                continue;
            }
            if (token.equals("empty")) {
                sb.append((deque.isEmpty() ? 1 : 0) + "\n");
                continue;
            }
            if (token.equals("size")) {
                sb.append(deque.size() + "\n");
            }
        }
        System.out.println(sb);
    }

}
