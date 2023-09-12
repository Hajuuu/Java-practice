import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2583 {

	static int[][] arr;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken()); 
		int K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for(int tc = 0; tc < K; tc++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int i = x1; i < x2; i++) {
				for(int j = y1; j < y2; j++) {
					arr[i][j] = 1;
				}
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] == 0) {
					list.add(BFS(i, j));
					count++;
				}
			}
		}
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		sb.append(count + "\n");
		for(int i : list) {
			sb.append(i + " ");
		}
		
		System.out.println(sb);
	}
	
	public static int BFS(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		int count = 1;
		arr[x][y] = 1;
		queue.offer(new int[] {x, y});
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nextX = now[0] + dx[i];
				int nextY = now[1] + dy[i];
				if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
					if(arr[nextX][nextY] == 0) {
						count += 1;
						arr[nextX][nextY] = 1;
						queue.offer(new int[] {nextX, nextY});
						
					}
				}
			}
		}
		return count;
	}
}
