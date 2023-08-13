import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_24480 {

	static ArrayList<Integer>[] nodeList;
	static boolean[] visit;
	static int num;
	static int[] count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		nodeList = new ArrayList[N + 1];
		visit = new boolean[N + 1];
		count = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			nodeList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			nodeList[u].add(v);
			nodeList[v].add(u);
		}
		
		for(int i = 1; i <= N; i++) {
			nodeList[i].sort(Comparator.reverseOrder());
		}
		num = 0;
		DFS(R);

		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			sb.append(count[i] + "\n");
		}
		System.out.println(sb);
	}
	
	public static void DFS(int start) {
		num++;
		count[start] = num;
		visit[start] = true;
		for(int i : nodeList[start]) {
			if(!visit[i]) {
				DFS(i);
			}
		}
	}

}
