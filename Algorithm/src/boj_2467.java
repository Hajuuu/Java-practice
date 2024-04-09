import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2467 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = N - 1;
		int min = Math.abs(arr[left] + arr[right]);
		int water1 = arr[left];
		int water2 = arr[right];
		while(left < right) {
			if(Math.abs(arr[left] + arr[right]) < min) {
				water1 = arr[left];
				water2 = arr[right];
				min = Math.abs(arr[left] + arr[right]);
			}
			if(arr[left] + arr[right] < 0) {
				left += 1;
				continue;
			}
			if(arr[left] + arr[right] > 0) {
				right -= 1;
				continue;
			}
			if(arr[left] + arr[right] == 0) {
				water1 = arr[left];
				water2 = arr[right];
				break;
			}
		}
		System.out.println(water1 + " " + water2);
		
	}

}
