import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_27433 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long answer = factorial(N, 1);
		System.out.println(answer);
		
	}
	
	static long factorial(int num, long result) {
		if(num == 0) {
			return result;
		}
		return factorial(num - 1, result * num);
	}

}
