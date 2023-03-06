import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Algorithm {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int C = Integer.parseInt(br.readLine());
		for(int i = 0; i < C; i++) {
			int sum = 0;
			double avg = 0;
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];

			for(int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				sum += arr[j];
			}
			
			avg = sum / n;
			double a = 0;
			for(int j = 0; j < n; j++) {
				if(arr[j] > avg) {
					a++;
				}
			}
			sb.append(String.format("%.3f", a * 100 / n) + "%").append("\n");
		}
		
		System.out.println(sb);
		
	}
	
}
