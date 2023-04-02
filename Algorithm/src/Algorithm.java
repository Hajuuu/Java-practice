import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split("");
		StringBuffer sb = new StringBuffer();
		
		Arrays.sort(arr, Comparator.reverseOrder());
		for(String s : arr) {
			sb.append(s);
		}
		System.out.println(sb);
	}
	
} 
