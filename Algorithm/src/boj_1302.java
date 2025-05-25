import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> books = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            books.put(name, books.getOrDefault(name, 1) + 1);
        }
        List<String> keySet = new ArrayList<>(books.keySet());

        keySet.sort((o1, o2) -> {
            if (books.get(o1) == books.get(o2)) {
                return o1.compareTo(o2);
            }
            return books.get(o2) - books.get(o1);
        });
        System.out.println(keySet.get(0));
    }

}
