import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1992 {

	static int[][] quad;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String str = "";
		quad = new int[N][N];
		for(int i = 0; i < N; i++) {
			str = br.readLine();
			for(int j = 0; j < N; j++) {
				quad[i][j] = str.charAt(j) -'0';
			}
		}
		quadTree(0, 0, N);
		System.out.println(sb);
		
		
	}
	
	public static void quadTree(int x, int y, int N) {
		if(check(x, y, N)) {
			sb.append(quad[x][y]);
			return;
		}
		sb.append("(");
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				quadTree(x + N / 2 * i, y + N / 2 * j, N / 2);
			}
		}
		sb.append(")");
	}
	
	public static boolean check(int x, int y, int N) {
		int start = quad[x][y];
		for(int i = x; i < x + N; i++) {
			for(int j = y; j < y + N; j++) {
				if(start != quad[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
