import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static ArrayList<Integer>[] nodeList;
	static boolean[] visited;
	static int[] answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		nodeList = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		answer = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			nodeList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			nodeList[a].add(b);
			nodeList[b].add(a);
		}
		
		DFS(1);
		for(int i = 2; i <= N; i++) {
			sb.append(answer[i] + "\n");
		}
		System.out.println(sb);
	}
	
	public static void DFS(int start) {
		visited[start] = true;
		
		for(int i : nodeList[start]) {
			if(!visited[i]) {
				answer[i] = start;
				visited[i] = true;
				DFS(i);
			}
		}
	}

}
