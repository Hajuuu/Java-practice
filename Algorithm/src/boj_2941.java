import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2941 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] alphabet = new int[str.length()];
		int count = 0;
		for(int i = 0; i < str.length() - 1; i++) {
			if(str.charAt(i) == 'c') {
				if(str.charAt(i + 1) == '=') {
					count++;
					alphabet[i]++;
					alphabet[i + 1]++;
					i += 1;
				} else if(str.charAt(i + 1) == '-') {
					count++;
					alphabet[i]++;
					alphabet[i + 1]++;
					i += 1;
				}
			} else if(str.charAt(i) == 'd') {
				if(str.charAt(i + 1) == 'z') {
					if(i < str.length() - 2 && str.charAt(i + 2) == '=') {
						count++;
						alphabet[i]++;
						alphabet[i + 1]++;
						alphabet[i + 2]++;
						i += 2;
					}
				} else if(str.charAt(i + 1) == '-') {
					count++;
					alphabet[i]++;
					alphabet[i + 1]++;
					i += 1;
				}
			} else if(str.charAt(i) == 'l' && str.charAt(i + 1) == 'j') {
				count++;
				alphabet[i]++;
				alphabet[i + 1]++;
				i += 1;
			} else if(str.charAt(i) == 'n' && str.charAt(i + 1) == 'j') {
				count++;
				alphabet[i]++;
				alphabet[i + 1]++;
				i += 1;
			} else if(str.charAt(i) == 's' && str.charAt(i + 1) == '=') {
				count++;
				alphabet[i]++;
				alphabet[i + 1]++;
				i += 1;
			} else if(str.charAt(i) == 'z' && str.charAt(i + 1) == '=') {
				count++;
				alphabet[i]++;
				alphabet[i + 1]++;
				i += 1;
			}
		}
		
		for(int i = 0; i < alphabet.length; i++) {
			if(alphabet[i] == 0) {
				count++;
			}
		}
		System.out.println(count);
	}

}
