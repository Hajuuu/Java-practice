import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2178 {

	static int[][] maze;
	static int[][] arr;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		maze = new int[N][M];
		String str;
		for(int i = 0; i < N; i++) {
			str = br.readLine();
			for(int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		BFS(0, 0);
		
		System.out.println(maze[N - 1][M - 1]);
		
	} 
	
	public static void BFS(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		maze[x][y] = 1;
		boolean[][] visit = new boolean[N][M];
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int i = 0; i < 4; i++) {
				if(now[0] + dx[i] >= 0 && now[0] + dx[i] < N && now[1] + dy[i] >= 0 && now[1] + dy[i] < M) {
					if(!visit[now[0] + dx[i]][now[1] + dy[i]] && arr[now[0] + dx[i]][now[1] + dy[i]] == 1) {
						maze[now[0] + dx[i]][now[1] + dy[i]] = maze[now[0]][now[1]] + 1;
						queue.offer(new int[] {now[0] + dx[i], now[1] + dy[i]});
						visit[now[0] + dx[i]][now[1] + dy[i]] = true;
					}
				}
			}
			
		}
		
	}
	

}
