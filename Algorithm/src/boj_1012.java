import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1012 {

	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {1, 0, -1, 0};
	static boolean[][] visit;
	static int M;
	static int N;
	static int[][] field;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			field = new int[M][N];
			visit = new boolean[M][N];
			
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				field[x][y] = 1;
			}
			
			int count = 0;
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < N; j++) {
					if(field[i][j] == 1 && !visit[i][j]) {
						BFS(i, j);
						count++;
					}
				}
			}
			sb.append(count + "\n");
		}
		
		System.out.println(sb);
	}
	
	public static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i, j});
		visit[i][j] = true;
		while(!queue.isEmpty()) {
			int[] next = queue.poll();
			for(int q = 0; q < 4; q++) {
				if(next[0] + dx[q] >= 0 && next[1] + dy[q] >= 0 && next[0] + dx[q] < M && next[1] + dy[q] < N) {
					if(field[next[0] + dx[q]][next[1] + dy[q]] == 1 && !visit[next[0] + dx[q]][next[1] + dy[q]]) {
						visit[next[0] + dx[q]][next[1] + dy[q]] = true;
						queue.offer(new int[] {next[0] + dx[q], next[1] + dy[q]});
					}
				}
			}
		}
	}

}
