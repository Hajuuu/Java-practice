import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int count1 = zero1(n) - zero1(n - m) - zero1(m);
		int count2 = zero2(n) - zero2(n - m) - zero2(m);
		
		System.out.println(Math.min(count1, count2));
	}
	
	public static int zero1(int num) {
		int count = 0;
		
		while(num >= 5) {
			count += num / 5;
			num /= 5;
		}
		
		return count;
	}
	
	public static int zero2(int num) {
		int count = 0;
		
		while(num >= 2) {
			count += num / 2;
			num /= 2;
		}
		
		return count;
	}
} 
