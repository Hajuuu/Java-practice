import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2447 {

	static String[][] star;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		star = new String[N][N];
		printStar(N, 0, 0, false);
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sb.append(star[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void printStar(int N, int x, int y, boolean check) {
		if(check) {
			for(int i = x; i < x + N; i++) {
				for(int j = y; j < y + N; j++) {
					star[i][j] = " ";
				}
			}
			return;
		}

		if(N == 1) {
			star[x][y] = "*";
			return;
		}
		
		
		int size = N / 3;
		int count = 0;
		
		for(int i = x; i < x + N; i += size) {
			for(int j = y; j < y + N; j += size) {
				count++;
				if(count == 5) {
					printStar(size, i, j, true);
					continue;
				}
				printStar(size, i, j, false);
			}
		}
	}
	

}
