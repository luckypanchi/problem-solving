import sys

input = sys.stdin.readline

tc = int(input())

dp = [0] * 31


def fac(num):
    if num == 1 or num == 0:
        return 1
    if dp[num] == 0:
        dp[num] = num * fac(num - 1)
    return dp[num]


for _ in range(tc):
    n, m = map(int, input().split())
    print(fac(m) // (fac(n) * fac(m - n)))
