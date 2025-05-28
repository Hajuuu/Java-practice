import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] card;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        card = new int[N];
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int lower = findLowerBound(arr[i]);
            int upper = findUpperBound(arr[i]);
            sb.append(upper - lower + "\n");

        }
        System.out.println(sb);
    }

    public static int findLowerBound(int key) {
        int start = 0;
        int end = N;
        while (start < end) {
            int mid = (start + end) / 2;
            if (card[mid] >= key) {
                end = mid;
                continue;
            }
            if (card[mid] < key) {
                start = mid + 1;
            }
        }
        return start;
    }

    public static int findUpperBound(int key) {
        int start = 0;
        int end = N;
        while (start < end) {
            int mid = (start + end) / 2;
            if (card[mid] > key) {
                end = mid;
                continue;
            }
            if (card[mid] <= key) {
                start = mid + 1;
            }
        }
        return start;
    }

}
