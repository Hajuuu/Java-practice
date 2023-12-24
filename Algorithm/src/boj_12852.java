import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_12852 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Number[] dp = new Number[N + 1];
		dp[1] = new Number(0, "1");
		for(int i = 2; i <= N; i++) {
			int count = Integer.MAX_VALUE;
			int before = 0;
			if(i % 3 == 0) {
				count = dp[i / 3].count + 1;
				before = i / 3;
			}
			
			if(i % 2 == 0) {
				if(count > dp[i / 2].count + 1) {
					count = dp[i / 2].count + 1;
					before = i / 2;
				}
			}
			
			if(count > dp[i - 1].count + 1) {
				count = dp[i - 1].count + 1;
				before = i - 1;
			}
			
			
			dp[i] = new Number(count, i + " " + dp[before].numbers);
			
		}
		
		sb.append(dp[N].count + "\n");
		sb.append(dp[N].numbers);
		System.out.println(sb);
	}
	
	

}

class Number {
	
	int count;
	String numbers;
	
	Number(int count, String numbers) {
		this.count = count;
		this.numbers = numbers;
	}
}
