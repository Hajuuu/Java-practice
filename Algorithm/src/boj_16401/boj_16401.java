import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer> snacks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        snacks = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int length = Integer.parseInt(st.nextToken());
            snacks.add(length);
            maxLength = Math.max(length, maxLength);
        }

        int start = 1;
        int end = maxLength;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (countSnack(mid) >= M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        System.out.println(start - 1);
    }

    public static int countSnack(int length) {
        int count = 0;
        for (int i : snacks) {
            count += i / length;
        }
        return count;
    }

}
