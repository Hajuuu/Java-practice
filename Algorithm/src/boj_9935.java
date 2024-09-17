import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_9935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String bomb = br.readLine();
		Stack<Character> stack = new Stack<>();
		boolean check = true;
		
		for(int i = 0; i < s.length(); i++) {
			stack.push(s.charAt(i));
			if(stack.size() >= bomb.length()) {
				check = true;
				for(int j = 0; j < bomb.length(); j++) {
					if(stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
						check = false;
						break;
					}
				}
				if(check) {
					for(int j = 0; j < bomb.length(); j++) {
						stack.pop();
					}
				} 
			}
		}
		if(stack.size() == 0) {
			System.out.println("FRULA");
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		for(char c : stack) {
			sb.append(c);		
		}
		System.out.println(sb);
	}

}
