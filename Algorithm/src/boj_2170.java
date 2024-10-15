import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2170 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		int[][] arr = new int[N][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, (o1, o2) -> {
			if(o1[0] == o2[0]) {
				return o1[1] - o2[1];
			} else {
				return o1[0] - o2[0];
			}
		});
		
		int line = arr[0][1]- arr[0][0];
		int start = arr[0][0];
		int end = arr[0][1];
		for(int i = 1; i < N; i++) {
			int nowS = arr[i][0];
			int nowE = arr[i][1];
			if(nowS <= end && nowE <= end) {
				continue;
			}
			if(nowS <= end && nowE > end) {
				line += nowE - end;
			}
			if(nowS > end) {
				line += nowE - nowS;
			}
			start = nowS;
			end = nowE;
		}
		
		System.out.println(line);
	} 

}
