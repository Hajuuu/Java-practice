import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2750 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N - 1 - i; j++) {
				if(arr[j] > arr[j + 1]) {
					int num = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = num;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			sb.append(arr[i] + "\n");
		}
		
		System.out.println(sb);
	}

}
