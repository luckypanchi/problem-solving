import sys

input = sys.stdin.readline

INF = float("inf")

n = int(input())
numbers = [0] + list(map(int, input().split()))

answer = -INF
dp = [[0] * 2 for _ in range(n + 1)]

dp[0][0] = min(numbers[1], 0)

if n == 1:
    print(numbers[1])
    sys.exit(0)

for i in range(1, n + 1):
    dp[i][0] = max(numbers[i], numbers[i] + dp[i - 1][0])
    dp[i][1] = max(dp[i - 1][0], numbers[i] + dp[i - 1][1])
    answer = max(answer, dp[i][0], dp[i][1])


print(answer)