import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		int len = s.length();
		int[] arr = new int[26];
		for(int i = 0; i < len; i++) {
			arr[s.charAt(i) - 'a']++;
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < 26; i++) {
			sb.append(arr[i] + " ");
		}
		
		System.out.println(sb);
	}
	
	
} 
