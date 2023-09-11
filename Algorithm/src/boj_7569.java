import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7569 {

	static int[][][] tomato;
	static int[] dx = {0, 0, 0, 1, 0, -1};
	static int[] dy = {0, 0, 1, 0, -1, 0};
	static int[] dz = {1, -1, 0, 0, 0, 0};
	static int M, N, H;
	static int[][][] count;
 	public static void main(String[] args) throws IOException {
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		StringTokenizer st = new StringTokenizer(br.readLine());
 		
 		M = Integer.parseInt(st.nextToken());
 		N = Integer.parseInt(st.nextToken());
 		H = Integer.parseInt(st.nextToken());
 		
 		tomato = new int[H][N][M];
 		count = new int[H][N][M];
 		Queue<int[]> queue = new LinkedList<>();
 		for(int i = 0; i < H; i++) {
 			for(int j = 0; j < N; j++) {
 				st = new StringTokenizer(br.readLine());
 				for(int k = 0; k < M; k++) {
 					tomato[i][j][k] = Integer.parseInt(st.nextToken());
 					if(tomato[i][j][k] == 1) {
 						queue.offer(new int[] {i, j, k});
 					}
 				}
 			}
 		}
 		bfs(queue);
 		int answer = 0;
 		for(int i = 0; i < H; i++) {
 			for(int j = 0; j < N; j++) {
 				for(int k = 0; k < M; k++) {
 					if(tomato[i][j][k] == 0) {
 						System.out.println(-1);
 						return;
 					}
 					answer = Math.max(answer, count[i][j][k]);
 				}
 			}
 		}
 		
 		System.out.println(answer);
 		
 		
 		
		
	}
 	
 	public static void bfs(Queue<int[]> queue) {
 		while(!queue.isEmpty()) {
 			int[] now = queue.poll();
 			for(int i = 0; i < 6; i++) {
 				int nextZ = now[0] + dz[i];
 				int nextX = now[1] + dx[i];
 				int nextY = now[2] + dy[i];
 				if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && nextZ >= 0 && nextZ < H) {
 					if(tomato[nextZ][nextX][nextY] == 0) {
 						tomato[nextZ][nextX][nextY] = 1;
 						queue.offer(new int[] {nextZ, nextX, nextY});
 						count[nextZ][nextX][nextY] = count[now[0]][now[1]][now[2]] + 1;
 					}
 				}
 			}
 		}
 	}

}
