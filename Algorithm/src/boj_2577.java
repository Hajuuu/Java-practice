import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2577 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int num = A * B * C;
		String result = Integer.toString(num);
		int[] answer = new int[10];
		for(int i = 0; i < result.length(); i++) {
			answer[result.charAt(i) - '0']++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i : answer) {
			sb.append(i + "\n");
		}
		
		System.out.println(sb);
		
	}

}
