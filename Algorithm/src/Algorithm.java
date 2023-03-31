import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= 1000; i++) {
			for(int j = 0; j <= 1000; j++) {
				if((3 * i + 5 * j) == N) {
					System.out.println(i + j);
					return;
				}
			}
		}
		
		System.out.println(-1);
		
	}
	
} 
