import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Algorithm {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuffer a = new StringBuffer(st.nextToken());
		StringBuffer b = new StringBuffer(st.nextToken());
		
		int A = Integer.parseInt(a.reverse().toString());
		int B  = Integer.parseInt(b.reverse().toString());
		if(A > B)
			System.out.println(A);
		else
			System.out.println(B);
	}
	
}
