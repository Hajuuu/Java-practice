import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        makePrime(N);
        for (int i = M; i <= N; i++) {
            if (prime[i]) {
                sb.append(i + "\n");
            }
        }
        System.out.println(sb);
    }

    public static void makePrime(int N) {
        prime = new boolean[N + 1];
        Arrays.fill(prime, true);

        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (!prime[i]) {
                continue;
            }
            for (int j = i * i; j <= N; j += i) {
                prime[j] = false;
            }
        }
    }
}
