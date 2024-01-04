import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14891 {

	static int[] dx = {1, -1};
	static ArrayList<Integer>[] gear;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		gear = new ArrayList[5];
		
		for(int i = 1; i <= 4; i++) {
			gear[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= 4; i++) {
			String str = br.readLine();
			for(int j = 0; j < str.length(); j++) {
				gear[i].add(str.charAt(j) - '0');
			}
		}
		
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			rotation(num, direction);
		}
		
		int answer = 0;
		for(int i = 0; i < 4; i++) {
			if(gear[i + 1].get(0) == 1) {
				answer += Math.pow(2, i);
			}
		}
		
		System.out.println(answer);
		
		
	}

	
	public static void rotation(int num, int direction) {
		Queue<int[]> queue = new ArrayDeque<>();
		Queue<int[]> queue2 = new ArrayDeque<>();
		queue.offer(new int[] {num, direction});
		queue2.offer(new int[] {num, direction});
		boolean[] visit = new boolean[5];
		visit[num] = true;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int i = 0; i < 2; i++) {
				int next = now[0] + dx[i];
				if(next > 0 && next < 5) {
					if(!visit[next] && now[0] > next && (gear[next].get(2) != gear[now[0]].get(6))) {
						visit[next] = true;
						queue.offer(new int[] {next, now[1] * -1});
						queue2.offer(new int[] {next, now[1] * -1});
					}
					if(!visit[next] && now[0] < next && (gear[next].get(6) != gear[now[0]].get(2))) {
						visit[next] = true;
						queue.offer(new int[] {next, now[1] * -1});
						queue2.offer(new int[] {next, now[1] * -1});
					}
				}
			}
		}
		while(!queue2.isEmpty()) {
			int[] now = queue2.poll();
			if(now[1] == -1) {
				int n = gear[now[0]].get(0);
				gear[now[0]].remove(0);
				gear[now[0]].add(7, n);
			}
			
			if(now[1] == 1) {
				int n = gear[now[0]].get(7);
				gear[now[0]].remove(7);
				gear[now[0]].add(0, n);
			}
		}
	}
}
