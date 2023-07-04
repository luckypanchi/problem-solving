import sys

input = sys.stdin.readline


tc = int(input())


for _ in range(tc):
    n = int(input())
    coins = list(map(int, input().split()))
    target = int(input())

    dp = [0] * (target + 1)
    dp[0] = 1

    for coin in coins:
        for i in range(1, target + 1):
            if 0 <= i - coin:
                dp[i] += dp[i - coin]

    print(dp[target])