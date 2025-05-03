import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<List<Node>> nodeList;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        nodeList = new ArrayList<>();
        distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int i = 0; i <= V; i++) {
            nodeList.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            nodeList.get(u).add(new Node(v, w));
        }

        dijkstra(K);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
                continue;
            }
            sb.append(distance[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));
        queue.offer(new Node(start, 0));
        distance[start] = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (distance[node.num] < node.value) {
                continue;
            }
            for (Node n : nodeList.get(node.num)) {
                if (distance[n.num] > distance[node.num] + n.value) {
                    distance[n.num] = distance[node.num] + n.value;
                    queue.offer(new Node(n.num, distance[n.num]));
                }

            }
        }
    }
}

class Node {
    int num;
    int value;

    Node(int num, int value) {
        this.num = num;
        this.value = value;
    }
}
