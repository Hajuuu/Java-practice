import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		double[] arr = new double[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Double.parseDouble(br.readLine());
		}
		
		Stack<Double> stack = new Stack<>();
		
		int len = str.length();
		
		for(int i = 0; i < len; i++) {
			if(str.charAt(i) >= 65 && str.charAt(i) <= 90) {
				stack.push((arr[str.charAt(i) - 'A']));
			} else {
				if(str.charAt(i) == '*') {
					double n = stack.pop() * stack.pop();
					stack.push(n);
				}
				else if(str.charAt(i) == '/') {
					double a = stack.pop();
					double b = stack.pop();
					double n = b / a;
					stack.push(n);
				}else if(str.charAt(i) == '+') {
					double n = stack.pop() + stack.pop();
					stack.push(n);
				}
				else if(str.charAt(i) == '-') {
					double a = stack.pop();
					double b = stack.pop();
					stack.push(b - a);
				}
				
			}
			
			
		}
		
		System.out.printf("%.2f", stack.pop());
	}
	
	
} 
