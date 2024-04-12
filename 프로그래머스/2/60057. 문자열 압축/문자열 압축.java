class Solution {
	public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int maxLength = s.length() / 2;
        for (int length = 1; length < Math.max(1, maxLength) + 1; length++) {
            answer = Math.min(answer, solve(s, length));
        }

        return answer;
    }

    private static int solve(String s, int length) {
        StringBuilder sb = new StringBuilder();
        String curr = s.substring(0, length);
        int count = 1;
        for (int next = length; next < s.length(); next += length) {
            String nextString = s.substring(next, Math.min(next + length, s.length()));
            if (curr.equals(nextString)) {
                count += 1;
            } else {
                if (count != 1) {
                    sb.append(count);
                }
                sb.append(curr);
                count = 1;
                curr = nextString;
            }
        }

        if (count != 1) {
            sb.append(count);
        }
        sb.append(curr);
        return sb.toString().length();
    }
}