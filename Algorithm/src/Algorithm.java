import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			if(str.charAt(0) == 'p' && str.charAt(1) == 'u') {
				String[] st = str.split(" ");
				stack.push(Integer.parseInt(st[1]));				
			} else if(str.charAt(0) == 'p') {
				if(!stack.empty()) {
					sb.append(stack.pop() + "\n");
				} else {
					sb.append(-1 + "\n");
				}
				
			} else if(str.charAt(0) == 's') {
				sb.append(stack.size() + "\n");
			} else if(str.charAt(0) == 'e') {
				if(stack.empty()) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}
			} else if(str.charAt(0) == 't') {				
				if(stack.empty()) {
					sb.append(-1 + "\n");
				} else {
					sb.append(stack.peek() + "\n");
				}
			}
		}
		
		System.out.println(sb);
	}
} 
