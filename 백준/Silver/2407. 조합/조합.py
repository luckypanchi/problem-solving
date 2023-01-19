import sys

input = sys.stdin.readline


n, m = map(int, input().split())

dp = [0] * (n + 1)

dp[0] = 1


def fac(n):
    if dp[n] == 0:
        dp[n] = n * fac(n - 1)

    return dp[n]


print(fac(n) // fac(n - m) // fac(m))
