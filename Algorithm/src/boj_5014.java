import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_5014 {

	static int F, S, G, U, D;
	static int[] num;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		num = new int[F + 1];
		visit = new boolean[F + 1];
		bfs();
		
		if(num[G] == 0) {
			if(G == S) {
				System.out.println(0);
			} else {
				System.out.println("use the stairs");
			}
			
		} else {
			System.out.println(num[G]);
		}
	}
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(S);
		while(!queue.isEmpty()) {
			int now = queue.poll();
			visit[now] = true;
			int next1 = now + U;
			int next2 = now - D;
			if(next1 > 0 && next1 <= F) {
				if(!visit[next1]) {
					num[next1] = num[now] + 1;
					visit[next1] = true;
					queue.offer(next1);
				}
			}
			
			if(next2 > 0 && next2 <= F) {
				if(!visit[next2]) {
					num[next2] = num[now] + 1;
					visit[next2] = true;
					queue.offer(next2);
				}
			}
			
			
		}
	}

}

