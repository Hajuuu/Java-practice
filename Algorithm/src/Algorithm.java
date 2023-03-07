import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Algorithm {
		
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double total = 0;
		double sum = 0;
		for(int i = 0; i < 20; i++) {
			String[] grade = br.readLine().split(" ");
			if(!grade[2].equals("P")) {
				total += Double.parseDouble(grade[1]);
			}
			
			if(grade[2].equals("A+")) {
				sum += 4.5 * Double.parseDouble(grade[1]);
			}
			else if(grade[2].equals("A0")) {
				sum += 4.0 * Double.parseDouble(grade[1]);
			}
			else if(grade[2].equals("B+")) {
				sum += 3.5 * Double.parseDouble(grade[1]);
			}
			else if(grade[2].equals("B0")) {
				sum += 3.0 * Double.parseDouble(grade[1]);
			}
			else if(grade[2].equals("C+")) {
				sum += 2.5 * Double.parseDouble(grade[1]);
			}
			else if(grade[2].equals("C0")) {
				sum += 2.0 * Double.parseDouble(grade[1]);
			}
			else if(grade[2].equals("D+")) {
				sum += 1.5 * Double.parseDouble(grade[1]);
			}
			else if(grade[2].equals("D0")) {
				sum += 1.0 * Double.parseDouble(grade[1]);
			}
			else if(grade[2].equals("F")) {
				sum += 0;
			}
			
		}
		System.out.println(sum / total);
	}
	
	
}
