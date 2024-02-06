import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_11729 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Stack<Integer>[] stack = new Stack[3];
		for(int i = 0; i < 3; i++) {
			stack[i] = new Stack<>();
		}
		for(int i = N; i > 0; i--) {
			stack[0].push(i);
		}
		
		while(true) {
			if(stack[2].size() == N) {
				break;
			}
			for(int i = 0; i < 3; i++) {
				int a = (i + 1) % 3;
				int b = (i + 2) % 3;
				if(!stack[i].isEmpty()) {
					if(stack[b].isEmpty()) {
						stack[b].push(stack[i].pop());
						sb.append(i + " " + b + "\n");
					} else if(stack[b].isEmpty()){
						if(stack[b].peek() > stack[i].peek()) {
							stack[b].push(stack[i].pop());
							sb.append(i + " " + b + "\n");
						}
					}
					if(stack[a].isEmpty()) {
						stack[a].push(stack[i].pop());
						sb.append(i + " " + a + "\n");
					} else if(!stack[a].isEmpty()) {
						if(stack[a].peek() > stack[i].peek()) {
							stack[a].push(stack[i].pop());
							sb.append(i + " " + a + "\n");
						}
					}
				}
				
				
			}
		}
		
		
		System.out.println(sb);
	}

}
