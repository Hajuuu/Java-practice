import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		Stack<String> stack = new Stack<>();
		// '(' 일때 push ')' 일때 pop
		
		for(int i = 0; i < N; i++) {
			String[] arr = br.readLine().split("");
			stack.clear();
			for(String s : arr) {
				
				if(s.equals("(")) {
					stack.push("(");
				}
				else {
					if(!stack.empty() && stack.peek() != ")") {
						stack.pop();
					} else {
						stack.push(")");
					}
				}
				
			}
			if(stack.empty()) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}
			
		System.out.println(sb);
	}
} 
