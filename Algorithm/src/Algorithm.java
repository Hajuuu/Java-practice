import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Algorithm {
		
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == -1) break;
			
			int sum = 0;
			String str = "";
			
			for(int i = 1; i < n; i++) {
				if(n % i == 0) {
					sum += i;
					str += i + " ";
				}
				
			}
			
			if(sum == n) {
				st = new StringTokenizer(str, " ");
				sb.append(n + " = ");
				sb.append(st.nextToken());
				while(st.hasMoreTokens()) {
					sb.append(" + ");
					sb.append(st.nextToken());
				}
				sb.append("\n");
			} else {
				sb.append(n + " is NOT perfect.\n");
			}
		}
		
		System.out.println(sb);
		

	}
}
