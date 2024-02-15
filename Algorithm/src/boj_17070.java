import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17070 {

	static int N;
	static int answer = 0;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		arr = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		movePipe(0, 0, 0, 1);
		System.out.println(answer);
		
	}
	
	public static void movePipe(int x1, int y1, int x2, int y2) {
		if(x2 == N - 1 && y2 == N - 1) {
			answer++;
			return;
		}
		
		if(x2 - x1 == 0 && y2 - y1 != 0) {
			if(y2 + 1 < N && arr[x2][y2 + 1] == 0) {
				movePipe(x1, y1 + 1, x2, y2 + 1);
			}
			if(x2 + 1 < N && y2 + 1 < N && arr[x2 + 1][y2 + 1] == 0 && arr[x2][y2 + 1] == 0 && arr[x2 + 1][y2] == 0) {
				movePipe(x1, y1 + 1, x2 + 1, y2 + 1);
			}
		}
		
		
		if(y2 - y1 == 0 && x2 - x1 != 0) {
			if(x2 + 1 < N && arr[x2 + 1][y2] == 0) {
				movePipe(x1 + 1, y1, x2 + 1, y2);
			}
			if(x2 + 1 < N && y2 + 1 < N && arr[x2 + 1][y2 + 1] == 0 && arr[x2][y2 + 1] == 0 && arr[x2 + 1][y2] == 0) {
				movePipe(x1 + 1, y1, x2 + 1, y2 + 1);
			}
		}
		
		if(x2 - x1 == y2 - y1) {
			if(y2 + 1 < N && arr[x2][y2 + 1] == 0) {
				movePipe(x1 + 1, y1 + 1, x2, y2 + 1);
			}
			if(x2 + 1 < N && arr[x2 + 1][y2] == 0) {
				movePipe(x1 + 1, y1 + 1, x2 + 1, y2);
			}
			if(x2 + 1 < N && y2 + 1 < N && arr[x2 + 1][y2 + 1] == 0 && arr[x2][y2 + 1] == 0 && arr[x2 + 1][y2] == 0) {
				movePipe(x1 + 1, y1 + 1, x2 + 1, y2 + 1);
			}
		}
	}

}
