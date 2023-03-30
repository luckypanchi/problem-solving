import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

enum ObjectItem {
	HR, RE, CO, EX, DX, HU, CU;
}

class User {

	int y, x;
	//현재레벨
	int level;
	//현재체력
	int remHp;
	//최대체력
	int maxHp;
	//공격력
	int att;
	//방어력
	int def;
	//경험치
	int currExp;
	//최대 경험치
	int maxExp;
	//무기
	int weapon;
	//방어구
	int armor;
	//장신구
	List<ObjectItem> objectItemList;

	int totalAtt;
	int totalDef;

	public User(int y, int x) {
		this.y = y;
		this.x = x;
		this.level = 1;
		this.remHp = 20;
		this.maxHp = 20;
		this.att = 2;
		this.def = 2;
		this.currExp = 0;
		this.maxExp = 5;
		this.weapon = 0;
		this.armor = 0;
		this.objectItemList = new ArrayList<>();
		setTotalAtt();
		setTotalDef();
	}

	public void levelUp() {
		this.level += 1;
		this.maxHp += 5;
		this.remHp = this.maxHp;
		this.att += 2;
		this.def += 2;
		this.currExp = 0;
		this.maxExp = this.level * 5;
		setTotalAtt();
		setTotalDef();
	}

	public void gainExp(int exp) {
		currExp += exp;
		if (maxExp <= currExp) {
			levelUp();
		}
	}

	public void gainObjectItem(ObjectItem objectItem) {
		if (this.objectItemList.size() < 4 && !this.objectItemList.contains(objectItem)) {
			this.objectItemList.add(objectItem);
		}
	}

	public void setTotalAtt() {
		this.totalAtt = this.att + this.weapon;
	}

	public void setTotalDef() {
		this.totalDef = this.def + this.armor;
	}

	public void setNewWeapon(int w) {
		this.weapon = w;
		setTotalAtt();
	}

	public void setNewArmor(int a) {
		this.armor = a;
		setTotalDef();
	}

}

class Monster {

	int y, x;
	String name;
	int att, def, hp, exp, maxHp;
	boolean isBoss;

	public Monster(int y, int x, boolean isBoss) {
		this.y = y;
		this.x = x;
		this.isBoss = isBoss;
	}

}

class Item {

	String type; //W, A, O
	int value;
	ObjectItem objectItem;

	public Item() {
	}

}


public class Main {

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int r, c, turns, startY, startX;
	static char[][] board;
	static int[] moves;
	static Monster[][] monsterMap;
	static Item[][] itemMap;
	static User user;

	public static void main(String[] args) throws IOException {

		getInput();

		for (int i = 0; i < moves.length; i++) {

			int m = moves[i];
			int nx = user.x + dx[m];
			int ny = user.y + dy[m];
			if (0 <= ny && ny < r && 0 <= nx && nx < c && board[ny][nx] != '#') {
				user.y = ny;
				user.x = nx;
			}

			action(user.y, user.x);

			turns++;

		}

		printResult("Press any key to continue.", true);

	}

	private static void action(int y, int x) {
		switch (board[y][x]) {
			case 'B':
				Item item = itemMap[y][x];
				getNewItem(y, x, item);
				break;
			case '^':
				stepOnTrap();
				break;
			case '&':
			case 'M':
				Monster monster = monsterMap[y][x];
				fightMonster(y, x, monster);
				break;
		}
	}

	private static void getNewItem(int y, int x, Item item) {

		if (item.type.equals("W")) {
			user.setNewWeapon(item.value);
		} else if (item.type.equals("A")) {
			user.setNewArmor(item.value);
		} else if (item.type.equals("O")) {
			user.gainObjectItem(item.objectItem);
		}
		board[y][x] = '.';
	}

	private static void stepOnTrap() {
		if (user.objectItemList.contains(ObjectItem.DX)) {
			user.remHp -= 1;
		} else {
			user.remHp -= 5;
		}
		if (user.remHp <= 0) {
			user.remHp = 0;
			if (user.objectItemList.contains(ObjectItem.RE)) {
				user.objectItemList.remove(ObjectItem.RE);
				user.remHp = user.maxHp;
				user.y = startY;
				user.x = startX;
			} else {
				turns++;
				printResult(String.format("YOU HAVE BEEN KILLED BY %s..", "SPIKE TRAP"), false);
				System.exit(0);
			}
		}
	}

	private static void afterBattleWin(Monster monster) {
		if (user.objectItemList.contains(ObjectItem.HR)) {
			user.remHp = Math.min(user.remHp + 3, user.maxHp);
		}
		if (user.objectItemList.contains(ObjectItem.EX)) {
			user.gainExp((int) (1.2 * monster.exp));
		} else {
			user.gainExp(monster.exp);
		}
	}

