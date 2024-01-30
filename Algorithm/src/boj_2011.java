import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2011 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int mod = 1000000;
		int length = str.length();
		
		int[] dp = new int[length + 1];
		dp[0] = 1;
		for(int i = 1; i <= length; i++) {
			int one = str.charAt(i - 1) - '0';
			if(one >= 1 && one <= 26) {
				dp[i] = dp[i - 1] % mod;
			}
			
			if(i == 1) {
				continue;
			}
			
			int ten = (str.charAt(i - 2) - '0') * 10 + one;
			if(ten >= 10 && ten <= 26) {
				dp[i] += dp[i - 2] % mod;
			}
			
		}
		
		System.out.println(dp[length] % mod);
	}

}
