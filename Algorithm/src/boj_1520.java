import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1520 {

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[][] map;
	static int[][] count;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		count = new int[M][N];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				count[i][j] = -1;
			}
		}
		
		System.out.println(dfs(0,0));
	}
	
	public static int dfs(int x, int y) {
		if(x == M - 1 && y == N - 1) {
			return 1;
		}
		
		if(count[x][y] == -1) {
			count[x][y] = 0;
			for(int i = 0; i < 4; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				if(nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
					if(map[x][y] > map[nextX][nextY]) {
						count[x][y] += dfs(nextX, nextY);
					}
				}
			}
		}
		return count[x][y];
	}

}
