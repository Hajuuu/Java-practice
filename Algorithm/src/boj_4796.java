import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = 0;
		while(true) {
			n++;
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			if(L == 0) {
				break;
			}
			
			int answer = V / P * L + Math.min(L, V % P);
			sb.append("Case " + n + ": " + answer + "\n");
			
		}
		System.out.println(sb);
	}

}
