import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_1874 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Integer> stack = new Stack<>();
		
		int num = 1;
		for(int i = 0; i < N; i++) {
			if(arr[i] >= num) {
				while(arr[i] >= num) {
					stack.push(num);
					num++;
					sb.append("+\n");
				}
				stack.pop();
				sb.append("-\n");
			} 
			else {
				int n = stack.pop();
				if(n > arr[i]) {
					System.out.println("NO");
					return;
				} else {
					sb.append("-\n");
				}
			}
		}
		
		System.out.println(sb);
	}

}
