import sys

input = sys.stdin.readline


string1 = input().strip()
string2 = input().strip()

r = len(string1)
c = len(string2)

dp = [[0] * (c + 1) for _ in range(r + 1)]

answer = 0

for i in range(1, r + 1):
    for j in range(1, c + 1):
        if string1[i - 1] == string2[j - 1]:
            dp[i][j] = dp[i - 1][j - 1] + 1
            answer = max(answer, dp[i][j])
        else:
            dp[i][j] = 0

print(answer)