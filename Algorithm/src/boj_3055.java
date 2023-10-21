import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_3055 {

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[][] water;
	static Queue<int[]> w;
	static int R, C;
	static boolean[][] visit;
	static int[][] time;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int startX = 0;
		int startY = 0;
		int endX = 0;
		int endY = 0;
		w = new LinkedList<>();
		water = new int[R][C];
		visit = new boolean[R][C];
		time = new int[R][C];
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				if(str.charAt(j) == 'D') {
					water[i][j] = -1;
					endX = i;
					endY = j;
					continue;
				}
				if(str.charAt(j) == '*') {
					water[i][j] = 1;
					w.offer(new int[] {i, j});
					continue;
				}
				if(str.charAt(j) == 'S') {
					startX = i;
					startY = j;
					continue;
				}
				if(str.charAt(j) == 'X') {
					water[i][j] = -2;
					continue;
				}
			}
		}
		
		bfs(startX, startY);
		if(time[endX][endY] == 0) {
			System.out.println("KAKTUS");
			return;
		} 
		System.out.println(time[endX][endY]);
	}
	
	public static void bfs(int startX, int startY) {
		Queue<int[]> queue = new LinkedList<>();
		
		queue.offer(new int[] {startX, startY});
		visit[startX][startY] = true;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			water();
			for(int tc = 0; tc < size; tc++) {
				int[] now = queue.poll();
				for(int i = 0; i < 4; i++) {
					int nextX = now[0] + dx[i];
					int nextY = now[1] + dy[i];
					
					if(nextX >= 0 && nextX < R && nextY >= 0 && nextY < C) {
						if(water[nextX][nextY] == -1) {
							time[nextX][nextY] = time[now[0]][now[1]] + 1;
							return;
						}
						if(!visit[nextX][nextY] && water[nextX][nextY] == 0) {
							visit[nextX][nextY] = true;
							time[nextX][nextY] = time[now[0]][now[1]] + 1;
							queue.offer(new int[] {nextX, nextY});
						}
					}
				}
				
			}
		}
			
	}
	
	public static void water() {
		int size = w.size();
		for(int tc = 0; tc < size; tc++) {
			int[] now = w.poll();
			for(int i = 0; i < 4; i++) {
				int nextX = now[0] + dx[i];
				int nextY = now[1] + dy[i];
				if(nextX >= 0 && nextX < R && nextY >= 0 && nextY < C) {
					if(water[nextX][nextY] == 0) {
						water[nextX][nextY] = 1;
						w.offer(new int[] {nextX, nextY});
					}
				}
			} 
		}
	}

}
