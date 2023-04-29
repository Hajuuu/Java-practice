import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7576 {

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int M, N;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int max = Integer.MIN_VALUE;
		
		BFS();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				else {
					if(max < arr[i][j]) {
						max = arr[i][j];
					}
				}
			}
		}
		
		System.out.println(max - 1);
	}
	
	public static void BFS() {
		Queue<int[]> queue = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] == 1) {
					queue.offer(new int[] {i, j});
				}
			}
		}
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int k = 0; k < 4; k++) {
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];
				
				if(x >= 0 && y >= 0 && x < N && y < M) {
					if(arr[x][y] == 0) {
						arr[x][y] = arr[now[0]][now[1]] + 1;
						queue.offer(new int[] {x, y});
					}
				}
			}
			
			
		}
		
	}

}
