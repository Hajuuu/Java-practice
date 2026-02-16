import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        ArrayDeque<String> queue;

        for (int tc = 0; tc < T; tc++) {
            queue = new ArrayDeque<>();
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            int d = 0;
            int r = 0;
            String[] numbers = br.readLine().replace("[", "").replace("]", "").split(",");
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == 'D') {
                    d++;
                }
            }
            r = p.length() - d;
            if (d > n) {
                sb.append("error" + "\n");
                continue;
            }
            if (d == n) {
                sb.append("[]" + "\n");
                continue;
            }

            for (String num : numbers) {
                queue.offer(num);
            }

            int check = 1;
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == 'D') {
                    if (check == 1) {
                        queue.poll();
                    } else {
                        queue.pollLast();
                    }
                } else {
                    check *= -1;
                }
            }

            int size = queue.size();
            sb.append("[");
            if (r % 2 != 0) {
                for (int i = 0; i < size - 1; i++) {
                    sb.append(queue.pollLast() + ",");
                }
            } else {
                for (int i = 0; i < size - 1; i++) {
                    sb.append(queue.poll() + ",");
                }
            }
            sb.append(queue.poll() + "]\n");


        }

        System.out.println(sb);
    }
}
