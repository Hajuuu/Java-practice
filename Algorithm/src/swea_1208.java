import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_1208 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= 10; t++) {
			int dump = Integer.parseInt(br.readLine());
			int[] arr = new int[100];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			for(int i = 0; i < dump; i++) {
				arr[0]++;
				arr[99]--;
				Arrays.sort(arr);
			}
			int answer = arr[99] - arr[0];
			sb.append("#" + t + " " + answer + "\n");
		}
		
		System.out.println(sb);
	}

}
