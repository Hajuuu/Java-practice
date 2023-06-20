import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1110 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int num = N;
		int count = 0;
		while(true) {
			int a = num / 10;
			int b = num % 10;
			
			int c = (a + b) % 10;
			num = b * 10 + c;
			if(num == N) {
				count++;
				break;
			}
			count++;
		}

		System.out.println(count);
	}

}
