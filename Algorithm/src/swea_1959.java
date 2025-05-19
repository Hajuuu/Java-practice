import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[][] map;
    static String[][] rotationMap;

    /**
     * 슬라이딩 윈도우랑 비슷한 느낌..
     * 0 ~ B.length - A.length만큼 밀 수 있다.
     * 이중 for문 i -> 몇 칸 밀지, j -> M
     * N과 M 중 뭐가 더 큰지 모르므로 큰 값을 M으로 넣는다.
     */
    static int[] A;
    static int[] B;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            A = new int[N];
            B = new int[M];
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            int sum = 0;
            if (N > M) {
                sum = count(B, A);
            } else {
                sum = count(A, B);
            }
            sb.append("#" + tc + " " + sum + "\n");
        }
        System.out.println(sb);
    }

    public static int count(int[] shortArr, int[] longArr) {
        int diff = Math.abs(shortArr.length - longArr.length) + 1;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < diff; i++) {
            int sum = 0;
            for (int j = i; j < i + shortArr.length; j++) {
                sum += longArr[j] * shortArr[j - i];
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
