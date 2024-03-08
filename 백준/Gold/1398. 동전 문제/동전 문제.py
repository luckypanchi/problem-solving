import sys

input = sys.stdin.readline

INF = float("inf")


tc = int(input())

coin = [1, 10, 25]

for _ in range(tc):
    n = int(input())

    dp = [INF] * 100
    dp[0] = 0

    for c in coin:
        for i in range(c, 100):
            dp[i] = min(dp[i], dp[i - c] + 1)

    answer = 0
    while n:
        answer += dp[n % 100]
        n //= 100

    print(answer)