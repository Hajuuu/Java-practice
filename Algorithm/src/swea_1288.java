import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * N의 배수로 양을 센다.
     * 0 ~ 9까지 모든 숫자를 보는데 얼마나 걸리는지
     * 예를들어 N이 1이면 10 * 1, 즉 10일 때 0~9 까지의 숫자를 볼 수 있음
     * List에 0~9 넣어놓고 리스트가 비면 return
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            List<String> nums = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                nums.add(String.valueOf(i));
            }
            int x = 0;
            while (!nums.isEmpty()) {
                x++;
                String count = String.valueOf(x * N);
                for (int i = 0; i < count.length(); i++) {
                    nums.remove(String.valueOf(count.charAt(i)));

                }
            }
            sb.append("#" + tc + " " + (x * N) + "\n");
        }
        System.out.println(sb);
    }

}
