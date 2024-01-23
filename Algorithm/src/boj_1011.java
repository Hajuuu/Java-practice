import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_1011 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int distance = y - x;
			int max = (int) Math.sqrt(distance);
			
			int count = 0;
			if(max == Math.sqrt(distance)) {
				count = max * 2 - 1;
			} else if(distance <= max * max + max) {
				count = max * 2;
			} else {
				count = max * 2 + 1;
			}
			sb.append(count + "\n");
		}
		System.out.println(sb);
	}
	
	

}
