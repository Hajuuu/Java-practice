import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class boj_12904 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();
		List<Character> finalString = new ArrayList<>();
		
		for(int i = 0; i < T.length(); i++) {
			finalString.add(T.charAt(i));
		}
		
		for(int i = T.length() - 1; i >= S.length(); i--) {
			if(finalString.get(i) == 'A') {
				finalString.remove(i);
			} else if(finalString.get(i) == 'B') {
				finalString.remove(i);
				Collections.reverse(finalString);
			}
		}
		
		String answer = "";
		for(char c : finalString) {
			answer += c;
		}
		if(answer.equals(S)) {
			System.out.println(1);
			return;
		}
		System.out.println(0);
	}

}
