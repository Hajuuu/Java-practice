import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class swea_1984 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; tc++) {
			List<Integer> numbers = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 10; i++) {
				numbers.add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(numbers);
			double sum = 0;
			for(int i = 1; i < 9; i++) {
				sum += numbers.get(i);
			}
			sb.append("#" + tc + " " + Math.round(sum / 8) + "\n");
		}
		System.out.println(sb);
	}

}
