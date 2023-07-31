import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1747 {

	static boolean[] prime;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = 10000001;
		prime = new boolean[max];
		
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		isPrime();
		for(int i = N; i <= max; i++) {
			if(!prime[i]) {
				if(palindrome(i)) {
					answer = i;
					break;
				}
			}
		}
		System.out.println(answer);
	}

	public static void isPrime() {
		prime[0] = true;
		prime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(prime.length); i++) {
			if(prime[i]) continue;
			for(int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}
	
	public static boolean palindrome(int num) {
		String str = Integer.toString(num);
		for(int i = 0; i < str.length() / 2; i++) {
			if(str.charAt(i) != str.charAt(str.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}
}
