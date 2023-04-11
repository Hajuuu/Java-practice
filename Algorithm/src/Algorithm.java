import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		
		int stick = 0;
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < len; i++) {
			if(str.charAt(i) == '(') {
				stack.push('(');
			} else if(str.charAt(i) == ')') {
				if(str.charAt(i - 1) == '(') {
					stack.pop();
					stick += stack.size();
				} else {			
					stack.pop();
					stick += 1;
				}
			}
		}
		
		System.out.println(stick);
		
	}
	
	
} 
