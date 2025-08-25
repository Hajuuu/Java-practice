import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer> budgets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        budgets = new ArrayList<>();
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int budget = Integer.parseInt(st.nextToken());
            budgets.add(budget);
            end = Math.max(end, budget);
        }
        int M = Integer.parseInt(br.readLine());

        int start = 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (checkBudget(mid) <= M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(start - 1);
    }

    public static int checkBudget(int budget) {
        int sum = 0;
        for (int i : budgets) {
            if (i <= budget) {
                sum += i;
            } else {
                sum += budget;
            }
        }
        return sum;
    }


}
