import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2023 {

	static int N;
	static StringBuilder sb;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		dfs(2, 1);
		dfs(3, 1);
		dfs(5, 1);
		dfs(7, 1);
		
		System.out.println(sb);
	}
	
	public static void dfs(int num, int depth) {
		if(depth == N) {
			if(isPrime(num)) {
				sb.append(num + "\n");
			}
		}
		
		for(int i = 1; i <= 9; i++) {
			if(i % 2 == 0) continue;
			if(isPrime(num * 10 + i)) {
				dfs(num * 10 + i, depth + 1);
			}
		}
		
		
	}
	
	public static boolean isPrime(int num) {
		if(num == 1) {
			return false;
		}
		
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
	

}
