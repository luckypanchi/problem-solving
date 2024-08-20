class Solution {

  char[] friends;
  int[] position;
  boolean[] isSelected;
  int n, answer;
  String[] data;

  public int solution(int n, String[] data) {
    friends = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    position = new int[26];
    isSelected = new boolean[8];
    this.n = n;
    this.data = data;
    answer = 0;

    permutation(0);

    return answer;
  }

  private void permutation(int curr) {
    if (curr == 8) {
      if (check()) {
        answer++;
      }
      return;
    }

    for (int i = 0; i < 8; i++) {
      if (!isSelected[i]) {
        isSelected[i] = true;
        position[friends[i] - 'A'] = curr;
        permutation(curr + 1);
        isSelected[i] = false;
      }
    }
  }

  private boolean check() {
    for (String condition : data) {
      char c1 = condition.charAt(0);
      char c2 = condition.charAt(2);
      char op = condition.charAt(3);
      int gap = condition.charAt(4) - '0' + 1;

      int dist = Math.abs(position[c1 - 'A'] - position[c2 - 'A']);

      if (op == '=' && dist != gap) {
        return false;
      } else if (op == '>' && dist <= gap) {
        return false;
      } else if (op == '<' && dist >= gap) {
        return false;
      }
    }

    return true;
  }
}
