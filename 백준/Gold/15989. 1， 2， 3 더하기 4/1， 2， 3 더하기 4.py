import sys

sys.setrecursionlimit(10**7)

input = sys.stdin.readline


def solve(curr, prev):
    if curr < 0:
        return 0

    if curr == 0:
        return 1

    if dp[curr][prev] != -1:
        return dp[curr][prev]

    result = 0

    for take in [1, 2, 3]:
        if prev <= take:
            result += solve(curr - take, take)

    dp[curr][prev] = result
    return result


dp = [[-1] * 4 for _ in range(10001)]
tc = int(input())
for _ in range(tc):
    n = int(input())
    print(solve(n, 0))