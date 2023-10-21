import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class boj_16234 {

	static int N, L, R;
	static int[][] arr;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static boolean[][] visit;
	static Queue<int[]> point;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int day = 0;
		while(true) {
			visit = new boolean[N][N];
			if(!bfs()) {
				break;
			}
			day++;
		}
		
		System.out.println(day);
	}
	
	public static boolean bfs() {
		boolean check = false;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visit[i][j]) {
					point = new LinkedList<>();
					int answer = check(i, j);
					if(point.size() == 1) {
						continue;
					}
					while(!point.isEmpty()) {
						int[] now = point.poll();
						arr[now[0]][now[1]] = answer;
					}
					check = true;
				}
			}
		}
		if(check) {
			return true;
		}
		return false;
	} 
	
	public static int check(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		point.offer(new int[] {x, y});
		visit[x][y] = true;
		int sum = arr[x][y];
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					int nextX = now[0] + dx[i];
					int nextY = now[1] + dy[i];
					
					if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
						if(!visit[nextX][nextY] && Math.abs(arr[now[0]][now[1]] - arr[nextX][nextY]) >= L && Math.abs(arr[now[0]][now[1]] - arr[nextX][nextY]) <= R) {
							queue.offer(new int[] {nextX, nextY});
							point.offer(new int[] {nextX, nextY});
							visit[nextX][nextY] = true;
							sum += arr[nextX][nextY];
						}
					}
				}
			}
		}
		
		return sum / point.size();
		
	}
	

}

