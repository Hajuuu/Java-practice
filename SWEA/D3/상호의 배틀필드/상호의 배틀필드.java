import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static Character[][] arr;
	static int H, W;
	static int[] now;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			arr = new Character[H][W];
			now = new int[2];
			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				for (int j = 0; j < W; j++) {
					arr[i][j] = str.charAt(j);
					if (arr[i][j] == '<' || arr[i][j] == '>' || arr[i][j] == '^' || arr[i][j] == 'v') {
						now[0] = i;
						now[1] = j;
					}
				}
			}
			int N = Integer.parseInt(br.readLine());
			String move = br.readLine();
			for (int i = 0; i < N; i++) {
				if (move.charAt(i) == 'S') {
					shoot(now[0], now[1]);
				}
				if (move.charAt(i) == 'U') {
					up(now[0], now[1]);
				}
				if (move.charAt(i) == 'D') {
					down(now[0], now[1]);
				}
				if (move.charAt(i) == 'L') {
					left(now[0], now[1]);
				}
				if (move.charAt(i) == 'R') {
					right(now[0], now[1]);
				}
			}
			sb.append("#" + tc + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(arr[i][j]);
				}
				sb.append("\n");
			}

		}
		System.out.println(sb);
	}

	public static void up(int x, int y) {
		arr[x][y] = '^';
		if (x - 1 >= 0 && arr[x - 1][y] == '.') {
			arr[x][y] = '.';
			arr[x - 1][y] = '^';
			now[0] = x - 1;
		}
	}

	public static void down(int x, int y) {
		arr[x][y] = 'v';
		if (x + 1 < H && arr[x + 1][y] == '.') {
			arr[x][y] = '.';
			arr[x + 1][y] = 'v';
			now[0] = x + 1;
		}

	}

	public static void left(int x, int y) {
		arr[x][y] = '<';
		if (y - 1 >= 0 && arr[x][y - 1] == '.') {
			arr[x][y] = '.';
			arr[x][y - 1] = '<';
			now[1] = y - 1;
		}
	}

	public static void right(int x, int y) {
		arr[x][y] = '>';
		if (y + 1 < W && arr[x][y + 1] == '.') {
			arr[x][y] = '.';
			arr[x][y + 1] = '>';
			now[1] = y + 1;
		}
	}

	public static void shoot(int x, int y) {
		if (arr[x][y] == '<') {
			while (true) {
				y--;
				if (y < 0 || !shootWall(x, y)) {
					break;
				}
				
			}
		}
		else if (arr[x][y] == '>') {
			while (true) {
				y++;
				if (y >= W || !shootWall(x, y)) {
					break;
				}
				
			}
		}
		else if (arr[x][y] == '^') {
			while (true) {
				x--;
				if (x < 0 || !shootWall(x, y)) {
					break;
				}
				
			}
		}
		else if (arr[x][y] == 'v') {
			while (true) {
				x++;
				if (x >= H || !shootWall(x, y)) {
					break;
				}
				
			}
		}

	}

	public static boolean shootWall(int x, int y) {
		if (arr[x][y] == '.' || arr[x][y] == '-') {
			return true;
		}
		if (arr[x][y] == '*') {
			arr[x][y] = '.';
			return false;
		}
		return false;
	}
}
