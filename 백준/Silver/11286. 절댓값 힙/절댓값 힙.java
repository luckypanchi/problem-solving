import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {

	int number;
	int absNumber;

	public Node(int number, int absNumber) {
		this.number = number;
		this.absNumber = absNumber;
	}

	@Override
	public int compareTo(Node other) {
		if (this.absNumber != other.absNumber) {
			return this.absNumber - other.absNumber;
		}
		return this.number - other.number;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int number = Integer.parseInt(br.readLine());
			if (number != 0) {
				priorityQueue.offer(new Node(number, Math.abs(number)));
			} else {
				if (priorityQueue.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(priorityQueue.poll().number).append("\n");
				}
			}
		}
		System.out.println(sb);

	}
}