import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, answer;
	static int[][] initBoard;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		initBoard = new int[n][n];
		for (int i = 0 ; i < n; i ++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j ++) {
				initBoard[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		answer = Integer.MIN_VALUE;
		for (int i = 0; i < 4; i ++) {
			solve(initBoard, i, 0);
		}
		
		System.out.println(answer);
		
	}

	private static void solve(int[][] board, int dir, int cnt) {
		if (cnt == 10) {
			for (int i = 0; i < n; i ++) {
				for (int j = 0; j < n; j ++) {
					answer = Math.max(answer, board[i][j]);
				}
			}
			return;
		}
		
		int[][] newBoard = moveBoard(board, dir);
		
		for (int i = 0; i < 4; i ++) {
			solve(newBoard, i, cnt + 1);
		}
		
	}

	private static int[][] moveBoard(int[][] board, int dir) {
		int[][] newBoard = new int[n][n];
		switch (dir) {
		case 0: // 오른쪽
			for (int i = 0; i < n; i ++) {
				int idx = n - 1;
				for (int j = n - 1; j > -1; j --) {
					if (board[i][j] != 0) {
						if (newBoard[i][idx] == 0) {
							newBoard[i][idx] = board[i][j];
						} else if (newBoard[i][idx] == board[i][j]) {
							newBoard[i][idx] *= 2;
							idx --;
						} else if (newBoard[i][idx] != board[i][j]) {
							idx --;
							newBoard[i][idx] = board[i][j];
						}
					}
				}		
			}
			
			break;
		case 1: // 아래쪽
			for (int j = 0; j < n; j ++) {
				int idx = n - 1;
				for (int i = n - 1; i > -1; i --) {
					if (board[i][j] != 0) {
						if (newBoard[idx][j] == 0) {
							newBoard[idx][j] = board[i][j];
						} else if (newBoard[idx][j] == board[i][j]) {
							newBoard[idx][j] *= 2;
							idx --;
						} else if (newBoard[idx][j] != board[i][j]) {
							idx --;
							newBoard[idx][j] = board[i][j];
						}
					}		
				}
			}
			
			break;
		case 2: // 왼쪽
			for (int i = 0; i < n; i ++) {
				int idx = 0;
				for (int j = 0; j < n; j ++) {
					if (board[i][j] != 0) {
						if (newBoard[i][idx] == 0) {
							newBoard[i][idx] = board[i][j];
						} else if (newBoard[i][idx] == board[i][j]) {
							newBoard[i][idx] *= 2;
							idx ++;
						} else if (newBoard[i][idx] != board[i][j]) {
							idx ++;
							newBoard[i][idx] = board[i][j];
						}
					}
				}	
			}
			
			break;
		case 3: // 위쪽
			for (int j = 0; j < n; j ++) {
				int idx = 0;
				for (int i = 0; i < n; i ++) {
					if (board[i][j] != 0) {
						if (newBoard[idx][j] == 0) {
							newBoard[idx][j] = board[i][j];
						} else if (newBoard[idx][j] == board[i][j]) {
							newBoard[idx][j] *= 2;
							idx ++;
						} else if (newBoard[idx][j] != board[i][j]) {
							idx ++;
							newBoard[idx][j] = board[i][j];
						}
					}
				}
			}
			
			break;
		}
		
		return newBoard;
	}

}