import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1427 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		int N = str.length();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = str.charAt(i) - '0';
		}
		
		for(int i = 0; i < N; i++) {
			int max = i;
			for(int j = i + 1; j < N; j++) {
				if(arr[j] > arr[max]) {
					max = j;
				}
				
 			}
			int num = arr[max];
			arr[max] = arr[i];
			arr[i] = num;			
		}
		
		for(int i = 0; i < N; i++) {
			sb.append(arr[i]);
		}
		
		System.out.println(sb);
	}

}
