import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swea_4615 {
	
	static int[][] go;
	static int N;
	static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
	static ArrayList<int[]> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			go = new int[N + 1][N + 1];
			go[N / 2][N / 2] = 2;
			go[N / 2][N / 2 + 1] = 1;
			go[N / 2 + 1][N / 2] = 1;
			go[N / 2 + 1][N / 2 + 1] = 2;
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int color = Integer.parseInt(st.nextToken());
				go[x][y] = color;
				check(x, y, color);
			}
			int black = 0;
			int white = 0;
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(go[i][j] == 1) {
						black++;
					}
					else if(go[i][j] == 2) {
						white++;
					}
				}
			}
			sb.append("#" + tc + " " + black + " " + white + "\n");
		}
		System.out.println(sb);
	}

	public static void check(int x, int y, int color) {
		for(int i = 0; i < 8; i++) {
			list = new ArrayList<>();
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			while(nextX > 0 && nextX <= N && nextY > 0 && nextY <= N) {
				if(go[nextX][nextY] == 0) {
					break;
				}
				if(go[nextX][nextY] == color) {
					if(list.size() > 0) {
						change(color);
					}
					break;
				}
				list.add(new int[] {nextX, nextY});
				nextX += dx[i];
				nextY += dy[i];
			}
		}
 	}
	
	public static void change(int color) {
		for(int[] i : list) {
			go[i[0]][i[1]] = color;
		}
	}

}
