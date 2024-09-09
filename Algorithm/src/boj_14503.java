import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14503 {

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int[][] map;
	static int N;
	static int M;
	static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cleaning(r, c, d);
		
		System.out.println(answer);
		
	}
	
	static void cleaning(int r, int c, int d) {
		if(map[r][c] == 0) {
			map[r][c] = 2;
			answer++;
		}
		
		boolean check = false;
		for(int i = 0; i < 4; i++) {
			int next_d = (d + 3) % 4;
			int next_r = r + dy[next_d];
			int next_c = c + dx[next_d];
			
			
			if(next_r > 0 && next_r < N && next_c > 0 && next_c < M) {
				if(map[next_r][next_c] == 0) {
					check = true;
					cleaning(next_r, next_c, next_d);
					break;
				}
			}
			d = (d + 3) % 4;
		}
		
		if(!check) {
			int next_d = (d + 2) % 4;
			int next_r = r + dy[next_d];
			int next_c = c + dx[next_d];
			
			if(next_r > 0 && next_r < N && next_c > 0 && next_c < M) {
				if(map[next_r][next_c] != 1) {
					cleaning(next_r, next_c, d);
				}
			}
		}
	
	}
		
	

}

