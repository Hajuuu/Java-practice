import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = {0, 1, 0,-1};
	static int[] dy = {1, 0, -1, 0};
	static int N, M;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int year = 0;
		boolean check = true;
		while(true) {
			visit = new boolean[N][M];
			int count = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(!visit[i][j] && arr[i][j] > 0) {
						findIceberg(arr, new int[] {i, j});
						count++;
					}
				}
			}
			if(count == 0) {
				check = false;
				break;
			}
			if(count > 1) {
				break;
			}
			year++;
			arr = meltIceberg(arr);
		}
		if(!check) {
			System.out.println(0);
			return;
		}
		System.out.println(year);
	}

	public static int[][] meltIceberg(int[][] arr) {
		Queue<int[]> queue = new ArrayDeque<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] > 0) {
					queue.offer(new int[] {i, j});
				}
			}
		}
		
		int[][] nextArr = new int[N][M];
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int count = 0;
			for(int i = 0; i < 4; i++) {
				int nextX = now[0] + dx[i];
				int nextY = now[1] + dy[i];
				
				if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
					if(arr[nextX][nextY] == 0) {
						count++;
					}
				}
			}
			nextArr[now[0]][now[1]] = Math.max(0, arr[now[0]][now[1]] - count);
		}
		return nextArr;
	}
	
	public static void findIceberg(int[][] arr, int[] node) {
		for(int i = 0; i < 4; i++) {
			int nextX = node[0] + dx[i];
			int nextY = node[1] + dy[i];
			if(arr[nextX][nextY] > 0 && !visit[nextX][nextY]) {
				visit[nextX][nextY] = true;
				findIceberg(arr, new int[] {nextX, nextY});
			}
		}
		
	}
}
