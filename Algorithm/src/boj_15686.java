import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_15686 {

	static ArrayList<int[]> house;
	static ArrayList<int[]> chicken;
	static ArrayList<int[]> choice;
	static int N;
	static int M;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = Integer.MAX_VALUE;
		int[][] map = new int[N][N];
		
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		choice = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					house.add(new int[] {i, j});
				}
				else if(map[i][j] == 2) {
					chicken.add(new int[] {i, j});
				}
			}
		}
		
		
		backtracking(0, 0);
		System.out.println(answer);
	}
	
	static void backtracking(int num, int depth) {
		if(depth == M) {
			int sum = 0;
			for(int[] h : house) {
				int min = Integer.MAX_VALUE;
				for(int[] c : choice) {
					int d = Math.abs(c[0] - h[0]) + Math.abs(c[1] - h[1]);
					min = Math.min(d, min);
				}
				sum += min;
			}
			answer = Math.min(answer, sum);
			return;
		}
		
		for(int i = num; i < chicken.size(); i++) {
			choice.add(chicken.get(i));
			backtracking(i + 1, depth + 1);
			choice.remove(chicken.get(i));
		}
	}
	

}
