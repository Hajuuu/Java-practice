import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_25501 {

	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		for(int tc = 0; tc < T; tc++) {
			char[] arr = br.readLine().toCharArray();
			count = 1;
			int answer = isPalindrome(arr);
			sb.append(answer + " " + count + "\n");
		}
		System.out.println(sb);
	}
	
	static int recursion(char[] s, int l, int r) {
		if(l >= r) return 1;
		else if(s[l] != s[r]) {
			return 0;
		} else {
			count++;
			return recursion(s, l + 1, r - 1);
		}
	}
	
	static int isPalindrome(char[] s) {
		return recursion(s, 0, s.length - 1);
	}

}
