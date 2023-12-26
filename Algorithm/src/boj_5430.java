import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_5430 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < T; i++) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), "[],");
			List<Integer> list = new ArrayList<>();
			for(int j = 0; j < n; j++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			if(n == 0) {
				if(p.contains("D")) {
					sb.append("error\n");
				} else {
					sb.append("[]\n");
				}
				continue;
			}

			int count = 0;
			boolean check = true;
			for(int j = 0; j < p.length(); j++) {
				if(p.charAt(j) == 'R') {
					count++;
				}
				if(p.charAt(j) == 'D') {
					if(list.size() == 0) {
						sb.append("error\n");
						check = false;
						break;
					}
					if(count % 2 == 0) {
						list.remove(0);
					} else {
						list.remove(list.size() - 1);
					}
					
				}
			}
			if(check) {
				if(count % 2 == 0) {
					String answer = list.toString().replaceAll(" ", "");
					sb.append(answer + "\n");
				} else {
					Collections.reverse(list);
					String answer = list.toString().replaceAll(" ", "");
					sb.append(answer + "\n");
				}
			}
		}
		System.out.println(sb);
	}

}

