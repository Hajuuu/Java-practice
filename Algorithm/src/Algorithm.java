import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Algorithm {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		
		for(int p = 0; p < M; p++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			reverse(arr, i - 1, j);
		}
		
		for(int i = 0; i < N; i++) {
			sb.append(arr[i]).append(" ");
		}
		
		System.out.println(sb);
	}
	
	public static void reverse(int[] arr, int i, int j) {
	
		int[] copy = Arrays.copyOfRange(arr, i, j);
		
		int len = copy.length;
		for(int p = 0; p < len; p++) {
			arr[i+p] = copy[len-(p+1)]; 
		}
	}
}
