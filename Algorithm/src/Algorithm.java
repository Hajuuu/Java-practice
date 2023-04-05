import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		
		String[] arr = new String[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr, (e1, e2) -> {
			if(e1.length() != e2.length()) {
				return e1.length() - e2.length();
			} else {
				return e1.compareTo(e2);
			}
		});
	
		sb.append(arr[0] + "\n");
		for(int i = 1; i < N; i++) {
			if(!arr[i].equals(arr[i - 1])) {
				sb.append(arr[i] + "\n");
			}
		}
		
		System.out.println(sb);
		
	}
	
} 
