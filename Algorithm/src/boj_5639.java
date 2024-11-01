import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_5639 {

	static StringBuilder sb = new StringBuilder();
	static Node1[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int root = Integer.parseInt(br.readLine());
		tree = new Node1[1000001];
		int parent = root;
		tree[root] = new Node1(root);
		String str = "";
		while((str = br.readLine()) != null && !str.isEmpty()) {
			int num = Integer.parseInt(str);
			if(num < root) {
				if(parent > num) {
					tree[num] = new Node1(num);
					tree[parent].left = tree[num];
					tree[num].parent = tree[parent];
					parent = num;
				}
				
				if(parent < num) {
					Node1 p = tree[parent].parent;
					tree[num] = new Node1(num);
					tree[p.value].right = tree[num];
					parent = p.value;
				}
			}
			if(num > root) {
				if(parent > num) {
					tree[num] = new Node1(num);
					tree[parent].left = tree[num];
					tree[num].parent = tree[parent];
					parent = num;
				}
				if(parent < num) {
					tree[num] = new Node1(num);
					if(tree[parent].parent.value > num) {
						tree[parent].parent.right = tree[num];
					}
					else {
						tree[parent].right = tree[num];
					}
				}
			}
			
		}
		postOrder(tree[root]);
		System.out.println(tree[root].left.value);
		System.out.println(sb);
	}
	
	public static void postOrder(Node1 node) {
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.value);
	}

}

class Node1 {
	
	int value;
	Node1 left;
	Node1 right;
	Node1 parent;
	
	Node1(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
}
