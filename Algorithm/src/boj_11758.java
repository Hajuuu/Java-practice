import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_11758 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		List<Point3> p = new ArrayList<>();
		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			p.add(new Point3(x, y));
		}
		
		int outerProduct = (p.get(1).x - p.get(0).x) * (p.get(2).y - p.get(0).y) - (p.get(2).x - p.get(0).x) * (p.get(1).y - p.get(0).y);
		
		if(outerProduct < 0) {
			System.out.println(-1);
		} else if(outerProduct == 0) {
			System.out.println(0);
		} else {
			System.out.println(1);
		}
	}

}

class Point3 {
	int x;
	int y;
	
	Point3(int x, int y) {
		this.x = x;
		this.y = y;
	}
}