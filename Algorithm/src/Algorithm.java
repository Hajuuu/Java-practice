import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int len = str.length();
		
		String answer = "";
		Stack<Character> operator = new Stack<>();
		for(int i = 0; i < len; i++) {
			if(str.charAt(i) >= 65 && str.charAt(i) <= 90) {
				answer += str.charAt(i);
			} 
			else {
				if(operator.empty()) {
					operator.push(str.charAt(i));
				} else {
					if(str.charAt(i) == '*' || str.charAt(i) == '/') {
						if(operator.peek() == '/' || operator.peek() == '*') {
							answer += operator.pop();
							operator.push(str.charAt(i));
						} else {
							operator.push(str.charAt(i));
						}
					} else if(str.charAt(i) == ')') {
						while(operator.peek() != '(') {
							answer += operator.pop();
						}
						operator.pop();
					} else if(str.charAt(i) == '+' || str.charAt(i) == '-') {
						if(operator.peek() == '*' || operator.peek() == '/') {
							answer += operator.pop();
							if(!operator.empty() && (operator.peek() == '+' || operator.peek() == '-')) {
								answer += operator.pop();
							}
							operator.push(str.charAt(i));
							
						} else {
							if(!operator.empty() && operator.peek() == '(') {
								operator.push(str.charAt(i));
							} else {
								answer += operator.pop();
								operator.push(str.charAt(i));
							}
							
						}
						
					} else {
						operator.push(str.charAt(i));
					}
				}
			}
		}
		
		while(!operator.empty()) {
			answer += operator.pop();
		}
		
		System.out.println(answer);
	}
	
	
} 
