import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_10026 {

	static char[][] arr1;
	static char[][] arr2;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static boolean[][] visit;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr1 = new char[N][N];
		arr2 = new char[N][N];
		visit = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				arr1[i][j] = str.charAt(j);
				if(str.charAt(j) == 'R') {
					arr2[i][j] = 'G';
				} else {
					arr2[i][j] = str.charAt(j);
				}
			}
		}
		
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visit[i][j]) {
					bfs(arr1, i, j);
					count++;
				}
			}
		}
		sb.append(count + " ");
		
		count = 0;
		visit = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visit[i][j]) {
					bfs(arr2, i, j);
					count++;
				}
			}
		}
		sb.append(count);
		System.out.println(sb);
	}
	
	

	public static void bfs(char[][] arr, int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		visit[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nextX = now[0] + dx[i];
				int nextY = now[1] + dy[i];
				
				if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
					if(!visit[nextX][nextY] && arr[now[0]][now[1]] == arr[nextX][nextY]) {
						queue.offer(new int[] {nextX, nextY});
						visit[nextX][nextY] = true;
					} 
				}
			}
		}
	}
}
