import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		// O(N^3)의 시간 복잡도
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger n = new BigInteger(br.readLine());
		System.out.println(n.multiply(n.multiply(n)));
		System.out.println(3);
		    
	}
}
