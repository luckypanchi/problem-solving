import sys
from collections import Counter

input = sys.stdin.readline

MOD = 1000000


t, a, s, b = map(int, input().split())
counter = Counter(list(map(int, input().split())))

dp = [[0] * (a + 1) for _ in range(t + 1)]
dp[0][0] = 1

for n in range(1, t + 1):
    for i in range(1, counter[n] + 1):
        dp[n][i] += 1

    for i in range(a + 1):
        dp[n][i] += dp[n - 1][i]
        for j in range(1, counter[n] + 1):
            if i - j > 0:
                dp[n][i] += dp[n - 1][i - j]
                dp[n][i] %= MOD

answer = 0
for i in range(s, b + 1):
    answer += dp[t][i]
    answer %= MOD

print(answer)