import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_11403 {

	static ArrayList<Integer>[] nodeList;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		nodeList = new ArrayList[N];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			nodeList[i] = new ArrayList<>();
		}
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				if(Integer.parseInt(st.nextToken()) == 1) {
					nodeList[i].add(j);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				visit = new boolean[N];
				boolean check = bfs(i, j);
				if(check) {
					sb.append("1 ");
				}
				else {
					sb.append("0 ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
	public static boolean bfs(int a, int b) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(a);
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int i : nodeList[now]) {
				if(visit[i]) continue;
				if(i == b) {
					return true;
				}
				queue.offer(i);
				visit[i] = true;
			}
		}
		return false;
	}

}
