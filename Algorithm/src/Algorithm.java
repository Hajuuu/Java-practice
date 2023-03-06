import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Algorithm {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		int len = word.length();
		int q = 0;
		for(int i = 0; i <= len / 2; i++) {
			if(word.charAt(i) != word.charAt(len - i - 1)) {
				q += 1;
			}
		}
		if(q == 0)
			System.out.println(1);
		else
			System.out.println(0);
		
	}
	
}
