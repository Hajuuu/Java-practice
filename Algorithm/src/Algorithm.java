import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Algorithm {
		
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		int A = 0;
		int B = 0;
		
		String str;
		
		while((str = br.readLine()).charAt(0) != '0' && str.charAt(2) != '0') {
			st = new StringTokenizer(str, " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			if(A < B) {
				if(B % A == 0)
					sb.append("factor" + "\n");
				else
					sb.append("neither" + "\n");
			}
			else if(A > B){
				if(A % B == 0)
					sb.append("multiple" + "\n");
				else
					sb.append("neither\n");
			}
		}
		System.out.println(sb);

	}	
}
