import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int tc;
	static int[][] greenBoard, blueBoard; 
	static int totalPoints;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		greenBoard = new int[10][4];
		blueBoard = new int[4][10];
		
		tc = Integer.parseInt(br.readLine());
		for (int i = 1; i < tc + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			if (t == 1) {
				greenBoard[y][x] = i;
				blueBoard[y][x] = i;
			} else if (t == 2) {
				greenBoard[y][x] = i;
				greenBoard[y][x + 1] = i;
				blueBoard[y][x] = i;
				blueBoard[y][x + 1] = i;
			} else if (t == 3) {
				greenBoard[y][x] = i;
				greenBoard[y + 1][x] = i;
				blueBoard[y][x] = i;
				blueBoard[y + 1][x] = i;
			}
			
			dropBlockGreenBoard(y, x, t, i);
			dropBlockBlueBoard(y, x, t, i);
						
			while(checkRowsGreenBoard()) {	
				dropAllGreenBoard();
			}
			
			while(checkColsBlueBoard()) {
				dropAllBlueBoard();
			}
			
			int checkGreen = checkTopGreenBoard();
			int checkBlue = checkLeftBlueBoard();
			
			if (checkGreen != 0) {
				popAndMoveDownGreenBoard(checkGreen);
			}
			
			if (checkBlue != 0) {
				popAndMoveRightBlueBoard(checkBlue);
			}
			
		}
				
		int cnt = 0;
		
		for (int i = 4; i < 10; i ++) {
			for (int j = 0; j < 4; j ++) {
				if (greenBoard[i][j] != 0) {
					cnt ++;
				}
			}
		}
		
		for (int j = 4; j < 10; j ++) {
			for (int i = 0; i < 4; i ++) {
				if (blueBoard[i][j] != 0) {
					cnt ++;
				}
			}
		}
		
		sb.append(totalPoints).append("\n").append(cnt);
		
		
		System.out.println(sb);
		

	}
	
	
	static void dropBlockGreenBoard(int y, int x, int t, int idx) {
		if (t == 1) {
			while (y + 1 < 10 && greenBoard[y + 1][x] == 0) {
				greenBoard[y][x] = 0;
				greenBoard[y + 1][x] = idx;
				y += 1;
			}
		} else if (t == 2) {
			while (y + 1 < 10 && greenBoard[y + 1][x] == 0 && greenBoard[y + 1][x + 1] == 0) {
				greenBoard[y][x] = 0;
				greenBoard[y][x + 1] = 0;
				greenBoard[y + 1][x] = idx;
				greenBoard[y + 1][x + 1] = idx;
				y += 1;
			}
		} else if (t == 3) {
			y += 1;
			greenBoard[y - 1][x] = 0;
			while (y + 1 < 10 && greenBoard[y + 1][x] == 0) {
				greenBoard[y][x] = 0;
				greenBoard[y + 1][x] = idx;
				y += 1;
			}
			greenBoard[y - 1][x] = idx;
		}
	}
	
	static void dropBlockBlueBoard(int y, int x, int t, int idx) {
		if (t == 1) {
			while (x + 1 < 10 && blueBoard[y][x + 1] == 0) {
				blueBoard[y][x] = 0;
				blueBoard[y][x + 1] = idx;
				x += 1;
			}
		} else if (t == 2) {
			x += 1;
			blueBoard[y][x - 1] = 0;
			while (x + 1 < 10 && blueBoard[y][x + 1] == 0) {
				blueBoard[y][x] = 0;
				blueBoard[y][x + 1] = idx;
				x += 1;
			}
			blueBoard[y][x - 1] = idx;
		} else if (t == 3) {
			while (x + 1 < 10 && blueBoard[y][x + 1] == 0 && blueBoard[y + 1][x + 1] == 0) {
				blueBoard[y][x] = 0;
				blueBoard[y + 1][x] = 0;
				blueBoard[y][x + 1] = idx;
				blueBoard[y + 1][x + 1] = idx;
				x += 1;
			}	
		}
	}
	
	static void dropAllGreenBoard() {
		List<Integer> visited = new ArrayList<>();
		for (int i = 9; i > 3; i --) {
			for (int j = 0; j < 4; j ++) {
				int idx = greenBoard[i][j];
				if (idx != 0 && !visited.contains(idx)) {
					visited.add(idx);
					int t = 1;
					int y = i;
					int x = j;
					if (j + 1 < 4 && greenBoard[i][j + 1] == idx) {
						t = 2;
					} else if (greenBoard[i - 1][j] == idx) {
						y = i - 1;
						t = 3;
					}
					dropBlockGreenBoard(y, x, t, idx);
				}
			}
		}
	}
	
	static void dropAllBlueBoard() {
		List<Integer> visited = new ArrayList<>();
		for (int j = 9; j > 3; j --) {
			for (int i = 0; i < 4; i ++) {
				int idx = blueBoard[i][j];
				if (idx != 0 && !visited.contains(idx)) {
					visited.add(idx);
					int t = 1;
					int y = i;
					int x = j;
					if (blueBoard[i][j - 1] == idx) {
						x = j - 1;
						t = 2;
					} else if (i + 1 < 4 && blueBoard[i + 1][j] == idx) {
						t = 3;
					}
					dropBlockBlueBoard(y, x, t, idx);
				}
			}
		}
		
	}
	
	static void popAndMoveDownGreenBoard(int cnt) {
		for (int i = 9 - cnt; i > 3; i --) {
			for (int j = 0; j < 4; j ++) {
				greenBoard[i + cnt][j] = greenBoard[i][j];
				greenBoard[i][j] = 0;
			}
		}
		 
	}
	
	static void popAndMoveRightBlueBoard(int cnt) {
		for (int j = 9 - cnt; j > 3; j --) {
			for (int i = 0; i < 4; i ++) {
				blueBoard[i][j + cnt] = blueBoard[i][j];
				blueBoard[i][j] = 0;
			}
		}
		
	}
	
	static int checkTopGreenBoard() {
		int cnt = 0;
		for (int i = 4; i < 6; i ++) {
			for (int j = 0; j < 4; j ++) {
				if (greenBoard[i][j] != 0) {
					cnt ++;
					break;
				}
			}

		}
		
		return cnt;
		
	}
	
	static int checkLeftBlueBoard() {
		int cnt = 0;
		for (int j = 4; j < 6; j ++) {
			for (int i = 0; i < 4; i ++) {
				if (blueBoard[i][j] != 0) {
					cnt ++;
					break;
				}
				
			}
		}
		
		return cnt;
		
	}
	
	static boolean checkRowsGreenBoard() {
		boolean flag = false;
		
		for (int i = 6; i < 10; i ++) {
			int rowCnt = 0;
			for (int j = 0; j < 4; j ++) {
				if (greenBoard[i][j] != 0) {
					rowCnt ++;
				}
			}
			
			if (rowCnt == 4) {
				flag = true;
				totalPoints ++;
				for (int j = 0; j < 4; j ++) {
					greenBoard[i][j] = 0;
				}
			}
			
		}
		
		return flag;
		
	}
	
	static boolean checkColsBlueBoard() {
		boolean flag = false;
		
		for (int j = 6; j < 10; j ++) {
			int colCnt = 0;
			for (int i = 0; i < 4; i++) {
				if (blueBoard[i][j] != 0) {
					colCnt ++;
				}
			}
			
			if (colCnt == 4) {
				flag = true;
				totalPoints ++;
				for (int i = 0; i < 4; i ++) {
					blueBoard[i][j] = 0;
				}
			}
		}
		
		return flag;
		
	}

}