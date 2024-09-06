import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_16236 {

	static int[][] map;
	static int N;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		map = new int[N][N];
		int[] now = new int[2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					now[0] = i;
					now[1] = j;
					map[i][j] = 0;
				}
			}
		}
		
		int eat = 0;
		int size = 2;
		int time = 0;
		while(true) {
			PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) ->
			o1[2] != o2[2] ? Integer.compare(o1[2], o2[2]) : (o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1])));

			boolean[][] visit = new boolean[N][N];
			
			queue.offer(new int[] {now[0], now[1], 0});
			visit[now[0]][now[1]] = true;
			
			boolean check = false;
			
			while(!queue.isEmpty()) {
				now = queue.poll();
				if(map[now[0]][now[1]] != 0 && map[now[0]][now[1]] < size) {
					map[now[0]][now[1]] = 0;
					eat++;
					time += now[2];
					check = true;
					break;
				}
				
				for(int i = 0; i < 4; i++) {
					int nextX = now[0] + dx[i];
					int nextY = now[1] + dy[i];
					
					if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || visit[nextX][nextY] || map[nextX][nextY] > size) {
						continue;
					}
					queue.offer(new int[] {nextX, nextY, now[2] + 1});
					visit[nextX][nextY] = true;
				}
			}
			if(!check) {
				break;
			}
			if(size == eat) {
				size++;
				eat = 0;
			}
		}
		System.out.println(time);
		
		
		
	}
	
	

	
	
	
	

}
