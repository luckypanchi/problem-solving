import sys
import heapq

input = sys.stdin.readline


tc = int(input())

for _ in range(tc):
    k = int(input())
    fs = [0] + list(map(int, input().split()))
    dp = [[0] * (k + 1) for _ in range(k + 1)]
    s = [0] * (k + 1)
    for i in range(1, k + 1):
        s[i] = s[i - 1] + fs[i]

    for length in range(1, k + 1):
        for start in range(1, k - length + 1):
            dp[start][start + length] = (
                min(
                    [
                        dp[start][start + t] + dp[start + t + 1][start + length]
                        for t in range(length)
                    ]
                )
                + s[start + length]
                - s[start - 1]
            )

    print(dp[1][k])