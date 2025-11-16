import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int[][] table;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			table = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			count = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(table[i][j] > 0) {
						check(i, j);
					}
				}
			}
			for(int i = 0; i < N; i++) {
				change(i);
			}
			
			
			sb.append("#" + tc + " " + count + "\n");
		}
		System.out.println(sb);
	}
	
	public static void check(int i, int j) {
		boolean deadlock = false;
		List<int[]> magnet = new ArrayList<>();
		if(table[i][j] == 1) {
			int next = i;
			while(next < 100) {
				if(table[next][j] == 2) {
					deadlock = true;
					break;
				}
				if(table[next][j] == 1) {
					magnet.add(new int[] {next, j});
				}
				next++;
			}
			if(deadlock) {
				for(int[] m : magnet) {
					table[m[0]][m[1]] = 0;
				}
				for(int x = next - 1; x >= next - magnet.size(); x--) {
					table[x][j] = 1;
				}
			}
			else if(!deadlock) {
				for(int[] m : magnet) {
					table[m[0]][m[1]] = 0;
				}
			}
		}
		
		
		else if(table[i][j] == 2) {
			int next = i;
			while(next >= 0) {
				if(table[next][j] == 1) {
					deadlock = true;
					break;
				}
				if(table[next][j] == 2) {
					magnet.add(new int[] {next, j});
				}
				next--;
			}
			if(deadlock) {
				for(int[] m : magnet) {
					table[m[0]][m[1]] = 0;
				}
				for(int x = next + 1; x <= next + magnet.size(); x++) {
					table[x][j] = 2;
				}
			}
			else if(!deadlock) {
				for(int[] m : magnet) {
					table[m[0]][m[1]] = 0;
				}
			}
		}
	}

	public static void change(int x) {
		for(int i = 0; i < 100; i++) {
			if(table[i][x] == 1) {
				if(i < 99 && table[i + 1][x] == 2) {
					count++;
				}
			}
			
		}
	}
}

