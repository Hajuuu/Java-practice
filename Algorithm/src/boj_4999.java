import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_4999 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = count(br.readLine());
		int b = count(br.readLine());
		
		if(a >= b) {
			System.out.println("go");
		} else {
			System.out.println("no");
		}
	}
	
	public static int count(String str) {
		int i = 0;
		while(true) {
			if(str.charAt(i) == 'h') {
				return i;
			}
			i++;
		}
	}

}
