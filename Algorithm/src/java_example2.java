import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class java_example2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		System.out.println(multiple(a, b));
		
	}
	
	public static int multiple(int a, int b) {
		int num = 0;
		for(int i = 1; i < 1000; i++) {
			if(i % a == 0 || i % b == 0) {
				num += i;
			}
		}
		
		return num;
	}
}
