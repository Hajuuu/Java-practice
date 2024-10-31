import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2166 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Point2166[] poly = new Point2166[N + 1];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			poly[i] = new Point2166(x, y);
		}
		poly[N] = new Point2166(poly[0].x, poly[0].y);
		long sum1 = 0;
		long sum2 = 0;
		for(int i = 0; i < N; i++) {
			sum1 += poly[i].x * poly[i + 1].y;
			sum2 += poly[i].y * poly[i + 1].x;
		}
		double answer = Math.abs(sum1 - sum2) / 2.0;
		System.out.printf("%.1f", answer);
	}

}

class Point2166 {
	long x;
	long y;

	Point2166(long x, long y) {
		this.x = x;
		this.y = y;
	}
}
