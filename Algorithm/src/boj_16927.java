import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16927 {

	static int[][] arr;
	static int N, M;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
	
		int min = Math.min(N, M) / 2;
		
		
		for(int i = 0; i < min; i++) {
			int count = R % (((N - 2 * i) + (M - 2 * i)) * 2 - 4);
			rotation(i, count);
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
	
	
	public static void rotation(int index, int count) {
		for(int i = 0; i < count; i++) {
			int x = index;
			int y = index;
			int tmp = arr[x][y];
			
			int d = 0;
			while(d < 4) {
				int nextX = x + dx[d];
				int nextY = y + dy[d];
				
				if(nextX < index || nextY < index || nextX >= N - index || nextY >= M - index) {
					d++;
					continue;
				}
				
				arr[x][y] = arr[nextX][nextY];
				y = nextY;
				x = nextX;
				
			}
			arr[index + 1][index] = tmp;
		}
	}

}
