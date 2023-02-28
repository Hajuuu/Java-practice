import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Algorithm {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		String str = "";
		for(int i = 0; i < T; i++) {
			str = br.readLine();
			sb.append(str.charAt(0)).append(str.charAt(str.length()-1)).append("\n");
		}
		System.out.println(sb);
	}
	
}
