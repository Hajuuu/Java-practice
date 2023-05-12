import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class swea_16800 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < T; i++) {
			long N = Long.parseLong(br.readLine());
			long min = point(N);
			sb.append("#" + (i + 1) + " " + min + "\n");
		}
		
		System.out.println(sb);

	}
	
	public static long point(long n) {
		long min = Long.MAX_VALUE;
		for(int i = 1; i <= Math.sqrt(n); i++) {
			if(n % i == 0) {
				min = Math.min(min, (i - 1) + (n / i - 1));
			}
		}
		return min;
		
	}

}
