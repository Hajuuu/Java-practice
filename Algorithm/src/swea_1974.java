import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1974 {

	static int[][] sdoku;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= t; tc++) {
			sdoku = new int[9][9];
			for(int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 9; j++) {
					sdoku[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			boolean check = true;
			for(int i = 0; i < 9; i++) {
				if(!check1(i) || !check2(i)) {
					sb.append("#" + tc + " " + 0 + "\n");
					check = false;
					break;
				}
			}
			
			if(!check) {
				continue;
			}
			for(int i = 0; i < 9; i += 3) {
				for(int j = 0; j < 9; j += 3) {
					if(!check3(i, j)) {
						sb.append("#" + tc + " " + 0 + "\n");
						check = false;
						break;
					}
				}
				if(!check)
					break;
			}
			
			if(check) {
				sb.append("#" + tc + " " + 1 + "\n");
			}
		}
		System.out.println(sb);
	}
	
	public static boolean check1(int num) {
		int[] check = new int[10];
		for(int i = 0; i < 9; i++) {
			check[sdoku[i][num]]++;
			if(check[sdoku[i][num]] > 1) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean check2(int num) {
		int[] check = new int[10];
		for(int i = 0; i < 9; i++) {
			check[sdoku[num][i]]++;
			if(check[sdoku[num][i]] > 1) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean check3(int x, int y) {
		int[] check = new int[10];
		for(int i = x; i < x + 3; i++) {
			for(int j = y; j < y + 3; j++) {
				check[sdoku[i][j]]++;
				if(check[sdoku[i][j]] > 1) {
					return false;
				}
			}
		}
		return true;
	}

}
