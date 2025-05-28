import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int K, N;
    static int[] LAN;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        LAN = new int[K];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < K; i++) {
            LAN[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, LAN[i]);
        }

        long result = binarySearch(max);
        System.out.println(result);
    }

    /**
     * 자를 길이를 탐색한다.
     * start = 1, end = 가지고 있는 랜선의 최댓값
     *
     * @param max
     * @return 자를 수 있는 최대 길이
     */
    public static long binarySearch(long max) {
        long start = 1;
        long end = max;
        long result = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            if (countLines(mid) >= N) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }


    /**
     * @param length
     * @return length로 잘랐을 때 만들 수 있는 랜선의 개수
     */
    public static long countLines(long length) {
        long count = 0;
        for (int i = 0; i < K; i++) {
            count += LAN[i] / length;
        }
        return count;
    }
}
