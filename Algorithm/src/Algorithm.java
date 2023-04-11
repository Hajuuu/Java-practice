import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		//스택에 넣다가 괄호 나오면 sb.append, pop
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		Stack<Character> stack = new Stack<>();
		String str = br.readLine();
		int len = str.length();
		for(int i = 0; i < len; i++) {
			if(str.charAt(i) == '<') {
				while(!stack.empty()) {
					sb.append(stack.pop());
				}
				while(str.charAt(i) != '>') {
					sb.append(str.charAt(i));
					i++;
				}
				if(str.charAt(i) == '>') {
					sb.append(">");
				}
			}
			else if(str.charAt(i) == ' ') {
				while(!stack.empty()) {
					sb.append(stack.pop());
				}
				sb.append(" ");
			}
			else {
				stack.push(str.charAt(i));
			}
		}
		
		while(!stack.empty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb);
		
	}
	
	
} 
