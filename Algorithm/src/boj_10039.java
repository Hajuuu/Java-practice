import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10039 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		for(int i = 0; i < 5; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num < 40) {
				sum += 40;
				continue;
			}
			sum += num;
		}
		
		System.out.println(sum / 5);
	}

}
