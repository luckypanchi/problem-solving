import sys

input = sys.stdin.readline


n = int(input())
jumps = [0] + [list(map(int, input().split())) for _ in range(n - 1)]
k = int(input())

dp = [0] * (n + 1)

if n >= 2:
    dp[2] = jumps[1][0]

for i in range(3, n + 1):
    dp[i] = min(dp[i - 1] + jumps[i - 1][0], dp[i - 2] + jumps[i - 2][1])

answer = dp[-1]

if n >= 4:
    for i in range(4, n + 1):
        if dp[i - 3] + k < dp[i]:
            dpp = dp[:]
            dpp[i] = dpp[i - 3] + k
            for j in range(i + 1, n + 1):
                dpp[j] = min(dpp[j - 1] + jumps[j - 1][0], dpp[j - 2] + jumps[j - 2][1])
            answer = min(answer, dpp[-1])

print(answer)
