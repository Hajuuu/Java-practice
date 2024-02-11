import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1780 {

	static int[][] arr;
	static int count[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		count = new int[3];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()) + 1;
			}
		}
	
		dividePaper(0, 0, N);
		
		for(int i : count) {
			System.out.println(i);
		}
		
	}
	
	public static void dividePaper(int x, int y, int N) {
		if(check(x, y, N)) {
			count[arr[x][y]]++;
		} else {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					dividePaper(x + N / 3 * i, y + N / 3 * j, N / 3);
				}
			}
		}
			
	}
	
	public static boolean check(int x, int y, int N) {
		int start = arr[x][y];
		for(int i = x; i < x + N; i++) {
			for(int j = y; j < y + N; j++) {
				if(arr[i][j] != start) {
					return false;
				}
			}
		}
		return true;
	}

}
