import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_1300 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		long low = 1;
		long high = k;
		
		while(low < high) {
			long count = 0;
			long mid = (low + high) / 2;
			
			for(int i = 1; i <= N; i++) {
				count += Math.min(mid / i, N);
			}
			
			if(count >= k) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		
		System.out.println(low);
	}

}
