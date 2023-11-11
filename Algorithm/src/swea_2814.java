import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swea_2814 {

	static ArrayList<Integer>[] nodeList;
	static boolean[] visit;
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; tc++) {
            max = 0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			nodeList = new ArrayList[N + 1];
			visit = new boolean[N + 1];
			for(int i = 1; i <= N; i++) {
				nodeList[i] = new ArrayList<>();
			}
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				nodeList[x].add(y);
				nodeList[y].add(x);
			}
			for(int i = 1; i <= N; i++) {
				visit = new boolean[N + 1];
				dfs(i, 1);
			}
			sb.append("#" + tc + " "+ max + "\n");
		}
		System.out.println(sb);
	}
	
	public static void dfs(int start, int depth) {
        visit[start] = true;
		for(int i : nodeList[start]) {
			if(!visit[i]) {
				dfs(i, depth + 1);
				visit[i] = false;
			}
		}
        max = Math.max(max, depth);
		
	}

}
