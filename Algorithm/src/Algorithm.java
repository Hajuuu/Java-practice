import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			
			int year = x;
			int last = M * N / gcd(M, N);
			
			while(year <= last) {
				if((year % N == y)) {
					sb.append(year + 1 + "\n");
					break;
				}
				year += M;
			}
			
			if(year > last) {
				sb.append(-1 + "\n");
				continue;
			}
		}
		
		System.out.println(sb);
	}
	
	public static int gcd(int M, int N) {
		if(N == 0)
			return M;
		return gcd(N, M % N);
	}
} 
