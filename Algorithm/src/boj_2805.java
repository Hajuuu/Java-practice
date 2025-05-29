import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trees = new int[N];
        st = new StringTokenizer(br.readLine());
        long max = -1;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }
        long length = search(0, max);
        System.out.println(length);
    }

    /**
     * 절단기에 설정할 수 있는 높이를 구하는 문제
     *
     * @param start : 설정할 수 있는 높이의 최솟값
     * @param end   : 설정할 수 있는 높이의 최댓값
     * @return 절단기의 최대 높이
     */
    public static long search(long start, long end) {
        long length = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            if (totalLength(mid) >= M) {
                length = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return length;
    }

    public static long totalLength(long length) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if (trees[i] < length) {
                continue;
            }
            sum += trees[i] - length;
        }
        return sum;
    }
}
