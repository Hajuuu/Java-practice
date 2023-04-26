import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2023 {

	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		DFS(2, 1);
		DFS(3, 1);
		DFS(5, 1);
		DFS(7, 1);
		
		System.out.println(sb);
	}
	
	public static void DFS(int num, int digit) {
		if(digit == N) {
			if(isPrime(num)) {
				sb.append(num + "\n");
			}
			return;
		}
		
		for(int i = 1; i <= 9; i++) {
			if(i % 2 == 0) continue;
			if(isPrime(num * 10 + i)) {
				DFS(num * 10 + i, digit + 1);
			}
		}
	}
	
	public static boolean isPrime(int num) {
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0)
				return false;
		}
		return true;
	}

}
