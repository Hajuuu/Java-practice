import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2630 {

	static int[][] paper;
	static int[] answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		paper = new int[N][N];
		answer = new int[2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dividePaper(N, 0, 0);
		for(int i : answer) {
			System.out.println(i);
		}
		
	}
	
	public static void dividePaper(int N, int x, int y) {
		if(check(N, x, y)) {
			answer[paper[x][y]]++;
			return;
		}
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				dividePaper(N / 2, x + N / 2 * i, y + N / 2 * j);
			}
		}
	}

	public static boolean check(int N, int x, int y) {
		int start = paper[x][y];
		for(int i = x; i < x + N; i++) {
			for(int j = y; j < y + N; j++) {
				if(start != paper[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}

