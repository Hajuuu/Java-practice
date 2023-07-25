import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_13023 {

	static ArrayList<Integer>[] nodeList;
	static boolean[] visit;
	static boolean answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		nodeList = new ArrayList[N];
		visit = new boolean[N];
		answer = false;
		
		for(int i = 0; i < N; i++) {
			nodeList[i] = new ArrayList<>();
		}

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nodeList[a].add(b);
			nodeList[b].add(a);
		}
		
		for(int i = 0; i < N; i++) {
			dfs(1, i);
			if(answer) {
				break;
			}
			
		}
		if(answer) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
	
	public static void dfs(int depth, int start) {
		if(depth == 5) {
			answer = true;
			return;
		}
		
		visit[start] = true;
		for(int i : nodeList[start]) {
			if(!visit[i]) {
				dfs(depth + 1, i);
			}
		}
		visit[start] = false;
	}
	

}
