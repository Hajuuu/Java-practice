import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        double sum = 0.0;
        int[] arr = new int[N];
        Map<Integer, Integer> map = new HashMap<>();

        if (N == 1) {
            int num = Integer.parseInt(br.readLine());
            sb.append(num + "\n");
            sb.append(num + "\n");
            sb.append(num + "\n");
            sb.append(0);
            System.out.println(sb);
            return;
        }

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            arr[i] = num;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        sb.append(Math.round(sum / N) + "\n");
        Arrays.sort(arr);
        sb.append(arr[N / 2] + "\n");
        List<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet, (o1, o2) -> {
            if (map.get(o1) == map.get(o2)) {
                return o1 - o2;
            }
            return map.get(o2) - map.get(o1);
        });

        if (map.get(keySet.get(0)) == map.get(keySet.get(1))) {
            sb.append(keySet.get(1) + "\n");
        } else {
            sb.append(keySet.get(0) + "\n");
        }

        sb.append(arr[N - 1] - arr[0] + "\n");
        System.out.println(sb);
    }
}
