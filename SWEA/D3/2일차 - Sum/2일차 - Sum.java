import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] arr = new int[100][100];
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
            int tc = Integer.parseInt(br.readLine());
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int sum = sum(arr);
            sb.append("#" + tc + " " + sum + "\n");
        }
        System.out.println(sb);
    }

    public static int sum(int[][] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = 0;
            for (int j = 0; j < arr.length; j++) {
                sum += arr[i][j];
            }
            max = Math.max(max, sum);
        }

        for (int i = 0; i < arr.length; i++) {
            sum = 0;
            for (int j = 0; j < arr.length; j++) {
                sum += arr[j][i];
            }
            max = Math.max(max, sum);
        }

        sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
        }
        max = Math.max(max, sum);

        sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[arr.length - 1 - i][i];
        }
        max = Math.max(max, sum);

        return max;
    }

}
