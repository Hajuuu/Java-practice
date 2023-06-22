import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1924 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		int n = y;
		for(int i = 0; i < x - 1; i++) {
			n += month[i];
		}
		
		System.out.println(day[n % 7]);
	}

}
