import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_4963 {

	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
	static int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};
	static int w, h;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) {
				break;
			}
			arr = new int[h][w];
			visited = new boolean[h][w];
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
				
			}
			int count = 0;
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(!visited[i][j] && arr[i][j] == 1) {
						BFS(i, j);
						count++;
					}
				}
			}
			sb.append(count + "\n");
			
			
		}
		
		System.out.println(sb);
		
		
	}
	
	public static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		visited[i][j] = true;
		queue.offer(new int[] {i, j});
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int k = 0; k < 8; k++) {
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];
				if(x >= 0 && y >= 0 && x < h  && y < w) {
					if(!visited[x][y] && arr[x][y] == 1) {
						visited[x][y] = true;
						queue.offer(new int[] {x, y});
					}
				}
			}
		}
		
	}
	
	

}
