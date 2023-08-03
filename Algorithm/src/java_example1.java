import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class java_example1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] result = gugu(N);
		for(int i = 0; i < 9; i++) {
			sb.append(result[i] + "\n");
		}
		System.out.println(sb);
		
	}
	
	public static int[] gugu(int num) {
		int[] gugudan = new int[9];
		for(int i = 0; i < 9; i++) {
			gugudan[i] = num * (i + 1);
		}
		return gugudan;
	}

}
