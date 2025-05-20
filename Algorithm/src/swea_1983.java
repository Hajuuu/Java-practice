import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    /**
     * N명의 학생이 있을 경우 N / 10 명의 학생들에게 동일한 평점 부여 가능
     * 총점 : 중간고사 (35) + 기말고사 (45) + 과제 (20)
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        String[] scores = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "DO"};
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            PriorityQueue<Student> queue = new PriorityQueue<>((o1, o2) -> (int) (o2.totalScore - o1.totalScore));
            Map<Integer, String> students = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int mid = Integer.parseInt(st.nextToken());
                int fin = Integer.parseInt(st.nextToken());
                int exam = Integer.parseInt(st.nextToken());
                double totalScore = mid * 0.35 + fin * 0.45 + exam * 0.2;
                queue.offer(new Student(i, totalScore));
                students.put(i, "");
            }
            int idx = 0;
            while (!queue.isEmpty()) {
                for (int i = 0; i < N / 10; i++) {
                    Student nowStudent = queue.poll();
                    students.put(nowStudent.id, scores[idx]);
                }
                idx++;
            }
            sb.append("#" + tc + " " + students.get(K - 1) + "\n");

        }
        System.out.println(sb);
    }

}

class Student {
    int id;
    double totalScore;

    Student(int id, double totalScore) {
        this.id = id;
        this.totalScore = totalScore;
    }
}
