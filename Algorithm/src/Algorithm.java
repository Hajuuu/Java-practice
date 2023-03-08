import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Algorithm {
		
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = new String[5];
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < 5; i++) {
			arr[i] = br.readLine();
		}
		
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 5; j++) {
				if(arr[j].length() > i) {
					sb.append(arr[j].charAt(i));
				} else {
					continue;
				}
				
			}
		}
		
		System.out.println(sb);
	}
	
	
}
