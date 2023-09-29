import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9251 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] string1 = br.readLine().toCharArray();
		char[] string2 = br.readLine().toCharArray();
		
		int answer = lcs(string1, string2);
		
		System.out.println(answer);
	}
	
	public static int lcs(char[] str1, char[] str2) {
		int[][] dp = new int[str1.length + 1][str2.length + 1];
		
		int result = Integer.MIN_VALUE;
		for(int i = 1; i <= str1.length; i++) {
			for(int j = 1; j <= str2.length; j++) {
				if(str1[i - 1] == str2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					result = Math.max(result, dp[i][j]);
					continue;
				}
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				result = Math.max(result, dp[i][j]);
			}
		}
		
		return result;
		
	}

}
