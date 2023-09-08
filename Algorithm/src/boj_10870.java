import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10870 {

	static int[] arr;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		if(n == 0) {
			System.out.println(0);
			return;
		}
		
		arr = new int[n + 1];
		arr[0] = 0;
		
		System.out.println(fibonacci(1, 1));
	}

	public static int fibonacci(int i, int sum) {
		arr[i] = sum;
		if(i == n) {
			return arr[i];
		}
		return fibonacci(i + 1, arr[i - 1] + arr[i]);
	}
}
