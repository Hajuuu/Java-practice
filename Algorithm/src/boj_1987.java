import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1987 {

	static int[][] arr;
	static boolean[] visit;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int R, C;
	static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new int[R][C];
		visit = new boolean[26];
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				int num = str.charAt(j) - 65;
				arr[i][j] = num;
			}
		}
		
		visit[arr[0][0]] = true;
		dfs(0, 0, 1);
		System.out.println(answer);
	}

	public static void dfs(int x, int y, int count) {
		for(int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if(nextX >= 0 && nextX < R && nextY >= 0 && nextY < C)
			if(!visit[arr[nextX][nextY]]) {
				visit[arr[nextX][nextY]] = true;
				dfs(nextX, nextY, count + 1);
				visit[arr[nextX][nextY]] = false;
				
			} else {
				answer = Math.max(answer, count);
			}
		}
	}
}
