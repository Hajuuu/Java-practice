import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1003 {

	static int[] one;
	static int[] zero;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		one = new int[41];
		zero = new int[41];
		count();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < T; i++) {
	 		int N = Integer.parseInt(br.readLine());
	 		sb.append(zero[N] + " " + one[N] + "\n");
		}
		
		System.out.println(sb);
	}

	
	public static void count() {
		one[0] = 0;
		one[1] = 1;
		zero[0] = 1;
		zero[1] = 0;
		
		for(int i = 2; i < 41; i++) {
			one[i] = one[i - 2] + one[i - 1];
			zero[i] = zero[i - 2] + zero[i - 1];
		}
	}
}
