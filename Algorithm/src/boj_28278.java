import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_28278 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			if(str.charAt(0) - '0' == 1) {
				st = new StringTokenizer(str);
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				stack.add(b);
			} else if(str.charAt(0) - '0' == 2) {
				if(!stack.empty()) {
					sb.append(stack.pop() + "\n");
				} else {
					sb.append("-1\n");
				}
			} else if(str.charAt(0) - '0' == 3) {
				sb.append(stack.size() + "\n");
			} else if(str.charAt(0) - '0' == 4) {
				if(stack.empty()) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
			} else {
				if(!stack.empty()) {
					sb.append(stack.peek() + "\n");
				} else {
					sb.append("-1\n");
				}
			}
		}
		
		System.out.println(sb);
	}

}
