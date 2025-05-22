import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    /**
     * String 숫자를 저장한 리스트 생성
     * String num과 int num을 갖는 클래스 정의
     * PriorityQueue에 넣어서 int 순서대로 정렬
     * 이후 출력
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> numbers = Arrays.asList("ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN");

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#" + tc + "\n");
            st = new StringTokenizer(br.readLine());
            String t = st.nextToken();
            int N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            PriorityQueue<Number> queue = new PriorityQueue<Number>((o1, o2) -> o1.intNum - o2.intNum);
            for (int i = 0; i < N; i++) {
                String num = st.nextToken();
                queue.offer(new Number(num, numbers.indexOf(num)));
            }
            while (!queue.isEmpty()) {
                sb.append(queue.poll().strNum + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}

class Number {
    String strNum;
    int intNum;

    Number(String strNum, int intNum) {
        this.strNum = strNum;
        this.intNum = intNum;
    }
}
