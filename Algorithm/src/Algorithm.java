import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Algorithm {
		
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int count = 1;
		int range = 2;
		
		if(N == 1) {
			System.out.print(1);
		}
		else {
			while(range <= N) {
				range = range + (6 * count);
				count++;
			}
			
			System.out.print(count);
		}
				
		
	}	
}
