import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Algorithm {
		
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int group = 0;
		for(int i = 0; i < N; i++) {
			if(check() == true) {
				group++;
			}
		}
		System.out.println(group);
	}
	
	public static boolean check() throws IOException {
		boolean[] check = new boolean[26];
		int prev = 0;
		String str = br.readLine();
		int len = str.length();
		for(int i = 0; i < len; i++) {
			int now = str.charAt(i);
			
			if(prev != now) {
				if(check[now - 'a'] == false) {
					check[now - 'a'] = true;
					prev = now;
				} else {
					return false;
				}
			}
		}
		
		return true;
	}
	
	
	
}
