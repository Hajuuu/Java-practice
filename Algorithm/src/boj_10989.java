import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10989 {
	
	static int[] arr;
	static int[] sorted;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		sorted = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		merge_sort(0, N - 1);
		StringBuilder sb = new StringBuilder();
		
		for(int i : arr) {
			sb.append(i + "\n");
		}
		
		System.out.println(sb);
		
	}
	
	public static void merge_sort(int left, int right) {
//		top-down방식
//		if(left < right) {
//			int mid = (left + right) / 2;
//			
//			merge_sort(left, mid);
//			merge_sort(mid + 1, right);
//			merge(left, mid, right);
//		}
		
		for(int size = 1; size <= right; size += size) {
			for(int i = 0; i <= right - size; i += (size * 2)) {
				int low = i;
				int mid = i + size - 1;
				int high = Math.min(i + 2 * size - 1, right);
				
				merge(low, mid, high);
			}
		}
	}
	
	public static void merge(int left, int mid, int right) {
		int l = left;
		int r = mid + 1;
		int idx = left;
		
		while(l <= mid && r <= right) {
			if(arr[l] < arr[r]) {
				sorted[idx] = arr[l];
				l++;
				idx++;
			} else {
				sorted[idx] = arr[r];
				r++;
				idx++;
			}
		}
		
		if(l > mid) {
			while(r <= right) {
				sorted[idx] = arr[r];
				r++;
				idx++;
			}
		} else {
			while(l <= mid) {
				sorted[idx] = arr[l];
				l++;
				idx++;
			}
		}
		
		for(int i = left; i <= right; i++) {
			arr[i] = sorted[i];
		}
	}

}
