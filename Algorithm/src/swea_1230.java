import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swea_1230 {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> list;
	
		for(int tc = 1; tc <= 10; tc++) {
			list = new ArrayList<>();
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				String command = st.nextToken();
				if(command.equals("I")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for(int j = 0; j < y; j++) {
						list.add(x + j, Integer.parseInt(st.nextToken()));
					}
					continue;
				}
				if(command.equals("D")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for(int j = 0; j < y; j++) {
						list.remove(x);
					}
					continue;
				}
				if(command.equals("A")) {
					int y = Integer.parseInt(st.nextToken());
					for(int j = 0; j < y; j++) {
						list.add(list.size() - 1, Integer.parseInt(st.nextToken()));
					}
				}
			}
			sb.append("#" + tc);
			for(int i = 0; i < 10; i++) {
				sb.append(" " + list.get(i));
			}
			sb.append("\n");
 		}
		System.out.println(sb);
	}

}
