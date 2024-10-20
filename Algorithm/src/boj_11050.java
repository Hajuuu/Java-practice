import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11050 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int a = factorial(1, N);
		int b = factorial(1, K);
		int c = factorial(1, N - K);
		
		System.out.println(a / (b * c));
	}

	public static int factorial(int num, int start) {
		if(start < 1) {
			return num;
		}
		
		return factorial(num * start, start - 1);
	}
}

