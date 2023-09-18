import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_24416 {

	static int count1, count2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		fib(N);
		fibonacci(N);
		
		System.out.println(count1 + " " + count2);
	}
	
	public static int fib(int n) {
		if(n == 1 || n == 2) {
			count1++;
			return 1;
		}
		
		return (fib(n - 1) + fib(n - 2));
	}
	
	public static int fibonacci(int n) {
		int[] arr = new int[n];
		arr[0] = 1;
		arr[1] = 1;
		
		for(int i = 2; i < n; i++) {
			arr[i] = arr[i - 2] + arr[i - 1];
			count2++;
		}
		
		return arr[n - 1];
	}

}
