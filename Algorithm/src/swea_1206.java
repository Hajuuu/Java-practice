import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1206 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int count = 0;
			for(int i = 2; i < N - 2; i++) {
				int min = Integer.MAX_VALUE;
				if(arr[i - 2] < arr[i] && arr[i - 1] < arr[i] && arr[i + 1] < arr[i] && arr[i + 2] < arr[i]) {
					min = Math.min(min, (arr[i] - arr[i - 2]));
					min = Math.min(min, (arr[i] - arr[i - 1]));
					min = Math.min(min, (arr[i] - arr[i + 1]));
					min = Math.min(min, (arr[i] - arr[i + 2]));
					count += min;
				}
				
			}
			
			sb.append("#" + t + " " + count + "\n");
		}
		
		System.out.println(sb);
		

	}

}
