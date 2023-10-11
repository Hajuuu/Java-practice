import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_8958 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < t; i++) {
			String str = br.readLine();
			int sum = 0;
			int num = 0;
			for(int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == 'O') {
					num += 1;
					sum += num;
				}
				else {
					num = 0;
				}
			}
			sb.append(sum + "\n");
		}
		
		System.out.println(sb);
	}

}
