import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7562 {
	static boolean[][] visited;
	static int[] dx = {1, 1, 2, 2, -1, -1, -2, -2};
	static int[] dy = {2, -2, 1, -1, 2, -2, 1, -1};
	static int l;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < T; i++) {
			l = Integer.parseInt(br.readLine());
			visited = new boolean[l][l];
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			BFS(a, b, c, d);
			sb.append(count + "\n");
		}

		System.out.println(sb);
	}
	
	public static void BFS(int a, int b, int c, int d) {
		Queue<int[]> queue = new LinkedList<>();
		int[][] arr = new int[l][l];
		arr[a][b] = 0;
		visited[a][b] = true;
		queue.offer(new int[] {a, b});
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int i = 0; i < 8; i++) {
				int x = now[0] + dx[i];
				int y = now[1] + dy[i];
				if(x >= 0 && y >= 0 && x < l && y < l) {
					if(!visited[x][y]) {
						visited[x][y] = true;
						arr[x][y] = arr[now[0]][now[1]] + 1;
						queue.offer(new int[] {x, y});
					}
					if(x == c && y == d) {
						count = arr[x][y];
						return;
					}
				}
			}
		}
		
	}

}
