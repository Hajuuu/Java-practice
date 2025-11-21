import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] number = new int[10];
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) - '0' == 6) {
				number[9]++;
				continue;
			}
			number[str.charAt(i) - '0']++;
		}
		int max = 0;
		int count = 0;
		for (int i = 0; i <= 9; i++) {
			if (count < number[i]) {
				max = i;
				count = number[i];
			}
		}
		if (max == 9) {
			System.out.println((count / 2) + (count % 2));
			return;
		}
		System.out.println(count);
	}

}
