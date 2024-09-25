import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String num = br.readLine();
			if(Integer.parseInt(num) == 0) {
				break;
			}
			
			StringBuffer bf = new StringBuffer(num);
			String reverse = bf.reverse().toString();
		
			if(num.equals(reverse)) {
				sb.append("yes\n");
			} else {
				sb.append("no\n");
			}
		}
		System.out.println(sb);
	}

}
