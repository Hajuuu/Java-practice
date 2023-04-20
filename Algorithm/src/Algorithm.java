import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algorithm {
	
	static char[][] arr;
	static int max = 1, N = 0;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];

		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		//인접 가로 변경 비교
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N - 1; j++) {
				if(arr[i][j] != arr[i][j + 1]) {
					change(i, j, i, j + 1);
					candyCheck();
					change(i, j + 1, i, j);
				}
			}
		}
		
		//인접 세로  변경 비교
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N - 1; j++) {
				if(arr[j][i] != arr[j + 1][i]) {
					change(j, i, j + 1, i);
					candyCheck();
					change(j + 1, i, j, i);
				}
			}
		}
		System.out.println(max);
		
	}
	
	public static void change(int x1, int y1, int x2, int y2) {
		char ch = ' ';
		ch = arr[x1][y1];
		arr[x1][y1] = arr[x2][y2];
		arr[x2][y2] = ch;
	}
	
	public static void candyCheck() {
		
		for(int i = 0; i < N; i++) {
			int numX = 1;
			for(int j = 0; j < N - 1; j++) {
				if(arr[i][j] == arr[i][j + 1]) {
					numX++;
				} else {
					numX = 1;
				}
				max = Math.max(max, numX);
			}
			
		}
		
		for(int i = 0; i < N; i++) {
			int numY = 1;
			for(int j = 0; j < N - 1; j++) {
				if(arr[j][i] == arr[j + 1][i]) {
					numY++;
				} else {
					numY = 1;
				}

				max = Math.max(max, numY);
			}
		}
	}
} 
