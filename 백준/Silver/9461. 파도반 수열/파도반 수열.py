import sys

input = sys.stdin.readline


tc = int(input())

for _ in range(tc):
    n = int(input())

    dp = [1, 1, 1, 2, 2, 3, 4, 5, 7, 9]

    if n > 9:
        for i in range(10, n):
            dp.append(dp[i - 1] + dp[i - 5])

    print(dp[n - 1])
