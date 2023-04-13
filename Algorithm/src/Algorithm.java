import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String str = br.readLine();
		int len = str.length();
		String answer = "";
		for(int i = 0; i < len; i++) {
			if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				if(str.charAt(i) + 13 > 90) {
					answer += (char) (str.charAt(i) + 13 - 26);
				} else {
					answer += (char) (str.charAt(i) + 13);
				}
			} else if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
				if(str.charAt(i) + 13 > 122) {
					answer += (char) (str.charAt(i) + 13 - 26);
				} else {
					answer += (char) (str.charAt(i) + 13);
				}
			} else {
				answer += str.charAt(i);
			}
		}
		
		System.out.println(answer);
	}
	
	
} 
