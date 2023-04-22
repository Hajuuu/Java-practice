import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = Integer.MIN_VALUE;
		int sum = 0;
		// case 1-1
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M - 3; j++) {
				sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i][j + 3];
				max = Math.max(sum, max);
			}
		}
		
		//case 1-2
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N - 3; j++) {
				sum = arr[j][i] + arr[j + 1][i] + arr[j + 2][i] + arr[j + 3][i];
				max = Math.max(sum, max);
			}
		}
		
		//case 2
		for(int i = 0; i < N - 1; i++) {
			for(int j = 0; j < M - 1; j++) {
				sum = arr[i][j] + arr[i + 1][j] + arr[i][j + 1] + arr[i + 1][j + 1];
				max = Math.max(sum, max);
			}
		}
		
		//case 3-1
		for(int i = 0; i < N - 2; i++) {
			for(int j = 0; j < M - 1; j++) {
				sum = arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 2][j + 1];
				max = Math.max(sum, max);
			}
		}
		
		//case 3 - 2
		for(int i = 0; i < N - 2; i++) {
			for(int j = 0; j < M - 1; j++) {
				sum = arr[i][j + 1] + arr[i + 1][j + 1] + arr[i + 2][j + 1] + arr[i + 2][j];
				max = Math.max(sum, max);
			}
		}
		
		// case 3 - 3
		for(int i = 0; i < N - 1; i++) {
			for(int j = 0; j < M - 2; j++) {
				sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j];
				max = Math.max(sum, max);
			}
		}
		
		// case 3 - 4
		for(int i = 0; i < N - 1; i++) {
			for(int j = 0; j < M - 2; j++) {
				sum = arr[i + 1][j] + arr[i + 1][j + 1] + arr[i + 1][j + 2] + arr[i][j + 2];
				max = Math.max(sum, max);
			}
		}
		
		
		// case 3 - 5
		for(int i = 0; i < N - 2; i++) {
			for(int j = 0; j < M - 1; j++) {
				sum = arr[i][j] + arr[i][j + 1] + arr[i + 1][j + 1] + arr[i + 2][j + 1];
				max = Math.max(sum, max);
			}
		}
		
		// case 3 - 6
		for(int i = 0; i < N - 2; i++) {
			for(int j = 0; j < M - 1; j++) {
				sum = arr[i][j] + arr[i][j + 1] + arr[i + 1][j] + arr[i + 2][j];
				max = Math.max(sum, max);
			}
		}
		
		// case 3 - 7
		for(int i = 0; i < N - 1; i++) {
			for(int j = 0; j < M - 2; j++) {
				sum = arr[i][j] + arr[i + 1][j] + arr[i + 1][j + 1] + arr[i + 1][j + 2];
				max = Math.max(sum, max);
 			}
		}
		
		// case 3 - 8
		for(int i = 0; i < N - 1; i++) {
			for(int j = 0; j < M - 2; j++) {
				sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 2];
				max = Math.max(sum, max);
			}
		}
		// case 4 - 1
		for(int i = 0; i < N - 2; i++) {
			for(int j = 0; j < M - 1; j++) {
				sum = arr[i][j + 1] + arr[i + 1][j] + arr[i + 1][j + 1] + arr[i + 2][j];
				max = Math.max(sum, max);
			}
		}
		
		
		// case 4 - 2
		for(int i = 0; i < N - 2; i++) {
			for(int j = 0; j < M - 1; j++) {
				sum = arr[i][j] + arr[i + 1][j] + arr[i + 1][j + 1] + arr[i + 2][j + 1];
				max = Math.max(sum, max);
			}
		}
		
		// case 4 - 3
		for(int i = 0; i < N - 1; i++) {
			for(int j = 0; j < M - 2; j++) {
				sum = arr[i][j] + arr[i][j + 1] + arr[i + 1][j + 1] + arr[i + 1][j + 2];
				max = Math.max(sum, max);
			}
		}
		
		// case 4 - 4
		for(int i = 0; i < N - 1; i++) {
			for(int j = 0; j < M - 2; j++) {
				sum = arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j] + arr[i + 1][j + 1];
				max = Math.max(sum, max);
			}
		}
		
		
		// case 5 - 1
		for(int i = 0; i < N - 1; i++) {
			for(int j = 0; j < M - 2; j++) {
				sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1];
				max = Math.max(sum, max);
			}
		}
		
		// case 5 - 2
		for(int i = 0; i < N - 1; i++) {
			for(int j = 0; j < M - 2; j++) {
				sum = arr[i + 1][j] + arr[i + 1][j + 1] + arr[i + 1][j + 2] + arr[i][j + 1];
				max = Math.max(sum, max);
			}
		}
		
		// case 5 - 3
		for(int i = 0; i < N - 2; i++) {
			for(int j = 0; j < M - 1; j++) {
				sum = arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 1][j + 1];
				max = Math.max(sum, max);
			}
		}
		
		// case 5 - 4
		for(int i = 0; i < N - 2; i++) {
			for(int j = 0; j < M - 1; j++) {
				sum = arr[i][j + 1] + arr[i + 1][j + 1] + arr[i + 2][j + 1] + arr[i + 1][j];
				max = Math.max(sum, max);
			}
		}
		
		
		System.out.println(max);
	}
} 
