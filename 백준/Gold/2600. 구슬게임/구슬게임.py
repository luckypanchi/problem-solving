import sys

input = sys.stdin.readline


def solve(basket1, basket2):
    if dp[basket1][basket2] != -1:
        return dp[basket1][basket2]

    dp[basket1][basket2] = 0

    for take in marbles:
        if 0 <= basket1 - take and solve(basket1 - take, basket2) == 0:
            dp[basket1][basket2] = 1
            return dp[basket1][basket2]
        if 0 <= basket2 - take and solve(basket1, basket2 - take) == 0:
            dp[basket1][basket2] = 1
            return dp[basket1][basket2]

    return dp[basket1][basket2]


marbles = list(map(int, input().split()))
for _ in range(5):
    k1, k2 = map(int, input().split())
    dp = [[-1] * (k2 + 1) for _ in range(k1 + 1)]
    solve(k1, k2)
    if dp[k1][k2] == 1:
        print("A")
    else:
        print("B")