import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] setA = new int[A];
        int[] setB = new int[B];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            setA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            setB[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(setA);
        Arrays.sort(setB);
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            int start = 0;
            int end = setB.length - 1;
            int findNum = setA[i];
            boolean check = true;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (findNum == setB[mid]) {
                    check = false;
                    break;
                }
                if (findNum > setB[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            if (check) {
                answer.add(findNum);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size() + "\n");
        for (int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i) + " ");
        }
        System.out.println(sb);
    }


}
