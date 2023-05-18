import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1225 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			Queue<Integer> queue = new LinkedList<>();
			
			for(int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			
			boolean check = true;
			while(check) {
				for(int i = 1; i <= 5; i++) {
					int num = queue.poll();
					if(num - i <= 0) {
						queue.offer(0);
						check = false;
						break;
					}
					queue.offer(num - i);
				}
			}
			
			sb.append("#" + t + " ");
			while(!queue.isEmpty()) {
				sb.append(queue.poll() + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
