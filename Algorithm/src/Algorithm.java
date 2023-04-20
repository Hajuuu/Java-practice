import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int E = Integer.parseInt(st.nextToken()) % 15;
		int S = Integer.parseInt(st.nextToken()) % 28;
		int M = Integer.parseInt(st.nextToken()) % 19;
		int year = 1;
		while(!((year % 15 == E) && (year % 28 == S) && (year % 19 == M))) {
			year++;
		}
		
		System.out.println(year);
	}
} 
