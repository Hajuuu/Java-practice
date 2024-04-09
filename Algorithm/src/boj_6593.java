import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_6593 {

	static char[][][] building;
	static int[] dx = {0, 0, 0, -1, 0, 1};
	static int[] dy = {0, 0, 1, 0, -1, 0};
	static int[] dz = {1, -1, 0, 0, 0, 0};
	static int L, R, C;
	static int[][][] count;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			int startX = 0;
			int startY = 0;
			int startZ = 0;
			int endX = 0;
			int endY = 0;
			int endZ = 0;
			if(L == 0 && R == 0 && C == 0) {
				break;
			}
			building = new char[L][R][C];
			String str;
			for(int i = 0; i < L; i++) {
				for(int j = 0; j < R; j++) {
					str = br.readLine();
					for(int q = 0; q < C; q++) {
						building[i][j][q] = str.charAt(q);
						if(building[i][j][q] == 'S') {
							startX = j;
							startY = q;
							startZ = i;
						}
						if(building[i][j][q] == 'E') {
							endX = j;
							endY = q;
							endZ = i;
						}
					}
				}
				str = br.readLine();
			}

			findExit(startX, startY, startZ);
			if(count[endZ][endX][endY] > 0) {
				sb.append("Escaped in ").append(count[endZ][endX][endY]).append(" minute(s).\n");
			} else {
				sb.append("Trapped!\n");
			}
			
		}
		System.out.println(sb);
		
		
	}
	
	
	public static void findExit(int x, int y, int z) {
		
		Queue<Point6593> queue = new ArrayDeque<>();
		queue.offer(new Point6593(x, y, z));
		count = new int[L][R][C];
		boolean[][][] visit = new boolean[L][R][C];
		
		while(!queue.isEmpty()) {
			Point6593 now = queue.poll();
			for(int i = 0; i < 6; i++) {
				
				int nextX = now.x + dx[i];
				int nextY = now.y + dy[i];
				int nextZ = now.z + dz[i];
				if(nextX >= 0 && nextX < R && nextY >= 0 && nextY < C && nextZ >= 0 && nextZ < L) {
					if(visit[nextZ][nextX][nextY]) {
						continue;
					}
					if(building[nextZ][nextX][nextY] == '.' || building[nextZ][nextX][nextY] == 'E') {
						count[nextZ][nextX][nextY] = count[now.z][now.x][now.y] + 1;
						visit[nextZ][nextX][nextY] = true;
						queue.offer(new Point6593(nextX, nextY, nextZ));
					}
					
				}
			}
		}
		
	}

}


class Point6593 {
	int x;
	int y;
	int z;
	
	Point6593(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