	private static void fightMonster(int y, int x, Monster monster) {
		int c = 1;
		if (user.objectItemList.contains(ObjectItem.CO)) {
			if (user.objectItemList.contains(ObjectItem.DX)) {
				c = 3;
			} else {
				c = 2;
			}
		}
		monster.hp -= Math.max(1, c * user.totalAtt - monster.def);

		if (user.objectItemList.contains(ObjectItem.HU) && monster.isBoss) {
			user.remHp = user.maxHp;
			if (0 < monster.hp) {
				user.remHp += Math.max(1, monster.att - user.totalDef); //보스의 첫 공격은 0
			}
		}

		int t = 0;//0: 몬스터 공격, 1: 주인공 공격

		while (0 < user.remHp && 0 < monster.hp) {
			if (t == 0) {
				user.remHp -= Math.max(1, monster.att - user.totalDef);
			} else {
				monster.hp -= Math.max(1, user.totalAtt - monster.def);
			}
			t = 1 - t;
		}

		if (user.remHp <= 0) {
			user.remHp = 0;
			if (user.objectItemList.contains(ObjectItem.RE)) {
				user.objectItemList.remove(ObjectItem.RE);
				user.remHp = user.maxHp;
				user.y = startY;
				user.x = startX;
				monster.hp = monster.maxHp;
			} else {
				turns++;
				printResult(String.format("YOU HAVE BEEN KILLED BY %s..", monster.name), false);
				System.exit(0);
			}
		} else {
			afterBattleWin(monster);
			board[y][x] = '.';
			if (monster.isBoss) {
				turns++;
				printResult("YOU WIN!", true);
				System.exit(0);
			}
		}

	}

	private static void getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		board = new char[r][c];
		monsterMap = new Monster[r][c];
		itemMap = new Item[r][c];

		int monsterCnt = 0;
		int itemCnt = 0;

		for (int i = 0; i < r; i++) {
			String row = br.readLine();
			for (int j = 0; j < c; j++) {
				board[i][j] = row.charAt(j);
				if (board[i][j] == '&') {
					monsterMap[i][j] = new Monster(i, j, false);
					monsterCnt++;
				} else if (board[i][j] == 'M') {
					monsterMap[i][j] = new Monster(i, j, true);
					monsterCnt++;
				} else if (board[i][j] == 'B') {
					itemMap[i][j] = new Item();
					itemCnt++;
				} else if (board[i][j] == '@') {
					user = new User(i, j);
					board[i][j] = '.';
					startY = i;
					startX = j;
				}
			}
		}

		String ms = br.readLine();
		moves = new int[ms.length()];
		for (int i = 0; i < ms.length(); i++) {
			char m = ms.charAt(i);
			if (m == 'R') {
				moves[i] = 0;
			} else if (m == 'D') {
				moves[i] = 1;
			} else if (m == 'L') {
				moves[i] = 2;
			} else if (m == 'U') {
				moves[i] = 3;
			}
		}

		for (int i = 0; i < monsterCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			Monster monster = monsterMap[y][x];
			monster.name = st.nextToken();
			monster.att = Integer.parseInt(st.nextToken());
			monster.def = Integer.parseInt(st.nextToken());
			monster.hp = Integer.parseInt(st.nextToken());
			monster.exp = Integer.parseInt(st.nextToken());
			monster.maxHp = monster.hp;
		}

		for (int i = 0; i < itemCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			Item item = itemMap[y][x];
			item.type = st.nextToken();
			if (item.type.equals("O")) {
				item.objectItem = ObjectItem.valueOf(st.nextToken());
			} else {
				item.value = Integer.parseInt(st.nextToken());
			}
		}
	}

	private static void printResult(String msg, boolean alive) {
		StringBuilder sb = new StringBuilder();
		if (alive) {
			board[user.y][user.x] = '@';
		}
		for (int i = 0; i < r; i++) {
			sb.append(String.valueOf(board[i])).append("\n");
		}
		sb.append(String.format("Passed Turns : %d\n", turns));
		sb.append(String.format("LV : %d\n", user.level));
		sb.append(String.format("HP : %d/%d\n", user.remHp, user.maxHp));
		sb.append(String.format("ATT : %d+%d\n", user.att, user.weapon));
		sb.append(String.format("DEF : %d+%d\n", user.def, user.armor));
		sb.append(String.format("EXP : %d/%d\n", user.currExp, user.maxExp));
		sb.append(msg);

		System.out.println(sb);
	}

}