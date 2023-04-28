import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2178 {

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[][] arr;
	static int N, M;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N][M];
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		BFS(0, 0);
		System.out.println(arr[N - 1][M - 1]);
	} 
	
	public static void BFS(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int i = 0; i < 4; i++) {
				int a = now[0] + dx[i];
				int b = now[1] + dy[i];
				if(a >= 0 && b >= 0 && a < N && b < M) {
					if(arr[a][b] != 0 && !visited[a][b]) {
						visited[a][b] = true;
						arr[a][b] = arr[now[0]][now[1]] + 1;
						queue.offer(new int[] {a, b});
					}
				}
			}
		}
		
		
	}

}
