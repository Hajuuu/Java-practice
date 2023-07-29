import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class boj_1744 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> queue1 = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> queue2 = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num < 0) {
				queue2.offer(num);
			} else {
				queue1.offer(num);
			}
		}
		
		int sum = 0;
		if(N == 1) {
			if(!queue1.isEmpty()) {
				System.out.println(queue1.poll());
			} else if(!queue2.isEmpty()) {
				System.out.println(queue2.poll());
			}
			
			return;
		}
		while(queue1.size() > 1) {
			int a = queue1.poll();
			int b = queue1.poll();
			if(a > 1 && b > 1) {
				sum += a * b;
			} else {
				sum += a;
				queue1.offer(b);
			}
		}
		
		while(queue2.size() > 1) { 
			int a = queue2.poll();
			int b = queue2.poll();
			sum += a * b;
		}
		
		
		if(!queue1.isEmpty()) {
			if(queue1.peek() == 0 && !queue2.isEmpty()) {
				sum += queue1.poll() * queue2.poll();
			} else if(queue1.peek() >= 1) {
				sum += queue1.poll();
			}
		}
		if(!queue2.isEmpty()) {
			sum += queue2.poll();
		}
		System.out.println(sum);
	}

}
