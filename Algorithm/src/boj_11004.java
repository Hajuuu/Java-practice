import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11004 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		quickSort(arr, 0, N - 1);
		
		System.out.println(arr[K - 1]);
	}
	
	private static void quickSort(int[] arr, int start, int end) {
		if(start >= end) {
			return;
		}
		int pivot = partition(arr, start, end);
		
		quickSort(arr, start, pivot);
		quickSort(arr, pivot + 1, end);
		
	}
	
	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[(start + end) / 2];
		while(true) {
			while(arr[start] < pivot) start++;
			while(arr[end] > pivot) end--;
			if(start >= end) {
				return end;
			}
			swap(arr, start++, end--);
		}
	}

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
