import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_3499 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			Queue<String> card1 = new ArrayDeque<>();
			Queue<String> card2 = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine());
			int num = 0;
			if(N % 2 == 0) {
				num = N / 2;
			} else {
				num = N / 2 + 1;
			}
			for(int i = 0; i < num; i++) {
				card1.offer(st.nextToken());
			}
			for(int i = num; i < N; i++) {
				card2.offer(st.nextToken());
			}
			sb.append("#" + tc);
			while(!card2.isEmpty()) {
				sb.append(" ");
				sb.append(card1.poll());
				sb.append(" ");
				sb.append(card2.poll());
			}
			if(!card1.isEmpty()) {
				sb.append(" " + card1.poll());
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
		
		
	}

}
