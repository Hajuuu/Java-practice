import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_14413 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		
		for(int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int a = 0;
			int b = 0;
			for(int p = 1; p <= N; p++) {
				
				String str = br.readLine();
				for(int q = 1; q <= M; q++) {
					if(match1(p, q, str.charAt(q - 1))) {
						a++;
					}
					if(match2(p, q, str.charAt(q - 1))) {
						b++;
					}
				}
			}
			int num = N * M;
			if(a == num || b == num) {
				sb.append("#" + i + " possible\n");
			} else {
				sb.append("#" + i + " impossible\n");
			}
		}
		
		
		
		System.out.println(sb);
	}
	
	public static boolean match1(int a, int b, char c) {
		boolean check = false;
		if(c == '?') {
			return true;
		}
		if((a + b) % 2 == 0) {
			if(c == '#') {
				check = true;
			}
		} else {
			if(c == '.') {
				check = true;
			}
		}
		
		return check;
	}
	
	public static boolean match2(int a, int b, char c) {
		boolean check = false;
		if(c == '?') {
			return true;
		}
		if((a + b) % 2 == 0) {
			if(c == '.') {
				check = true;
			}
		} else {
			if(c == '#') {
				check = true;
			}
		}
		
		return check;
	}

}
