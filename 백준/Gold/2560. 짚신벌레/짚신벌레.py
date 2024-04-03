import sys

input = sys.stdin.readline

DIV = 1000


a, b, d, n = map(int, input().split())
dp = [0] * (n + 1)
dp[0] = 1

for day in range(1, n + 1):
    dp[day] = dp[day - 1]
    if a <= day:
        dp[day] = (dp[day] + dp[day - a]) % DIV
    if b <= day:
        dp[day] = (dp[day] - dp[day - b] + DIV) % DIV

answer = dp[n]
if d <= n:
    answer = (answer - dp[n - d] + DIV) % DIV

print(answer)