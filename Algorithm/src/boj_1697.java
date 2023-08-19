import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1697 {


	static int[] time;
	static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		time = new int[100001];
		
		if(N == K) {
			System.out.println(0);
			return;
		} else {
			BFS(N);
		}
		
		System.out.println(time[K]);
	}
	
	public static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		time[start] = 0;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			if(now == K) {
				return;
			}
			int next = 0;
			for(int i = 0; i < 3; i++) {
				if(i == 0) {
					next = now + 1;
				} else if(i == 1) {
					next = now - 1;
				}
				else {
					next = now * 2;
				}
				
				if(next >= 0 && next <= 100000 && time[next] == 0) {
					time[next] = time[now] + 1;
					queue.offer(next);
				}
			}
			
		}
	}

}
