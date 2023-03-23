import sys

input = sys.stdin.readline


n = int(input())
numbers = list(map(int, input().split()))
target = numbers[-1]
numbers = numbers[:-1]

dp = [[0] * 21 for _ in range(n - 1)]
dp[0][numbers[0]] = 1

for i in range(1, n - 1):
    for prev in range(21):
        for nxt in [prev + numbers[i], prev - numbers[i]]:
            if dp[i - 1][prev] != 0 and 0 <= nxt < 21:
                dp[i][nxt] += dp[i - 1][prev]


print(dp[n - 2][target])