import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Algorithm {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int R = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			int len = str.length();
			for(int j = 0; j < len; j++) {
				for(int q = 0; q < R; q++) {
					sb.append(str.charAt(j));
				}
			}
			sb.append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	
}
