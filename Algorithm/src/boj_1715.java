import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj_1715 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			queue.offer(Integer.parseInt(br.readLine()));
		}
		
		if(N == 1) {
			System.out.println(0);
			return;
		}
		
		int sum = 0;
		int count = 0;
		while(queue.size() > 1) {
			count = queue.poll() + queue.poll();
			sum += count;
			queue.offer(count);
		}
		
		System.out.println(sum);
	}

}
