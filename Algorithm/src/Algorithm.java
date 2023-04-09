import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String str = br.readLine();
		int N = str.length();
		int M = Integer.parseInt(br.readLine());
		
		Stack<Character> stack1 = new Stack<>();
		Stack<Character> stack2 = new Stack<>();
		
		for(int i = 0; i < N; i++) {
			stack1.push(str.charAt(i));
		}
		for(int i = 0; i < M; i++) {
			String cur = br.readLine();
			if(cur.charAt(0) == 'L') {
				if(!stack1.empty()) {
					stack2.push(stack1.pop());
				}
			} else if(cur.charAt(0) == 'D') {
				if(!stack2.empty()) {
					stack1.push(stack2.pop());
				} 
				
			} else if(cur.charAt(0) == 'B') {
				if(!stack1.empty()) {
					stack1.pop();
				}
			} else if(cur.charAt(0) == 'P'){
				stack1.push(cur.charAt(2));
			}
		}
		
		while(!stack1.empty()) {
			stack2.push(stack1.pop());
		}
		while(!stack2.empty()) {
			sb.append(stack2.pop());
		}
		System.out.println(sb);
	}
	
	
} 
