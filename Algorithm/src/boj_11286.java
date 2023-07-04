import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj_11286 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
			int first = Math.abs(o1);
			int second = Math.abs(o2);
			
			if(first == second) {
				return o1 > o2 ? 1 : -1;
			} else {
				return first - second;
			}
		});
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(queue.isEmpty()) {
					sb.append("0\n");
				} else {
					sb.append(queue.poll() + "\n");
				}
			} else {
				queue.add(num);
			}
		}
		
		System.out.println(sb);
	}

}
