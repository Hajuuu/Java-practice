import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1517 {

	static long[] arr;
	static long[] sorted;
	static long answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new long[N];
		sorted = new long[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		merge_sort(0, N - 1);
		System.out.println(answer);
	}

	public static void merge_sort(int left, int right) {
		if(left < right) {
			int mid = (left + right) / 2;
			
			merge_sort(left, mid);
			merge_sort(mid + 1, right);
			merge(left, mid, right);
		}
	}
	
	public static void merge(int left, int mid, int right) {
		int l = left;
		int r = mid + 1;
		int idx = left;
		while(l <= mid && r <= right) {
			if(arr[l] <= arr[r]) {
				sorted[idx] = arr[l];
				idx++;
				l++;
			}
			else {
				sorted[idx] = arr[r];
				idx++;
				r++;
				answer += (mid + 1 - l);
			}
 		}
		
		if(l > mid) {
			while(r <= right) {
				sorted[idx] = arr[r];
				idx++;
				r++;
			}
		} else {
			while(l <= mid) {
				sorted[idx] = arr[l];
				idx++;
				l++;
			}
		}
		
		for(int i = left; i <= right; i++) {
			arr[i] = sorted[i];
		}
	}
}
