import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_10815 {

	static ArrayList<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		int[] arr = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			if(binary_search(arr[i], 0, N - 1) < 0) {
				sb.append(0 + " ");
			} else {
				sb.append(1 + " ");
			}
		}
		System.out.println(sb);
	}
	
	static int binary_search(int key, int low, int high) {
		int mid;
		while(low <= high) {
			mid = (low + high) / 2;
			if(key == list.get(mid)) {
				return 1;
			} else if(key < list.get(mid)) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

}
