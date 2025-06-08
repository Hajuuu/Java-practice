import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            List<int[]> scores = new ArrayList<>();
            int answer = 1;
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                scores.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }
            scores.sort((o1, o2) -> o1[0] - o2[0]);
            int bestScore = scores.get(0)[1];
            for (int j = 1; j < scores.size(); j++) {
                if (scores.get(j)[1] < bestScore) {
                    bestScore = scores.get(j)[1];
                    answer++;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

}
