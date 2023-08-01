import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1850 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		long num = gcd(A, B);
		for(int i = 0; i < num; i++) {
			sb.append(1);
		}
		System.out.println(sb);
	}
	
	public static long gcd(long A, long B) {
		if(B == 0) {
			return A;
		}
		return gcd(B, A % B);
	}

}
