import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Node {
    int y, x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}


class Group implements Comparable<Group> {
    List<Node> nodeList;
    Node pivot;
    int rainbowCnt;

    public Group() {
        nodeList = new ArrayList<>();
        pivot = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);
        rainbowCnt = 0;
    }

    public void setPivot(Node node) {
        this.pivot = node;
    }

    public Node getPivot() {
        return this.pivot;
    }

    public void put(Node node) {
        this.nodeList.add(node);

    }

    public int size() {
        return this.nodeList.size();
    }

    @Override
    public int compareTo(Group other) {
        if(this.size() != other.size()) return this.size() - other.size();
        if(this.rainbowCnt != other.rainbowCnt) return this.rainbowCnt - other.rainbowCnt;

        Node pivot = this.getPivot();
        Node otherPivot = other.getPivot();

        if(pivot.y != otherPivot.y) return pivot.y - otherPivot.y;
        return pivot.x - otherPivot.x;
    }
}

public class Main {

    static final int BLANK = 10;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int n, m;
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        while(true) {
            Group targets = findBiggestGroup();
            if(targets.size() == 0) break;
            answer += popBlocks(targets);
            drop();
            rotate();
            drop();
        }

        System.out.println(answer);
    }

    static Group findBiggestGroup() {
        Group targets = new Group();
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(0 < board[i][j] && board[i][j] <= m && !visited[i][j]) {
                    Group found = findGroup(i, j);
                    if(found.size() > 1 && targets.compareTo(found) < 0) targets = found;
                }
            }
        }

        return targets;
    }

    static Group findGroup(int sy, int sx) {
        boolean[][] localVisited = new boolean[n][n];
        Group found = new Group();
        Deque<Node> que = new ArrayDeque<>();

        Node nd = new Node(sy, sx);
        found.put(nd);
        found.setPivot(nd);
        que.add(nd);

        localVisited[sy][sx] = true;
        visited[sy][sx] = true;

        while(!que.isEmpty()) {
            Node node = que.pollFirst();
            for(int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
                if(0 <= ny && ny < n && 0 <= nx && nx < n) {
                    if((board[ny][nx] == 0 || board[ny][nx] == board[sy][sx]) && !localVisited[ny][nx] && !visited[ny][nx]) {
                        nd = new Node(ny, nx);
                        found.put(nd);
                        que.add(nd);
                        localVisited[ny][nx] = true;
                        if(board[ny][nx] != 0) {
                            visited[ny][nx] = true;
                        } else {
                            found.rainbowCnt ++;
                        }
                    }
                }
            }
        }
        return found;
    }

    static int popBlocks(Group targets) {
        for (Node node : targets.nodeList) {
            board[node.y][node.x] = BLANK;
        }
        return (int)Math.pow(targets.size(), 2);
    }

    static void drop() {
        for(int j = 0; j < n; j++) {
            for(int i = n - 1; i > 0; i--) {
                if(board[i][j] == BLANK) {
                    for(int k = i - 1; k > -1; k--) {
                        if(board[k][j] == -1) break;
                        if(board[k][j] != BLANK) {
                            board[i][j] = board[k][j];
                            board[k][j] = BLANK;
                            break;
                        }
                    }
                }
            }
        }
    }

    static void rotate() {
        int[][] newBoard = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                newBoard[n - 1 - j][i] = board[i][j];
            }
        }

        board = newBoard;
    }
}
