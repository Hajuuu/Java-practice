import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1934 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int num = gcd(A, B);
			sb.append((A * B / num) + "\n");
			
		}
		
		System.out.println(sb);
	}
	
	public static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		
		return gcd(b, a % b);
	}

}
