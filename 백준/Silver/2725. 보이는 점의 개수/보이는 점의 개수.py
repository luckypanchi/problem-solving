import sys

input = sys.stdin.readline


def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a % b)


dp = [0] * 1001
dp[1] = 3
for i in range(2, 1001):
    dp[i] = dp[i - 1]
    for j in range(1, i):
        if gcd(i, j) == 1:
            dp[i] += 2


tc = int(input())
for _ in range(tc):
    n = int(input())
    print(dp[n])