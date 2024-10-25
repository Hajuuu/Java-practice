import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1284 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int[] num = new int[5];
			for(int i = 0; i < 5; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			int a = num[4] * num[0];
			int b = 0;
			if(num[4] < num[2]) {
				b = num[1];
			} else {
				b = (num[4] - num[2]) * num[3] + num[1]; 
			}
			sb.append("#" + tc + " " + Math.min(a, b) + "\n");
		}
		System.out.println(sb);
	}

}
