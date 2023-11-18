import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea_1228 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			List<String> code = new ArrayList<>();
			for(int j = 0; j < N; j++) {
				code.add(st.nextToken());
			}
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int i = 0;
			while(i < M) {
				String command = st.nextToken();
				int point = Integer.parseInt(st.nextToken());
				int count = Integer.parseInt(st.nextToken());
				for(int p = point; p < point + count; p++) {
					code.add(p, st.nextToken());
				}
				i++;
			}
			sb.append("#" + tc + " ");
			for(int j = 0; j < 10; j++) {
				sb.append(code.get(j) + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
