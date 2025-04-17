import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        StringJoiner sj = new StringJoiner(", ", "<", ">");
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        while (!deque.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                deque.offer(deque.poll());
            }
            sj.add(String.valueOf(deque.poll()));
        }
        System.out.println(sj);

    }

}
