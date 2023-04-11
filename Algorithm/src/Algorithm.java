import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> deque = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			if(str.charAt(0) == 'p' && str.charAt(1) == 'u') {
				String[] arr = str.split(" ");
				if(str.charAt(5) == 'b') {
					deque.offerLast(Integer.parseInt(arr[1]));
				} else {
					deque.offerFirst(Integer.parseInt(arr[1]));
				}
			}
			else if(str.charAt(0) == 'p') {
				if(deque.isEmpty()) {
					sb.append(-1 + "\n");
					continue;
				}
				if(str.charAt(4) == 'f') {
					sb.append(deque.peek() + "\n");
					deque.poll();
				} else {
					sb.append(deque.peekLast() + "\n");
					deque.pollLast();
				}
			}
			else if(str.charAt(0) == 's') {
				sb.append(deque.size() + "\n");
			}
			else if(str.charAt(0) == 'e') {
				if(deque.isEmpty()) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}
			}
			else if(str.charAt(0) == 'f') {
				if(deque.isEmpty()) {
					sb.append(-1 + "\n");
				} else {
					sb.append(deque.peek() + "\n");
				}
			}
			else {
				if(deque.isEmpty()) {
					sb.append(-1 + "\n");
				} else {
					sb.append(deque.peekLast() + "\n");
				}
			}
			
			
		}
		System.out.println(sb);
		
	}
	
	
} 
