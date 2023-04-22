import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Integer.parseInt(br.readLine());
		if(N < 10) {
			System.out.println(N);
		}
		else if(N < 100) {
			System.out.println((N - 9) * 2 + 9);
		} 
		else if(N < 1000) {
			System.out.println((N - 99) * 3 + 90 * 2 + 9);
		} else if(N < 10000) {
			System.out.println((N - 999) * 4 + 900 * 3 + 90 * 2 + 9);
		} else if(N < 100000) {
			System.out.println((N - 9999) * 5 + 9000 * 4 + 900 * 3 + 90 * 2 + 9);
		} else if(N < 1000000) {
			System.out.println((N - 99999) * 6 + 90000 * 5 + 9000 * 4 + 900 * 3 + 90 * 2 + 9);
		} else if(N < 10000000) {
			System.out.println((N - 999999) * 7 + 900000 * 6 + 90000 * 5 + 9000 * 4 + 900 * 3 + 90 * 2 + 9);
		} else if(N < 100000000) {
			System.out.println((N - 9999999) * 8 + 9000000 * 7 + 900000 * 6 + 90000 * 5 + 9000 * 4 + 900 * 3 + 90 * 2 + 9);
		} else {
			System.out.println(90000000 * 8 + 9000000 * 7 + 900000 * 6 + 90000 * 5 + 9000 * 4 + 900 * 3 + 90 * 2 + 9 + 9);
		}
	}
} 
