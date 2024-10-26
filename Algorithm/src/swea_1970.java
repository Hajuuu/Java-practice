import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1970 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int answer = 0;
			if(N % 2 == 0) {
				answer = N / 2 * -1;
			} else {
				answer = N / 2 + 1;
			}
			sb.append("#" + tc + " " + answer + "\n");
		}
		System.out.println(sb);
	}

}
