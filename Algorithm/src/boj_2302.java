import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] cases = new int[N + 1];
        int[] vip = new int[M];
        for (int i = 0; i < M; i++) {
            vip[i] = Integer.parseInt(br.readLine());
        }
        cases[0] = 1;
        cases[1] = 1;
        for (int i = 2; i <= N; i++) {
            cases[i] = cases[i - 1] + cases[i - 2];
        }
        int result = 1;
        int before = 0;
        for (int i = 0; i < M; i++) {
            int count = cases[vip[i] - before - 1];
            result *= count;
            before = vip[i];
        }
        result *= cases[N - before];
        System.out.println(result);
    }

}
