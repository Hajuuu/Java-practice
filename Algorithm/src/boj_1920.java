import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1920 {

	static int[] arr;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(binary_sort(num)) {
				sb.append(1 + "\n");
			} else {
				sb.append(0 + "\n");
			}
		}
		
		System.out.println(sb);
	}
	
	public static boolean binary_sort(int n) {
		int left = 0;
		int right = N - 1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(n > arr[mid]) {
				left = mid + 1;
			} else if(n < arr[mid]) {
				right = mid - 1;
			} else {
				return true;
			}
		}
		return false;
	}

}
