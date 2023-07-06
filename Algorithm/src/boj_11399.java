import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11399 {

	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i < N; i++) {
			int t = arr[i];
			int j = i - 1;
			while(j >= 0 && t < arr[j]) {
				arr[j + 1] = arr[j];
				j--;
			}
			
			arr[j + 1] = t;
		}
		
		long[] sum = new long[N];
		sum[0] = arr[0];
		for(int i = 1; i < N; i++) {
			sum[i] = sum[i - 1] + arr[i];
		}
		
		long answer = 0;
		for(int i = 0; i < N; i++) {
			answer += sum[i];
		}
		
		System.out.println(answer);
	}

}
