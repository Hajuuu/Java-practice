import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Algorithm {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		int len = str.length;
		StringBuffer sb = new StringBuffer();
		int[] arr = new int[26];
		for(int i = 0; i < 26; i++) {
			arr[i] = -1;
		}
		for(int i = 0; i < len; i++) {
			if(arr[(int) str[i] - 97] == -1) {
				arr[(int) str[i] - 97] = i;
			}
			
		}
		
		for(int i = 0; i < 26; i++) {
			sb.append(arr[i]).append(" ");
		}
		
		System.out.println(sb);
		
	}
	
}
