import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Algorithm {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().toUpperCase();
		int len = str.length();
		int[] arr = new int[26];
		for(int i = 0; i < len; i++) {
			arr[str.charAt(i) - 'A']++;
		}
		int max = 0;
		char ch = ' ';
		for(int i = 0; i < 26; i++) {
			if(max < arr[i]) {
				max = arr[i];
				ch = (char) (i + 'A');
			}
			else if(max == arr[i]) 
				ch = '?';
		}
		
		System.out.println(ch);
	}
	
}
