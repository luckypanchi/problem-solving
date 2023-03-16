import sys

input = sys.stdin.readline

INF = int(1e9)


n = int(input())
dp = [INF] * (n + 1)
prev = [0] * (n + 1)
dp[1] = 0

for num in range(2, n + 1):
    if num % 3 == 0 and dp[num // 3] + 1 < dp[num]:
        dp[num] = dp[num // 3] + 1
        prev[num] = num // 3

    if num % 2 == 0 and dp[num // 2] + 1 < dp[num]:
        dp[num] = dp[num // 2] + 1
        prev[num] = num // 2

    if dp[num - 1] + 1 < dp[num]:
        dp[num] = dp[num - 1] + 1
        prev[num] = num - 1

print(dp[n])

p = n
while p != 0:
    print(p, end=" ")
    p = prev[p]