import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		Tree head = new Tree("A");
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			String c = st.nextToken();
			Tree tmp = head.getSubTree(a);
			if (!b.equals(".")) {
				tmp.left = new Tree(b);
			}
			if (!c.equals(".")) {
				tmp.right = new Tree(c);
			}
		}

		head.preorder();
		sb.append("\n");
		head.inorder();
		sb.append("\n");
		head.postorder();
		System.out.println(sb);
	}

	static class Tree {

		String curr;
		Tree left;
		Tree right;

		public Tree(String curr) {
			this.curr = curr;
			this.left = null;
			this.right = null;
		}

		public Tree getSubTree(String target) {
			Tree found = null;
			if (this.curr.equals(target)) {
				found = this;
			}
			if (found == null && this.left != null) {
				found = this.left.getSubTree(target);
			}
			if (found == null && this.right != null) {
				found = this.right.getSubTree(target);
			}
			return found;
		}

		public void preorder() {
			sb.append(this.curr);
			if (this.left != null) {
				this.left.preorder();
			}
			if (this.right != null) {
				this.right.preorder();
			}
		}

		public void inorder() {
			if (this.left != null) {
				this.left.inorder();
			}
			sb.append(this.curr);
			if (this.right != null) {
				this.right.inorder();
			}
		}

		public void postorder() {
			if (this.left != null) {
				this.left.postorder();
			}
			if (this.right != null) {
				this.right.postorder();
			}
			sb.append(this.curr);

		}
	}
}