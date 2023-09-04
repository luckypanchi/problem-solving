import sys

input = sys.stdin.readline

MOD = 1000000000


n = int(input())

dp = [[[0] * (1 << 10) for _ in range(10)] for _ in range(n + 1)]

for i in range(10):
    dp[1][i][1 << i] = 1

for depth in range(2, n + 1):
    for i in range(10):
        for k in range(1 << 10):
            for j in [i + 1, i - 1]:
                if 0 <= j < 10:
                    dp[depth][i][(1 << i) | k] += dp[depth - 1][j][k]
                dp[depth][i][(1 << i) | k] %= MOD


answer = 0
for i in range(1, 10):
    answer += dp[n][i][(1 << 10) - 1]
    answer %= MOD

print(answer)