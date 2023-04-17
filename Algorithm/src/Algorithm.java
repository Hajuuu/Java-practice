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
		StringBuffer sb = new StringBuffer();
		
		int i = 0;
		if(str.length() % 3 == 1) {
			sb.append((str.charAt(0) - '0') * 1);
			i++;
		} else if(str.length() % 3 == 2) {
			sb.append((str.charAt(1) - '0') * 1 + (str.charAt(0) - '0') * 2);
			i += 2;
		} 
		
		for(int j = i; j <= str.length() - 3; j += 3) {
			sb.append((str.charAt(j + 2) - '0') * 1 + (str.charAt(j + 1) - '0') * 2 + (str.charAt(j) - '0') * 4);
		}
		
		System.out.println(sb);
	}
	
} 
