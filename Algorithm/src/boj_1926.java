import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1926 {

	static int[][] arr;
	static boolean[][] visit;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visit = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count = 0;
		int size = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!visit[i][j] && arr[i][j] == 1) {
					size = Math.max(size, bfs(i, j));
					count++;
				}
			}
		}
		
		System.out.println(count);
		System.out.println(size);
	}
	
	
	public static int bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		visit[x][y] = true;	
		int size = 0;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			size++;
			for(int i = 0; i < 4; i++) {
				int nextX = now[0] + dx[i];
				int nextY = now[1] + dy[i];
				
				if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
					if(!visit[nextX][nextY] && arr[nextX][nextY] == 1) {
						visit[nextX][nextY] = true;
						queue.offer(new int[] {nextX, nextY});
						
					}
				}
			}
		}
		return size;
	}

}
