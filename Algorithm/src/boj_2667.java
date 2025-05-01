import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static boolean[][] visited;
	static int[][] arr;
	static int N;
	static int block;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> array = new ArrayList<>();
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		block = 0;
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		for(int p = 0; p < N; p++) {
			for(int q = 0; q < N; q++) {
				if(arr[p][q] == 1 && !visited[p][q]) {
					array.add(BFS(p, q));
					block++;
				}
			}
		}
		Collections.sort(array);
		System.out.println(block);
		for(int i : array) {
			sb.append(i + "\n");
		}
		
		
		System.out.println(sb);
		

	}
	
	public static int BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i, j});
		visited[i][j] = true;
		int count = 1;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int k = 0; k < 4; k++) {
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];
				
				if(x >= 0 && y >= 0 && x < N && y < N) {
					if(arr[x][y] == 1 && !visited[x][y]) {
						visited[x][y] = true;
						queue.offer(new int[] {x, y});
						count++;
					}
					
				}
			}
		
		}
		return count;
		
	}

}
