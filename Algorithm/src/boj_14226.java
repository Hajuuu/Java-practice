import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class boj_14226 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int S = Integer.parseInt(br.readLine());
		
		System.out.println(bfs(S));
	}
	
	public static int bfs(int s) {
		Queue<Emoji> queue = new ArrayDeque<>();
		
		boolean[][] visit = new boolean[1001][1001];
		
		queue.offer(new Emoji(0, 1, 0));
		visit[0][1] = true;
		while(!queue.isEmpty()) {
			Emoji now = queue.poll();
			
			if(now.total == s) {
				return now.time;
			}
			
			queue.offer(new Emoji(now.total, now.total, now.time + 1));
			
			if(now.clip != 0 && now.total + now.clip <= s && !visit[now.clip][now.total + now.clip]) {
				queue.offer(new Emoji(now.clip, now.total + now.clip, now.time + 1));
				visit[now.clip][now.clip + now.total] = true;
			}
			
			if(now.total >= 1 && !visit[now.clip][now.total - 1]) {
				queue.offer(new Emoji(now.clip, now.total - 1, now.time + 1));
				visit[now.clip][now.total - 1] = true;
			}
		}
		return 0;
	}

}

class Emoji {
	int clip;
	int total;
	int time;
	
	Emoji(int clip, int total, int time) {
		this.clip = clip;
		this.total = total;
		this.time = time;
	}
}
	

