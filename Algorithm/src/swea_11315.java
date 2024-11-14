import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_11315 {

	static char[][] board;
	static boolean[][] visit;
	static int[] dx = {0, 1, 0, -1, 1, -1};
	static int[] dy = {1, 0, -1, 0, 1, 1};
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			board = new char[N][N];
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				for(int j = 0; j < N; j++) {
					board[i][j] = str.charAt(j);
				}
			}
			boolean check = false;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(board[i][j] == 'o') {
						check = checkBoard(i, j);
						if(check) {
							break;
						}
					}	
				}
				if(check) {
					break;
				}
			}
			if(check) {
				sb.append("#" + tc + " YES\n");
			} else {
				sb.append("#" + tc + " NO\n");
			}
 		}
		System.out.println(sb);
	}

	public static boolean checkBoard(int x, int y) {
		for(int i = 0; i < 6; i++) {
			for(int j = 1; j <= 4; j++) {
				int nextX = x + dx[i] * j;
				int nextY = y + dy[i] * j;
				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
					break;
				}
				if(board[nextX][nextY] != 'o') {
					break;
				}
				if(j == 4) {
					return true;
				}
			}
		}
		return false;
	}
}
