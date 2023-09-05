import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1018 {

	static char[][] arr;
	static char[][] check1 = {{'W','B','W','B','W','B','W','B'}, 
						{'B','W','B','W','B','W','B','W'},
						{'W','B','W','B','W','B','W','B'},
						{'B','W','B','W','B','W','B','W'},
						{'W','B','W','B','W','B','W','B'},
						{'B','W','B','W','B','W','B','W'},
						{'W','B','W','B','W','B','W','B'},
						{'B','W','B','W','B','W','B','W'}};
	static char[][] check2 = { 
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new char[N][M];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		int answer = Integer.MAX_VALUE;
		if(N == 8 && M == 8) {
			answer = Math.min(answer, check(0, 0));
		}
		
		for(int i = 0; i <= N - 8; i++) {
			for(int j = 0; j <= M - 8; j++) {
				answer = Math.min(answer, check(i, j));
			}
		}
		System.out.println(answer);
	}
	
	public static int check(int x, int y) {
		int count1 = 0;
		int count2 = 0;
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(check1[i][j] != arr[i + x][j + y]) {
					count1++;
				}
				if(check2[i][j] != arr[i + x][j + y]) {
					count2++;
				}
			}
		}
		return Math.min(count1, count2);
	}
		
} 
