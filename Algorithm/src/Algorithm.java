import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		// 시간 복잡도 O(N^3)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Integer.parseInt(br.readLine());
		System.out.println(n * (n - 1) * (n - 2) / 6);
		System.out.println(3);
		    
	}
}
