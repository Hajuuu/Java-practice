import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		Stack<Integer> stack = new Stack<>();
		int j = 1;
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			while(j <= num) {
				stack.push(j);
				sb.append("+\n");
				j++;
			}
			if(stack.peek() == num) {
				stack.pop();
				sb.append("-\n");
				continue;
			} else if(stack.peek() > num) {
				System.out.println("\nNO");
				return;
			}
		}
		
		System.out.println(sb);
	}
	
	
} 
