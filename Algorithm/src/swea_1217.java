import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1217 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= 10; tc++) {
			int t = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int answer = square(N, M, N);
			sb.append("#" + tc + "  " + answer + "\n");
		}
		System.out.println(sb);
	
	}

	public static int square(int n, int m, int answer) {
		if(m < 2) {
			return answer;
		}
		return square(n, m - 1, answer * n);
	}
}
