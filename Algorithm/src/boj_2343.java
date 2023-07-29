import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2343 {

	static int N, M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		int start = 0;
		int end = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(start < arr[i]) {
				start = arr[i];
			}
			end += arr[i];
		}
		
		System.out.println(binary_search(start, end));
	}
	
	public static int binary_search(int start, int end) {
		
		while(start <= end) {
			int mid = (start + end) / 2;
			int count = 0;
			int sum = 0;
			
			for(int i = 0; i < N; i++) {
				if(sum + arr[i] > mid) {
					count++;
					sum = 0;
				}
				sum += arr[i];
			}
			
			if(sum != 0) {
				count++;
			}
			
			if(count > M) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		return start;
	}

}
