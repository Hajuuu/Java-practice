import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_20164 {

	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String number = br.readLine();
		divide(number, check(number));
		System.out.println(min + " " + max);
	}
	
	public static void divide(String input, int count) {
		if(input.length() == 1) {
			max = Math.max(max, count);
			min = Math.min(min, count);
			return;
		}
		
		if(input.length() == 2) {
			int sum = (input.charAt(0) - '0') + (input.charAt(1) - '0');
			divide(String.valueOf(sum), count + check(String.valueOf(sum)));
		}
		
		for(int i = 1; i < input.length() - 1; i++) {
			for(int j = i + 1; j < input.length(); j++) {
				String a = input.substring(0, i);
				String b = input.substring(i, j);
				String c = input.substring(j);
				
				int sum = Integer.parseInt(a) + Integer.parseInt(b) + Integer.parseInt(c);
				divide(String.valueOf(sum), count + check(String.valueOf(sum)));

			}
		}
	}
	
	public static int check(String input) {
		int count = 0;
		for(int i = 0; i < input.length(); i++) {
			if((input.charAt(i) - '0') % 2 == 1) {
				count += 1;
			}
		}
		return count;
	}
}
