import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;
        int[] num = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = num[start];
        while (start < N && end < N) {
            if (sum == M) {
                count++;
                start++;
                sum -= num[start - 1];
                continue;
            }
            if (sum > M) {
                start++;
                sum -= num[start - 1];
                continue;
            }
            end++;
            if (end < N) {
                sum += num[end];
            }

        }
        System.out.println(count);
    }

}
