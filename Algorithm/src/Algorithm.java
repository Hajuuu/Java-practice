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
		
		Stack<Integer> stack1 = new Stack<>();
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			stack1.push(n);
			arr[i] = n;
		}
		int max = Arrays.stream(arr).max().getAsInt();
		int[] F = new int[max + 1];
		while(!stack1.empty()) {
			F[stack1.pop()]++;
		}
		
		for(int i = 0; i < N; i++) {
			while(!stack1.empty() && F[arr[stack1.peek()]] < F[arr[i]]) {
				arr[stack1.pop()] = arr[i]; 
			}
			stack1.push(i);
		}
		
		while(!stack1.empty()) {
			arr[stack1.pop()] = -1;
		}
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < N; i++) {
			sb.append(arr[i] + " ");
		}
		
		System.out.println(sb);
		
	}
	
	
} 
