import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<String> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String log = st.nextToken();
            if(log.equals("enter")) {
                list.add(name);
            }
            if(log.equals("leave")) {
                list.remove(name);
            }
        }

        StringBuffer sb = new StringBuffer();
        list.sort(Comparator.reverseOrder());
        for(String name : list) {
            sb.append(name + "\n");
        }
        System.out.println(sb);
    }
}
