import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2018 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int start_index = 0;
		int end_index = 0;
		int sum = 0;
		int count = 1;
		while(end_index != N) {
			if(sum > N) {
				sum -= start_index;
				start_index++;
			} else if(sum < N) {
				end_index++;
				sum += end_index;
			} else {
				count++;
				end_index++;
				sum += end_index;
			}
		}
		
		System.out.println(count);
	}

}
