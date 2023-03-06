import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Algorithm {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		int star = 2 * N - 1;
		for(int i = 1; i <= N; i++) {
			for(int j = N - i; j > 0; j--) {
				sb.append(" ");
			}
			for(int p = 1; p <= star - 2 * (N - i); p++) {
				sb.append("*");
			}
			
			sb.append("\n");
		}
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < i; j++) {
				sb.append(" ");
			}
			for(int p = 1; p <= star - 2 * i; p++) {
				sb.append("*");
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
}
