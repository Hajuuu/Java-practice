import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11720 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		String str = br.readLine();
		for(int i = 0; i < N; i++) {
			answer += str.charAt(i) - '0';
		}
		
		System.out.println(answer);
	}

}
