import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2468 {

	static int[][] arr;
	static boolean[][] visit;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		int max = Integer.MIN_VALUE;
		arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i][j]);
			}
		}
		
		int num = 0;
		int answer = Integer.MIN_VALUE;
		while(num <= max) {
			int count = 0;
			visit = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(arr[i][j] > num && !visit[i][j] ) {
						bfs(num, i, j);
						count++;
					}
				}
			}
			answer = Math.max(answer, count);
			num++;
		}
		System.out.println(answer);
	}
	
	public static void bfs(int num, int a, int b) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {a, b});
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll(); 
			for(int i = 0; i < 4; i++) {
				int nextX = now[0] + dx[i];
				int nextY = now[1] + dy[i];
				if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
					if(arr[nextX][nextY] > num && !visit[nextX][nextY]) {
						queue.offer(new int[] {nextX, nextY});
						visit[nextX][nextY] = true;
					}
				}
			}
			
		}
	}

}
