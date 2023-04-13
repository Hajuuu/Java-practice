import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		
		String AB = str[0] + str[1];
		String CD = str[2] + str[3];
		
		long sum = Long.parseLong(AB) + Long.parseLong(CD);
		
		System.out.println(sum);
 	}
	
	
} 
