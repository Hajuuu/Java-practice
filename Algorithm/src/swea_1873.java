import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1873 {

	static char[][] arr;
	static int x, y;
	static int N, H, W;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			arr = new char[H][W];
			for(int j = 0; j < H; j++) {
				String str1 = br.readLine();
				for(int k = 0; k < W; k++) {
					arr[j][k] = str1.charAt(k);
					if(arr[j][k] == '<' || arr[j][k] == '^' || arr[j][k] == 'v' || arr[j][k] == '>') {
						x = j;
						y = k;
					}
				}
			}
			
			N = Integer.parseInt(br.readLine());
			
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				game(str.charAt(j));
			}
			
			sb.append("#" + i + " ");
			for(int j = 0; j < H; j++) {
				for(int k = 0; k < W; k++) {
					sb.append(arr[j][k]);
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
	public static void game(char c) {
		if(c == 'S') {
			int a = x;
			int b = y;
			if(arr[x][y] == '^') {
				while(true) {
					a--;
					if(a < 0) {
						break;
					}
					if(arr[a][b] == '*') {
						arr[a][b] = '.';
						break;
					} else if(arr[a][b] == '#') {
						break;
					}
				}
				
			} else if(arr[x][y] == 'v') {
				while(true) {
					a++;
					if(a >= H) {
						break;
					}
					if(arr[a][b] == '*') {
						arr[a][b] = '.';
						break;
					} else if(arr[a][b] == '#') {
						break;
					}
				}
				
			} else if(arr[x][y] == '<') {
				while(true) {
					b--;
					if(b < 0) {
						break;
					}
					if(arr[a][b] == '*') {
						arr[a][b] = '.';
						break;
					} else if(arr[a][b] == '#') {
						break;
					}
				}
				
			} else if(arr[x][y] == '>') {
				while(true) {
					b++;
					if(b >= W) {
						break;
					}
					if(arr[a][b] == '*') {
						arr[a][b] = '.';
						break;
					} else if(arr[a][b] == '#') {
						break;
					}
				}
			}
			
			
			
			
		} else if(c == 'U') {
			if(x > 0) {
				if(arr[x - 1][y] == '.') {
					arr[x][y] = '.';
					x = x - 1;
					arr[x][y] = '^';
				} else {
					arr[x][y] = '^';
				}
			}
			else {
				arr[x][y] = '^';
			}
		} else if(c == 'D') {
			if(x < H - 1) {
				
				if(arr[x + 1][y] == '.') {
					arr[x][y] = '.';
					x = x + 1;
					arr[x][y] = 'v';
				} else {
					arr[x][y] = 'v';
				}
			}
			else {
				arr[x][y] = 'v';
			}
			
			
		} else if(c == 'L') {
			if(y > 0) {
				
				if(arr[x][y - 1] == '.') {
					arr[x][y] = '.';
					y = y - 1;
					arr[x][y] = '<';
				} else {
					arr[x][y] = '<';
				}
			}
			else {
				arr[x][y] = '<';
			}
			
			
		} else if(c == 'R') {
			if(y < W - 1) {
				
				if(arr[x][y + 1] == '.') {
					arr[x][y] = '.';
					y = y + 1;
					arr[x][y] = '>';
				} else {
					arr[x][y] = '>';
				}
			}
			else {
				arr[x][y] = '>';
			}
		}
	}
}
