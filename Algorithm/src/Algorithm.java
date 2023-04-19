import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[9];
		int sum = 0;
		for(int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		int a = 0;
		int b = 0;
		for(int i = 0; i < 9; i++) {
			for(int j = i + 1; j < 9; j++) {
				if((sum - arr[i] - arr[j]) == 100) {
					a = arr[i];
					b = arr[j];
				}
			}
		}
		
		Arrays.sort(arr);
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < 9; i++) {
			if(arr[i] != a && arr[i] != b) {
				sb.append(arr[i] + "\n");
			}
		}
		
		System.out.println(sb);
			
	}
} 
