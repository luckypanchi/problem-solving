import sys

input = sys.stdin.readline


def solve(curr):
    if dp[curr] != -1:
        return dp[curr]

    dp[curr] = 0
    for take in [1, 3]:
        if solve(curr - take) == 0:
            dp[curr] = 1

    return dp[curr]


n = int(input())
dp = [-1] * 1001

dp[1] = 0
dp[3] = 0

solve(n)
if dp[n] == 0:
    print("CY")
else:
    print("SK")