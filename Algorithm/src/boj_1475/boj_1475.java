import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		int[] arr = new int[10];
		for(int i = 0; i < num.length(); i++) {
			arr[num.charAt(i) - '0']++;
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < 10; i++) {
			if(i == 6 || i == 9) {
				continue;
			}
			max = Math.max(max, arr[i]);
		}
		
		int number = (arr[6] + arr[9]) / 2 + (arr[6] + arr[9]) % 2;
		
		System.out.println(Math.max(max, number));
	}

}
