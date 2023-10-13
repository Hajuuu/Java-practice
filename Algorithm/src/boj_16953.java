import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16953 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		
		int answer = bfs(A, B);
		
		System.out.println(answer);
		
	}
	
	public static int bfs(long a, long b) {
		Queue<Long> queue = new LinkedList<>();
		queue.offer(a);
		int count = 0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i = 0; i < size; i++) {
				long now = queue.poll();
				if(now == b) {
					return count + 1;
				}
				
				if(now * 2 <= b) {
					queue.offer(now * 2);
				}
				if(now * 10 + 1 <= b) {
					queue.offer(now * 10 + 1);
				}
				
			}
			count++;
			
		}
		return -1;
	}

}
